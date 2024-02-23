package com.origemite.authserver.biz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.origemite.authserver.biz.controller.auth.vo.OrigemiteToken;
import com.origemite.authserver.cmm.ServiceCode;
import com.origemite.authserver.data.db.repo.TbUserRepo;
import com.origemite.authserver.data.db.repo.dsl.vo.UserPolicyDto;
import com.origemite.authserver.data.redis.entity.HdTokenAccess;
import com.origemite.authserver.data.redis.entity.HdTokenPolicy;
import com.origemite.authserver.data.redis.entity.HdTokenRefresh;
import com.origemite.authserver.data.redis.repo.HdTokenAccessRepo;
import com.origemite.authserver.data.redis.repo.HdTokenPolicyRepo;
import com.origemite.authserver.data.redis.repo.HdTokenRefreshRepo;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.accessMillis}")
    private long accessMillis;

    @Value("${jwt.refreshMillis}")
    private long refreshMillis;

    private final HdTokenAccessRepo hdTokenAccessRepo;
    private final HdTokenRefreshRepo hdTokenRefreshRepo;
    private final HdTokenPolicyRepo hdTokenPolicyRepo;
    private final TbUserRepo tbUserRepo;

    private String generateAccessToken(String usrId) {
        return Jwts.builder()
                .setSubject(usrId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + accessMillis))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    private String generateRefreshToken(String usrId) {
        return Jwts.builder()
                .setSubject(usrId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + refreshMillis))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private OrigemiteToken generateToken(String usrId) {
        return OrigemiteToken.builder()
                .accessToken(generateAccessToken(usrId))
                .refreshToken(generateRefreshToken(usrId))
                .build();
    }

    public String signin(String usrId) throws JsonProcessingException {
        OrigemiteToken origemiteToken = generateToken(usrId);
        long accessSec = accessMillis / 1000;
        long refreshSec = refreshMillis / 1000;

        hdTokenRefreshRepo.save(HdTokenRefresh.builder()
                .usrId(usrId)
                .tknResresh(origemiteToken.getRefreshToken())
                .expiration(refreshSec)
                .build());

        hdTokenAccessRepo.save(HdTokenAccess.builder()
                .tknAccess(origemiteToken.getAccessToken())
                .tknResresh(origemiteToken.getRefreshToken())
                .expiration(accessSec)
                .build());

        List<UserPolicyDto> userPolicy = tbUserRepo.UserPolicySelect(usrId).stream()
                .toList();

        Map<String, Set<Integer>> base = ServiceCode.policyBaseInstance();

        for (UserPolicyDto e : userPolicy) {
            Set<Integer> roles = base.get(e.getSvcId());
            roles.add(e.getSvcRole());
            base.put(e.getSvcId(), roles);
        }
        String jsonMap = new ObjectMapper().writeValueAsString(base);

        hdTokenPolicyRepo.save(HdTokenPolicy.builder()
                .tknResresh(origemiteToken.getRefreshToken())
                .svcRoles(jsonMap)
                .expiration(refreshSec)
                .build());
        return origemiteToken.getAccessToken();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(getSigningKey()).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        Jwts.parser().setSigningKey(getSigningKey()).parseClaimsJws(token);
        return !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Date getExpirationDateFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(getSigningKey()).parseClaimsJws(token).getBody();
        return claims.getExpiration();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}

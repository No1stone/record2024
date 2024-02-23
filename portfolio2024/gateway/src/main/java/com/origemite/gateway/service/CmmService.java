package com.origemite.gateway.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.origemite.gateway.data.redis.entity.HdTokenAccess;
import com.origemite.gateway.data.redis.entity.HdTokenPolicy;
import com.origemite.gateway.data.redis.repo.HdTokenAccessRepo;
import com.origemite.gateway.data.redis.repo.HdTokenPolicyRepo;
import com.origemite.gateway.data.redis.repo.HdTokenRefreshRepo;
import com.origemite.gateway.service.vo.UsrData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

import javax.security.sasl.AuthenticationException;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class CmmService {

    private final HdTokenAccessRepo hdTokenAccessRepo;
    private final HdTokenRefreshRepo hdTokenRefreshRepo;
    private final HdTokenPolicyRepo hdTokenPolicyRepo;

    public boolean isAllow(String path, Set<String> allowList){
        return allowList.stream().anyMatch(allowedPath ->
                path.matches(allowedPath.replaceAll("\\*\\*", ".*"))
        );
    }


    public String jwtValid(ServerHttpRequest req) throws AuthenticationException {

        if (!req.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            throw new AuthenticationException();
        }
        //Authorization
        final String authHeader = req.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
        final String jwt = authHeader.substring(7);
        return jwt;
    }

    public UsrData tokenToPolicy(String token) throws AuthenticationException, JsonProcessingException {
        HdTokenAccess tokens = hdTokenAccessRepo.findById(token)
                .orElseThrow(() -> new AuthenticationException("존재하지 않은 토큰입니다."));
        HdTokenPolicy svcRoles = hdTokenPolicyRepo.findById(tokens.getTknResresh())
                .orElseThrow(() -> new AuthenticationException("존재하지 않은 토큰입니다."));
    return UsrData.builder()
            .hdTokenAccess(tokens)
            .hdTokenPolicy(svcRoles)
            .build();
    }

}

package com.origemite.gateway.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.origemite.gateway.service.vo.UsrData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

import javax.security.sasl.AuthenticationException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final CmmService cmmService;


    public boolean isJwtValid(ServerHttpRequest req) throws AuthenticationException, JsonProcessingException {
        log.info("필터 진입 ");
        log.info("getHeaders - - {}", new Gson().toJson(req.getHeaders()));
        String uri = req.getURI().toString();
        String path = req.getPath().toString();
        HttpMethod method = req.getMethod();
        log.info("URI -- {} ", uri);
        log.info("path -- {} ", path);

        if (cmmService.isAllow(path, AuthServerAllowPath.ALLOWED_PATHS)) {
            return true;
        }
        String token = cmmService.jwtValid(req);
        UsrData usrData = cmmService.tokenToPolicy(token);


        /**
         * Authserver 권한 검증
         */
        if (method.name().equals(HttpMethod.GET.name())) {
            if (usrData.getRoles().get("AUTHSERVER").stream().allMatch(e -> e >= 1)) {
                return true;
            }
        } else {
            if (usrData.getRoles().get("AUTHSERVER").stream().allMatch(e -> e >= 2)) {
                return true;
            }
        }

        return true;
    }
}
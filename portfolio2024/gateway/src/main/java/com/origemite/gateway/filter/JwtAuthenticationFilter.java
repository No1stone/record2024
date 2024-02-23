package com.origemite.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.origemite.gateway.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import javax.security.sasl.AuthenticationException;

@Component
@Slf4j
public class JwtAuthenticationFilter extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {

    private final AuthService authService;

    public JwtAuthenticationFilter(AuthService jwtService) {
        super(Config.class);
        this.authService = jwtService;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            try {
                if (!isJwtValid(exchange)) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
            } catch (AuthenticationException | JsonProcessingException e) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
            return chain.filter(exchange);
        };
    }

    private boolean isJwtValid(ServerWebExchange exchange) throws AuthenticationException, JsonProcessingException {

        ServerHttpRequest req = exchange.getRequest();
        ServerHttpResponse res = exchange.getResponse();
        String uri = req.getURI().toString();
        String path = req.getPath().toString();
        log.info("path = "+ path);
        if (path.startsWith("/authserver")) {
            String newPath = path.replaceFirst("/authserver", "");
            ServerHttpRequest newRequest = req.mutate()
                    .path(newPath)
                    .build();
            log.info("newPath = "+ newPath);
            // 새로운 요청 객체로 ServerWebExchange 교체
            ServerWebExchange newExchange = exchange.mutate()
                    .request(newRequest)
                    .build();
            boolean result = authService.isJwtValid(newExchange.getRequest());
        }
        return true; // 임시로 항상 true를 반환
    }

    public static class Config {
        // 필터 구성에 사용될 설정을 정의할 수 있음
    }

}

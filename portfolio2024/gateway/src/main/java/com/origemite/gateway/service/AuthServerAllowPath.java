package com.origemite.gateway.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AuthServerAllowPath {

    public static final Set<String> ALLOWED_PATHS = new HashSet<>(Arrays.asList(
            "/auth/api/v1/token/**",
            "/auth/api/v1/test/**",
            "/auth/swagger-ui/**",
            "/auth/swagger-resources/**",
            "/auth/favicon.ico",
            "/auth/v3/api-docs/**"
    ));

}

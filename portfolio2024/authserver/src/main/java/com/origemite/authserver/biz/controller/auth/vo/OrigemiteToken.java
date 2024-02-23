package com.origemite.authserver.biz.controller.auth.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrigemiteToken {

    private String accessToken;
    private String refreshToken;

    @Builder
    public OrigemiteToken(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}

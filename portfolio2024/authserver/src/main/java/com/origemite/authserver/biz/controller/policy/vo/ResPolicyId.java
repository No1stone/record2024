package com.origemite.authserver.biz.controller.policy.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResPolicyId {

    private String plcId;

    @Builder
    public ResPolicyId(String plcId) {
        this.plcId = plcId;
    }
}

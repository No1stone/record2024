package com.origemite.authserver.biz.controller.user.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResUserPolicySelect {

    private String usrId;
    private String plcId;

    @Builder
    public ResUserPolicySelect(String usrId, String plcId) {
        this.usrId = usrId;
        this.plcId = plcId;
    }
}

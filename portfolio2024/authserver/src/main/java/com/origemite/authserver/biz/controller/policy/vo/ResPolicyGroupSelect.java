package com.origemite.authserver.biz.controller.policy.vo;

import com.origemite.authserver.cmm.ServiceCode;
import com.origemite.authserver.cmm.ev.EnumValidator;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResPolicyGroupSelect {

    private String plcId;
    private String svcId;
    private  int svcRole;

    @Builder
    public ResPolicyGroupSelect(String plcId, String svcId, int svcRole) {
        this.plcId = plcId;
        this.svcId = svcId;
        this.svcRole = svcRole;
    }


}

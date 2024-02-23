package com.origemite.authserver.biz.controller.policy.vo;

import com.origemite.authserver.cmm.ServiceCode;
import com.origemite.authserver.cmm.ev.EnumValidator;
import com.origemite.authserver.data.db.entity.TbPolicyGroup;
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
public class ReqPolicyGroupSelect {

    @Schema(name = "plcId", description = "정책", example = "plc", required = false, type = "String", maxLength = 50)
//    @NotBlank(message = "정책 아이디는  필수값입니다.")
    @Size(max = 50, message = "50자를 초과 할 수 없습니다.")
    private String plcId;

    @Schema(name = "svcId", description = "서비스아이디", example = "plc", required = false, type = "String", maxLength = 50)
//    @NotBlank(message = "서비스 아이디는  필수값입니다.")
    @Size(max = 50, message = "50자를 초과 할 수 없습니다.")
//    @EnumValidator(enumClazz = ServiceCode.class, message = "검색 값을 확인해 주세요.")
    private String svcId;

    @Builder
    public ReqPolicyGroupSelect(String plcId, String svcId) {
        this.plcId = plcId;
        this.svcId = svcId;
    }


}

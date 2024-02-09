package com.origemite.authserver.biz.controller.policy.vo;

import com.origemite.authserver.cmm.MyFormatter;
import com.origemite.authserver.cmm.ServiceCode;
import com.origemite.authserver.cmm.ev.EnumValidator;
import com.origemite.authserver.data.db.entity.TbPolicy;
import com.origemite.authserver.data.db.entity.TbPolicyGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Validated
public class ReqPolicyGroupSave {

    @Schema(name = "plcId", description = "정책", example = "plc", required = true, type = "String", maxLength = 50)
    @NotBlank(message = "정책 아이디는  필수값입니다.")
    @Size(max = 50, message = "50자를 초과 할 수 없습니다.")
    private String plcId;

    @Schema(name = "svcId", description = "서비스아이디", example = "plc", required = true, type = "String", maxLength = 50)
    @NotBlank(message = "서비스 아이디는  필수값입니다.")
    @Size(max = 50, message = "50자를 초과 할 수 없습니다.")
    @EnumValidator(enumClazz = ServiceCode.class, message = "검색 값을 확인해 주세요.")
    private String svcId;

    @Schema(name = "svcRole", description = "롤", example = "1", required = false, type = "Integer", maxLength = 2)
    @Max(message = "99를 초과 할 수 없습니다.", value = 99)
    @NotNull(message = "롤은 필수값입니다.")
    private int svcRole;

    @Builder
    public ReqPolicyGroupSave(String plcId, String svcId, int svcRole) {
        this.plcId = plcId;
        this.svcId = svcId;
        this.svcRole = svcRole;
    }

    public TbPolicyGroup toTbPolicyGroup(){
        return TbPolicyGroup.builder()
                .plcId(this.plcId)
                .svcId(this.svcId)
                .svcRole(this.svcRole)
                .build();
    }
}

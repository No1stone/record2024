package com.origemite.authserver.biz.controller.policy.vo;

import com.google.gson.Gson;
import com.origemite.authserver.advice.excep.CustomNotFoundException;
import com.origemite.authserver.cmm.ServiceCode;
import com.origemite.authserver.cmm.ev.EnumValidator;
import com.origemite.authserver.data.db.entity.TbPolicyGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Validated
public class ReqPolicyGroupBulkSave {

    @Schema(name = "plcId", description = "정책", example = "plc", required = true, type = "String", maxLength = 50)
    @NotBlank(message = "정책 아이디는 필수 입니다.")
    @Size(max = 50, message = "50자를 초과 할 수 없습니다.")
    private String plcId;

    private HashMap<String, Set<Integer>> policyRole;

    @Builder
    public ReqPolicyGroupBulkSave(String plcId, HashMap<String, Set<Integer>> policyRole) {
        this.plcId = plcId;
        this.policyRole = policyRole;
    }

    public List<TbPolicyGroup> toValidateTB() throws CustomNotFoundException {
        List<TbPolicyGroup> result = new ArrayList<>();

        for (Map.Entry e : policyRole.entrySet()) {

            String svcId = e.getKey().toString();
            if (!ServiceCode.isName(svcId)) {
                throw new CustomNotFoundException("서비스아이디를 확인해주세요");
            }
            Object value = e.getValue();
            if (!(value instanceof Set)) {
                throw new CustomNotFoundException("올바르지 않은 형식의 데이터입니다. 정책 역할은 Set<Integer> 타입이어야 합니다.");
            }

            @SuppressWarnings("unchecked")
            Set<Integer> roles = (Set<Integer>) value;

            for (Integer f : roles) {
                result.add(TbPolicyGroup.builder()
                        .plcId(this.plcId)
                        .svcId(svcId)
                        .svcRole(f)
                        .build());
            }
        }
        return result;
    }



}

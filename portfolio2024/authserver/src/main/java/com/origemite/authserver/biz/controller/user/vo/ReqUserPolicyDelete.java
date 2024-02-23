package com.origemite.authserver.biz.controller.user.vo;

import com.origemite.authserver.data.db.entity.TbUserPolicy;
import com.origemite.authserver.data.db.entity.id.TbUserPolicyId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReqUserPolicyDelete {

    private String usrId;
    private String plcId;

    @Builder
    public ReqUserPolicyDelete(String usrId, String plcId) {
        this.usrId = usrId;
        this.plcId = plcId;
    }

    public TbUserPolicyId toUserPolicy(){
        return TbUserPolicyId.builder()
                .usrId(this.usrId)
                .plcId(this.plcId)
                .build();
    }
}

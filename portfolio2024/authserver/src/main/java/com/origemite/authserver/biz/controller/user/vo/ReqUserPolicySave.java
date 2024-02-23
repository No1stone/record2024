package com.origemite.authserver.biz.controller.user.vo;

import com.origemite.authserver.data.db.entity.TbUserPolicy;
import com.origemite.authserver.data.db.repo.TbUserPolicyRepo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReqUserPolicySave {

    private String usrId;
    private String plcId;

    @Builder
    public ReqUserPolicySave(String usrId, String plcId) {
        this.usrId = usrId;
        this.plcId = plcId;
    }

    public TbUserPolicy toUserPolicy(){
        return TbUserPolicy.builder()
                .usrId(this.usrId)
                .plcId(this.plcId)
                .build();
    }
}

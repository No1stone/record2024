package com.origemite.authserver.data.db.entity;

import com.origemite.authserver.biz.controller.user.vo.ResUserPolicySelect;
import com.origemite.authserver.data.db.entity.id.TbUserPolicyId;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Table(name = "TB_USER_POLICY")
@Entity
@Setter
@NoArgsConstructor
@DynamicUpdate
@IdClass(TbUserPolicyId.class)
public class TbUserPolicy {

    @Id
    @Column(name = "USR_ID", nullable = false, length = 50)
    private String usrId;

    @Id
    @Column(name = "PLC_ID", nullable = false, length = 50)
    private String plcId;

    @Builder
    public TbUserPolicy(String usrId, String plcId) {
        this.usrId = usrId;
        this.plcId = plcId;
    }

    public ResUserPolicySelect toUserPolicySelect(){
        return ResUserPolicySelect.builder()
                .plcId(this.plcId)
                .usrId(this.usrId)
                .build();
    }
}

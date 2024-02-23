package com.origemite.authserver.data.db.entity.id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class TbPolicyGroupId implements Serializable {

    private String plcId;

    private String svcId;

    private int svcRole;

    @Builder
    public TbPolicyGroupId(String plcId, String svcId, int svcRole) {
        this.plcId = plcId;
        this.svcId = svcId;
        this.svcRole = svcRole;
    }
}

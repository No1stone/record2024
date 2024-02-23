package com.origemite.authserver.data.db.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class TbUserPolicyId implements Serializable {

    private String usrId;
    private String plcId;

    @Builder
    public TbUserPolicyId(String usrId, String plcId) {
        this.usrId = usrId;
        this.plcId = plcId;
    }
}

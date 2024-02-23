package com.origemite.authserver.biz.controller.policy.vo;

import com.origemite.authserver.cmm.MyFormatter;
import com.origemite.authserver.data.db.entity.TbPolicy;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ResPolicySelect {

    private String plcId;
    private String ctmId;
    private String plcName;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    @Builder
    public ResPolicySelect(String plcId, String ctmId, String plcName, LocalDateTime createAt, LocalDateTime updateAt) {
        this.plcId = plcId;
        this.ctmId = ctmId;
        this.plcName = plcName;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}

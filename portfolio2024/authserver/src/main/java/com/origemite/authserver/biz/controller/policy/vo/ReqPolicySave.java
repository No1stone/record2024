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
public class ReqPolicySave {

    private String ctmId;
    private String plcName;

    @Builder
    public ReqPolicySave(String ctmId, String plcName) {
        this.ctmId = ctmId;
        this.plcName = plcName;
    }

    public TbPolicy toPolicy() {
        String[] random = UUID.randomUUID().toString().split("-");
        String id = "PLC_"+ MyFormatter.yyyyMMdd()+"_"+random[0]+random[1];
        return TbPolicy.builder()
                .plcId(id)
                .ctmId(this.ctmId)
                .plcName(this.plcName)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();
    }

}

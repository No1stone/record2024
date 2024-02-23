package com.origemite.authserver.data.db.repo.dsl.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserPolicyDto {

    private String svcId;
    private int svcRole;

    @Builder
    public UserPolicyDto(String svcId, int svcRole) {
        this.svcId = svcId;
        this.svcRole = svcRole;
    }

}

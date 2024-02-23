package com.origemite.gateway.service.vo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.origemite.gateway.data.redis.entity.HdTokenAccess;
import com.origemite.gateway.data.redis.entity.HdTokenPolicy;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UsrData {

    private HdTokenAccess hdTokenAccess;
    private HdTokenPolicy hdTokenPolicy;
    private Map<String, Set<Integer>> roles;
    @Builder
    public UsrData(HdTokenAccess hdTokenAccess, HdTokenPolicy hdTokenPolicy) throws JsonProcessingException {
        this.hdTokenAccess = hdTokenAccess;
        this.hdTokenPolicy = hdTokenPolicy;
        this.roles = new ObjectMapper().readValue(hdTokenPolicy.getSvcRoles()
                , new TypeReference<Map<String, Set<Integer>>>() {});
    }

}

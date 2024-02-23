package com.origemite.authserver.data.redis.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RedisHash(value = "HdTokenPolicy")
public class HdTokenPolicy {

    @Id
    private String tknResresh;

    private String svcRoles ;// 서비스 역할

    @TimeToLive
    private Long expiration;

    @Builder
    public HdTokenPolicy(String tknResresh, String svcRoles, Long expiration) {
        this.tknResresh = tknResresh;
        this.svcRoles = svcRoles;
        this.expiration = expiration;
    }
}

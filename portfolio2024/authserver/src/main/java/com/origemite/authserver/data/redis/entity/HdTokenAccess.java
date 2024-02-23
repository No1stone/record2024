package com.origemite.authserver.data.redis.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Setter
@NoArgsConstructor
@RedisHash(value = "HdTokenAccess")
public class HdTokenAccess {

    @Id
    @Indexed
    private String tknAccess;

    @Indexed
    private String tknResresh;

    @TimeToLive
    private Long expiration;

    @Builder
    public HdTokenAccess(String tknAccess, String tknResresh, Long expiration) {
        this.tknAccess = tknAccess;
        this.tknResresh = tknResresh;
        this.expiration = expiration;
    }

}

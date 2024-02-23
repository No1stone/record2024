package com.origemite.authserver.data.redis.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Setter
@NoArgsConstructor
@RedisHash(value = "HdTokenRefresh")
public class HdTokenRefresh {

    @Id
    private String tknResresh;
//    @Indexed
    private String usrId;

    @TimeToLive
    private Long expiration;
    @Builder
    public HdTokenRefresh(String tknResresh, String usrId, Long expiration) {
        this.tknResresh = tknResresh;
        this.usrId = usrId;
        this.expiration = expiration;
    }

}

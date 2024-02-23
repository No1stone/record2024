package com.origemite.authserver.mq.dto;

import jakarta.validation.Payload;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class KafkaDto<T> {
    private Schema schema;
    private T payload;

    @Builder
    public KafkaDto(Schema schema, T payload) {
        this.schema = schema;
        this.payload = payload;
    }
}

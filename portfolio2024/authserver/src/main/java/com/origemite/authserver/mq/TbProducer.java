package com.origemite.authserver.mq;

import com.origemite.authserver.mq.dto.KafkaDto;
import com.origemite.authserver.mq.dto.Schema;
import com.origemite.authserver.mq.payload.UserPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TbProducer {

    private final KafkaProducer kafkaProducer;

    public void UserPayload(UserPayload up){
        kafkaProducer.send("origemitedb", KafkaDto.builder()
                .schema(Schema.UserSchema())
                .payload(up)
                .build()
        );
    }

}

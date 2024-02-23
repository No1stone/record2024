package com.origemite.authserver.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate kafkaTemplate;
    public <T> T send(String topic, T data) {
        ObjectMapper mapper = new ObjectMapper();
        String obj = "";
        try{
            obj = mapper.writeValueAsString(data);
        }
        catch (JsonProcessingException e){
            e.printStackTrace();
        }
        kafkaTemplate.send(topic, obj);
        log.info("send - {}", obj);
        return data;
    }

}

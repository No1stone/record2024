package com.origemite.authserver.mq.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
public class Schema {

    private String type;
    private List<Field> fields;
    private boolean optional;
    private String name;

    public static Schema UserSchema(){
        List<Field> fields = Arrays.asList(
            new Field("string", true, "USR_ID")
                , new Field("string",true, "CTM_ID")
                , new Field("string",true, "USR_EMAIL")
                , new Field("string",true, "USR_PASSWORD")
                , new Field("string",true, "USR_NAME")
                , new Field("string",true, "USR_DESC")
                , new Field("string",true, "USR_MOBILE")
                , new Field("int32",true, "USR_ROLE")
                , new Field("string",true, "CREATE_AT", "io.confluent.connect.avro.util.Date")
                , new Field("string",true, "UPDATE_AT", "io.confluent.connect.avro.util.Date")
        );
        return Schema.builder()
                .type("struct")
                .fields(fields)
                .optional(false)
                .name("TB_USER")
                .build();
    }

}

package com.origemite.authserver.mq.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Field {

    private String type;
    private boolean optional;
    private String field;
    private String name;

//    @Builder
    public Field(String type, boolean optional, String field, String name) {
        this.type = type;
        this.optional = optional;
        this.field = field;
        this.name = name;
    }

//    @Builder
    public Field(String type, boolean optional, String field) {
        this.type = type;
        this.optional = optional;
        this.field = field;
    }
}

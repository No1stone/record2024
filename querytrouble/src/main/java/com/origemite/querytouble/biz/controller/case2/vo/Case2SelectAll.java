package com.origemite.querytouble.biz.controller.case2.vo;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Case2SelectAll {

    private String id;
    private String endPoint;
    private String and1Id;
    private String and1Status;
    private String and2Id;
    private String and2Status;

    @Builder
    public Case2SelectAll(String id, String endPoint, String and1Id, String and1Status, String and2Id, String and2Status) {
        this.id = id;
        this.endPoint = endPoint;
        this.and1Id = and1Id;
        this.and1Status = and1Status;
        this.and2Id = and2Id;
        this.and2Status = and2Status;
    }
}

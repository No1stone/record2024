package com.origemite.querytouble.biz.controller.case1.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReqCase1 {

    private Integer page;
    private Integer size;

    @Builder
    public ReqCase1(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }
}

package com.icom.naswebhook.icomnaswebhook.biz.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Nas {

    private String text;

    @Builder
    public Nas(String text) {
        this.text = text;
    }
}

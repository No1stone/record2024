package com.origemite.authserver.biz.controller.svc.vo;

import com.origemite.authserver.cmm.ServiceCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ResSVC {

    private String id;
    private String name;
    private String desc;

    @Builder
    public ResSVC(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public static List<ResSVC> toVO(){
      return ServiceCode.LIST.stream().map(e ->
                      ResSVC.builder()
                              .id(e.name())
                              .name(e.getDisplayName())
                              .desc(e.getDesc())
                              .build()
              ).collect(Collectors.toList());
    }
}

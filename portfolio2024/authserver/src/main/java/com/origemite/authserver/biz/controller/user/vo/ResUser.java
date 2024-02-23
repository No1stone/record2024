package com.origemite.authserver.biz.controller.user.vo;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ResUser {

    private String usrId;
    private String ctmId;
    private String usrEmail;
    private String usrName;
    private String usrDesc;
    private String usrMobile;
    private int usrRole;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    @Builder
    public ResUser(String usrId, String ctmId, String usrEmail, String usrName, String usrDesc, String usrMobile, int usrRole, LocalDateTime createAt, LocalDateTime updateAt) {
        this.usrId = usrId;
        this.ctmId = ctmId;
        this.usrEmail = usrEmail;
        this.usrName = usrName;
        this.usrDesc = usrDesc;
        this.usrMobile = usrMobile;
        this.usrRole = usrRole;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}

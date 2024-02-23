package com.origemite.authserver.mq.payload;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPayload {

    private String usrId;
    private String ctmId;
    private String usrEmail;
    private String usrPassword;
    private String usrName;
    private String usrDesc;
    private String usrMobile;
    private int usrRole;
    private String createAt;
    private String updateAt;


}

package com.origemite.authserver.biz.controller.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReqSignin {

    @Schema(name = "usrEmail", description = "이메일", example = "abc@def.com", required = true, type = "String", maxLength = 50)
    @Email(message = "이메일형식을 입력해주세요")
    @NotBlank(message = "이메일은 필수값입니다.")
    @Size(max = 50, message = "50자를 초과 할 수 없습니다.")
    private String email;
    private String password;

    public ReqSignin(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

package com.origemite.authserver.biz.controller.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.origemite.authserver.advice.excep.CustomBadRequestException;
import com.origemite.authserver.biz.controller.auth.vo.ReqSignin;
import com.origemite.authserver.biz.controller.auth.vo.ReqSignup;
import com.origemite.authserver.biz.controller.auth.vo.ResToken;
import com.origemite.authserver.biz.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/token")
@CrossOrigin
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResToken OrigemiteSignin(@Validated @RequestBody ReqSignin request) throws JsonProcessingException {
        return ResToken.builder().token(authenticationService.signin(request)).build();
    }

    @PostMapping("/signup")
    public ResponseEntity<ResToken> OrigemiteSignup(@Validated @RequestBody ReqSignup request)
            throws CustomBadRequestException, JsonProcessingException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResToken.builder().token(authenticationService.signup(request)).build());
    }

}

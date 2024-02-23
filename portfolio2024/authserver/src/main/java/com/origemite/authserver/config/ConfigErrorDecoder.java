package com.origemite.authserver.config;

import com.origemite.authserver.advice.excep.CustomBadRequestException;
import com.origemite.authserver.advice.excep.CustomNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.naming.AuthenticationException;

@Slf4j
public class ConfigErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        log.info("{} status : {}, body : {}", methodKey, response.status(), response.body());
        switch (response.status()) {
            case 400:
                return new CustomBadRequestException();
            case 401:
                return new AuthenticationException();
            case 403:
                return new CustomNotFoundException();
            case 404:
                return new ResponseStatusException(HttpStatus.valueOf(response.status()), "User's orders is empty.");
            case 405:
                return new ResponseStatusException(HttpStatus.valueOf(response.status()), "User's orders is empty.");
            default:
                return new Exception("Generic error");
        }

    }


}

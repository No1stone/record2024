package com.origemite.authserver.advice;


import com.origemite.authserver.advice.excep.CustomBadRequestException;
import com.origemite.authserver.advice.excep.CustomNotFoundException;
import com.origemite.authserver.advice.excep.CustomRuntimeException;
import com.origemite.authserver.advice.excep.TokenException;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class AdviceHandler {

    private final MessageSource messageSource;

    @ExceptionHandler
    public String noHandlerFoundHandle(RuntimeException e) {
        log.error(e.getMessage());
        return "cmm/error/error";
    }
    @ExceptionHandler
    public ResponseEntity CustomRuntime(CustomRuntimeException e) {
        ErrorResult er = new ErrorResult();
        er.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        er.setMessage(e.getMessage());
        log.info("excep - {}", e);
        return new ResponseEntity(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity DefaultNotFound(IllegalArgumentException e) {
        ErrorResult er = new ErrorResult();
        er.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        er.setMessage(messageSource.getMessage("info.nodata.msg", null, Locale.getDefault()));
        log.info("excep - {} {}", messageSource.getMessage("info.nodata.msg", null, Locale.getDefault()),e.getMessage());
        return new ResponseEntity(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity CustomNotFound(CustomNotFoundException e) {
        ErrorResult er = new ErrorResult();
        er.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        er.setMessage(e.getMessage());
        log.info("excep - {}", e.getMessage());
        return new ResponseEntity(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity CustomBadRequest(CustomBadRequestException e) {
        ErrorResult er = new ErrorResult();
        er.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        er.setMessage(e.getMessage());
        log.info("excep - {}", e.getMessage());
        return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity CustomBadRequest(IllegalAccessException e) {
        ErrorResult er = new ErrorResult();
        er.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        er.setMessage(messageSource.getMessage("fail.common.bad", null, Locale.getDefault()));
        log.info("excep - {}", messageSource.getMessage("fail.common.bad", null, Locale.getDefault()));
        return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity CustomBindEx(BindException ex) {
        ErrorResult er = new ErrorResult();
        String message = null;
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        for (ObjectError error : allErrors) {
            message = Arrays.stream(Objects.requireNonNull(error.getCodes()))
                    .map(c -> {
                        Object[] arguments = error.getArguments();
                        Locale locale = LocaleContextHolder.getLocale();
                        try {
                            return messageSource.getMessage(c, arguments, locale);
                        } catch (NoSuchMessageException e) {
                            return null;
                        }
                    }).filter(Objects::nonNull)
                    .findFirst()
                    .orElse(error.getDefaultMessage());
        }
        log.error("error message: {}", message);
        er.setMessage(message);
        er.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity CustomNoSuchMessage(NoSuchMessageException e) {
        ErrorResult er = new ErrorResult();
        er.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        er.setMessage(e.getMessage());
        log.info("excep - {}", e.getMessage());
        return new ResponseEntity(er, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler
    public ResponseEntity TokenMessage(TokenException e) {
        ErrorResult er = new ErrorResult();
        er.setCode(String.valueOf(HttpStatus.UNAUTHORIZED.value()));
        er.setMessage(e.getMessage());
        log.info("excep - {}", e.getMessage());
        return new ResponseEntity(er, HttpStatus.UNAUTHORIZED);
    }



    @ExceptionHandler
    public ResponseEntity VaildMessage(ConstraintViolationException e) {
        ErrorResult er = new ErrorResult();
        er.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        er.setMessage(Arrays.stream(e.getMessage().split(","))
                .map(f -> f.split(":")[1]).collect(Collectors.toList()).toString());
        log.info("excep - {}", e.getMessage());
        return new ResponseEntity(er, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity BadRequestException(BadRequestException e) {
        ErrorResult er = new ErrorResult();
        er.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        er.setMessage(e.getMessage());
        log.info("excep - {}", e.getMessage());
        return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
    }


}

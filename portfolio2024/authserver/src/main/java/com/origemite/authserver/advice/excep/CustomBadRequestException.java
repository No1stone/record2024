package com.origemite.authserver.advice.excep;

public class CustomBadRequestException extends Exception {
    public CustomBadRequestException(){super("400Default");}
    public CustomBadRequestException(String message){super(message);}
    public CustomBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}

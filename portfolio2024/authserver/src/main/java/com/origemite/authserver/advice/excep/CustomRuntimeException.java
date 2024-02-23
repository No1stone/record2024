package com.origemite.authserver.advice.excep;


public class CustomRuntimeException extends RuntimeException{

    public CustomRuntimeException(){super("Default");}
    public CustomRuntimeException(String message){super(message);}
    public CustomRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }


}

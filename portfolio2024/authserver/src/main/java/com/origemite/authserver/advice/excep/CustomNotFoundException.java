package com.origemite.authserver.advice.excep;


public class CustomNotFoundException extends Exception {
    public CustomNotFoundException() {
        super("404Default");
    }
    public CustomNotFoundException(String msg) {
        super(msg);
    }
    public CustomNotFoundException(String msg, Exception e) {
        super(msg, e);
    }

}

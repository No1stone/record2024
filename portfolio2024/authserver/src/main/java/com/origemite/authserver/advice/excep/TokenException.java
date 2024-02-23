package com.origemite.authserver.advice.excep;

public class TokenException extends Exception {
    public TokenException() {
        super("401Default");
    }
    public TokenException(String msg) {
        super(msg);
    }
    public TokenException(String msg, Exception e) {
        super(msg, e);
    }

}

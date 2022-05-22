package com.tcs.edu.exception;

public class LogException extends RuntimeException {

    public LogException(String message, Exception e) {
        super(message, e);
    }
}

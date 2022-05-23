package com.tcs.edu.service;

/**
 * The class {@code LogException} indicates conditions of {@link com.tcs.edu.domain.Message Message}
 * processing that a application might want to catch.
 *
 * <p>Subclass of {@link Exception}
 *
 * @author z.starokozhev
 */
public class LogException extends Exception {
    public LogException() {
        super();
    }

    public LogException(String message) {
        super(message);
    }

    public LogException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogException(Throwable cause) {
        super(cause);
    }

    protected LogException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

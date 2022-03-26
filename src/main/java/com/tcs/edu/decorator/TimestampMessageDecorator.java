package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * Decorator to add a timestamp
 *
 * @author k.s.savelev
 */
public class TimestampMessageDecorator {
    /**
     * Add timestamp before massage
     *
     * @param message test string
     */
    public static String decorate(String message) {
        message = Instant.now() + " " + message;
        return message;
    }
}

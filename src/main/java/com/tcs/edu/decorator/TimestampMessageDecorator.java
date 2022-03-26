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
     * @param message text string
     * @return String
     */
    public static String decorate(String message) {
        return Instant.now() + " " + message;
    }
}

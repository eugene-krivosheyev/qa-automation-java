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
    static Integer messageCount = 0;

    public static String decorate(String message) {
        messageCount++;
        String decoratedMessage =  messageCount + " " + Instant.now() + " " + message;

        return decoratedMessage;
    }
}

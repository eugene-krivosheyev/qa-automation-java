package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * Decorator to add a timestamp
 *
 * @author k.s.savelev
 */
public class TimestampMessageDecorator {

    static Integer messageCount = 0;

    /**
     * Add timestamp before massage
     *
     * @param message text string
     * @return String
     */
    public static String decorate(String message) {
        final var decoratedMessage =  String.format("%d %s %s", ++messageCount, Instant.now(), message);

        return decoratedMessage;
    }
}

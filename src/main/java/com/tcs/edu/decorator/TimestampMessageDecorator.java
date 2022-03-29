package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * Class for message decoration with timestamp
 */
public class TimestampMessageDecorator {
    static int messageCount;
    /**
     * Method for message decoration with timestamp
     * @param message string for decoration
     * @return decorated message
     */
    public static String decorate(String message) {
        messageCount++;
        final var decoratedMessage = messageCount + " " + Instant.now() + " " + message;
        return decoratedMessage;
    }
}

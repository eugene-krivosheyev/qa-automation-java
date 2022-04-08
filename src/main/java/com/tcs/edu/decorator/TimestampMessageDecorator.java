package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * Class for message decoration with timestamp
 */
public class TimestampMessageDecorator {
    private static final int PAGE_SIZE = 2;
    static int messageCount;
    /**
     * Method for message decoration with timestamp
     * @param message string for decoration
     * @return decorated message
     */
    public static String decorate(String message) {
        messageCount++;
        var decoratedMessage = String.format("%d %s %s", messageCount, Instant.now(), message);
        if (messageCount % PAGE_SIZE == 0) {
            decoratedMessage += "\n---";
        }
        return decoratedMessage;
    }
}

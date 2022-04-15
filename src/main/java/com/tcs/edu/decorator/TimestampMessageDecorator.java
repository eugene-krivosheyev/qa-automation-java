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
     * @param severity severity of message
     * @return decorated message
     */
    public static String decorate(Severity severity, String message) {
        messageCount++;
        var decoratedMessage = MessageService.concatenate(severity, messageCount, message);
        if (messageCount % PAGE_SIZE == 0) {
            decoratedMessage += "\n---";
        }
        return decoratedMessage;
    }
}

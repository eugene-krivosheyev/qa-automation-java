package com.tcs.edu.decorator;

import com.tcs.edu.domain.Severity;

import java.time.Instant;

/**
 * Class for message decoration with timestamp
 */
public class TimestampMessageDecorator implements MessageDecorator {
    private static final int PAGE_SIZE = 2;
    static int messageCount;
    /**
     * Method for message decoration with timestamp
     * @param message string for decoration
     * @param severity severity of message
     * @return decorated message
     */
    @Override
    public String decorate(Severity severity, String message) {
        messageCount++;
        var decoratedMessage = concatenate(severity, messageCount, message);
        if (messageCount % PAGE_SIZE == 0) {
            decoratedMessage += "\n---";
        }
        return decoratedMessage;
    }

    private static String concatenate(Severity severity, int messageCount, String message) {
        return String.format("%d %s %s %s", messageCount, Instant.now(), message, severityValue(severity));
    }

    public static String severityValue(Severity severity) {
        switch(severity) {
            case MINOR:
                return "()";
            case REGULAR:
                return "(!)";
            case MAJOR:
                return "(!!!)";
            default:
                return "";
        }
    }
}

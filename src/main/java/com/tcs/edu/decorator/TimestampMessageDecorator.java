package com.tcs.edu.decorator;

import static java.time.Instant.now;

/**
 * TimestampMessageDecorator work with string messages
 * <p>
 * This class add timestamp before any message
 *
 * @author Alexey Fomin
 */
public class TimestampMessageDecorator {

    /**
     * Method decorate add timestamp before message
     * <p>
     * This class add now time before any message
     *
     * @param message -- text to print
     * @return String with now timestamp
     */
    public static String decorate(String message) {
        var decoratedMessage = now() + " " + message;
        return decoratedMessage;
    }
}

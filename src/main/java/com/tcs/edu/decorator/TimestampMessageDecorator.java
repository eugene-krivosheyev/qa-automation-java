package com.tcs.edu.decorator;

import static java.time.Instant.now;

/**
 * TimestampMessageDecorator work with string messages
 * <p>
 * This class add timestamp and counter before any message
 *
 * @author Alexey Fomin
 */
public class TimestampMessageDecorator {

    public static int messageCount = 0;

    /**
     * Method decorate add timestamp and counter before message
     * <p>
     * This class add now time before any message and messageCount counter before text
     *
     * @param message -- text to print
     * @return String with now timestamp and messageCount
     */
    public static String decorate(String message) {
        final var decoratedMessage = messageCount + " " + now() + " " + message;
        return decoratedMessage;
    }
}

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

    private static int PAGE_SIZE = 0;
    public static int messageCount = 0;

    /**
     * Method decorate add timestamp and counter before message
     * <p>
     * This class add now time before any message and messageCount counter before text
     *
     * @param message -- text to print
     * @return String with now timestamp and messageCount. When return 2nd message, func return '---' string
     */
    public static String decorate(String message) {
        final var decoratedMessage = String.format("%d %s %s", messageCount, now(), message);
        if (PAGE_SIZE % 2 == 0 && PAGE_SIZE != 0) {
            PAGE_SIZE++;
            return "---" + "\n" + decoratedMessage;
        } else {
            PAGE_SIZE++;
            return decoratedMessage;
        }
    }
}

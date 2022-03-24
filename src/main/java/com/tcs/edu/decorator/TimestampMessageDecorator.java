package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * Class for message decoration with timestamp
 */
public class TimestampMessageDecorator {
    /**
     * Method for message decoration with timestamp
     * @param message string for decoration
     * @return decorated message
     */
    public static String decorate(String message) {
        return Instant.now() + " " + message;
    }
}

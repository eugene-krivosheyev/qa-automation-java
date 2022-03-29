package com.tcs.edu.decorator;

import static java.time.Instant.now;

/**
 *The {@code TimestampMessageDecorator} is used to add a system UTC timestamp to the <code>String</code>.
 *
 *@author   Zakhar Starokozhev
 */
public class TimestampMessageDecorator {
    /**
     * Adds a space-delimited timestamp to the beginning of the passed string using concatenation.
     * @param message The <code>String</code> to be decorated
     * @return The <code>String</code> decorated with a timestamp
     */
    public static String decorate(String message){
        return now() + " " + message;
    }
}

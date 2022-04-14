package com.tcs.edu.decorator;

import static com.tcs.edu.decorator.SeverityDecorator.mapToString;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;


public class MessageService {

    /**
     *
     * @param level severity level (MINOR, REGULAR, MAJOR)
     * @param message message to print
     * @return full message string
     */
    public static String process(Severity level, String message) {
            return mapToString(level, decorate(message));
    }
}

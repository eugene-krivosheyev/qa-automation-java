package com.tcs.edu.printer;

import com.tcs.edu.decorator.Severity;
import com.tcs.edu.decorator.SeverityDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;

/**
 * API massage service
 *
 * @author k.s.savelev
 */
public class MessageService {

    /**
     * Main application method. Decorating and print a message
     *
     * @param severity - enum, level massage
     * @param messages vararg, text massage
     */
    public static void print(Severity severity, String... messages) {
        for (String current : messages) {
            System.out.println(TimestampMessageDecorator.decorate(current + SeverityDecorator.mapSeverity(severity)));
        }
    }
}

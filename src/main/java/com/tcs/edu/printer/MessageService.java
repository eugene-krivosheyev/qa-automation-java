package com.tcs.edu.printer;

import com.tcs.edu.decorator.Severity;
import com.tcs.edu.decorator.SeverityDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;

/**
 * API
 *
 * @author k.s.savelev
 */
public class MessageService {

    /**
     * Main application method. Decorating and print a message
     *
     * @param severity enum
     * @param message  String
     * @param messages vararg String
     */
    public static void process(Severity severity, String message, String... messages) {
        final String severityString = SeverityDecorator.mapSeverity(severity);

        ConsolePrinter.print(TimestampMessageDecorator.decorate(message + severityString));
        for (String current : messages) {
            ConsolePrinter.print(TimestampMessageDecorator.decorate(current + severityString));
        }
    }
}

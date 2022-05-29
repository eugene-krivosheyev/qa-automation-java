package com.tcs.edu.printer;

import com.tcs.edu.decorator.Severity;
import com.tcs.edu.decorator.SeverityDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;

public class MessageService {

    public static void processMessage(Severity severity, String message, String... messages) {
        ConsolePrinter.print(TimestampMessageDecorator.decorate(SeverityDecorator.decorate(severity,message)));

        for (String messageItem: messages) {
            ConsolePrinter.print(TimestampMessageDecorator.decorate(SeverityDecorator.decorate(severity,messageItem)));
        }
    }
}

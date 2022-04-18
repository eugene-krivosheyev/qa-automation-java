package com.tcs.edu.printer;

import com.tcs.edu.decorator.Severity;
import com.tcs.edu.decorator.SeverityDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;

public class MessageService {

    public static void processMessage(Severity severity, String message) {
        ConsolePrinter.print(TimestampMessageDecorator.decorate(SeverityDecorator.decorate(severity,message)));
    }
}

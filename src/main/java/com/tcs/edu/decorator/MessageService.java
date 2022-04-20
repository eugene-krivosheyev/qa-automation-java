package com.tcs.edu.decorator;

import com.tcs.edu.printer.ConsolePrinter;
import java.time.Instant;

public class MessageService {

    public static String severityValue(Severity severity) {
        switch(severity) {
            case MINOR:
                return "()";
            case REGULAR:
                return "(!)";
            case MAJOR:
                return "(!!!)";
            default:
                return "";
        }
    }

    public static String concatenate(Severity severity, int messageCount, String message) {
        return String.format("%d %s %s %s", messageCount, Instant.now(), message, severityValue(severity));
    }

    public static void print(Severity severity, String ...messages) {
        for (String message : messages) {
            if (message != null) {
                ConsolePrinter.print(TimestampMessageDecorator.decorate(severity, message));
            }
        }
    }
    public static void print(Severity severity, MessageOrder messageOrder, String ...messages) {
        if (MessageOrder.ASC.equals(messageOrder)) {
            for (int i = 0; i < messages.length; i++) {
                if (messages[i] != null) {
                    ConsolePrinter.print(TimestampMessageDecorator.decorate(severity, messages[i]));
                }
            }
        } else {
            for (int i = messages.length - 1; i >= 0; i--) {
                if (messages[i] != null) {
                    ConsolePrinter.print(TimestampMessageDecorator.decorate(severity, messages[i]));
                }
            }
        }

    }
}

package com.tcs.edu.decorator;

import com.tcs.edu.printer.ConsolePrinter;
import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Collectors;

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

    public static void print(Severity severity, MessageOrder messageOrder, Doubling doubling, String ...messages) {
        if (Doubling.DOUBLES.equals(doubling)) {
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
        } else {
            if (MessageOrder.ASC.equals(messageOrder)) {
                if (messages[0] != null) {
                    ConsolePrinter.print(TimestampMessageDecorator.decorate(severity, messages[0]));
                }
                for (int i = 1; i < messages.length; i++) {
                    if (messages[i] != null) {
                        for (int j = 0; j < i; j++) {
                            if (messages[i].equals(messages[j])) {
                                break;
                            }
                            if (j == i - 1) {
                                ConsolePrinter.print(TimestampMessageDecorator.decorate(severity, messages[i]));
                            }
                        }
                    }
                }
            } else {
                if (messages[messages.length - 1] != null) {
                    ConsolePrinter.print(TimestampMessageDecorator.decorate(severity, messages[messages.length - 1]));
                }
                for (int i = messages.length - 2; i >= 0; i--) {
                    if (messages[i] != null) {
                        for (int j = messages.length - 1; j > i; j--) {
                            if (messages[i].equals(messages[j])) {
                                break;
                            }
                            if (j - 1 == i) {
                                ConsolePrinter.print(TimestampMessageDecorator.decorate(severity, messages[i]));
                            }
                        }
                    }
                }
            }
        }
    }



}

package com.tcs.edu.decorator;

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
}

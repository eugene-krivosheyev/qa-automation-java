package com.tcs.edu.decorator;

import java.time.Instant;

public class TimestampMessageDecorator {
    public static String decorate(String message) {
        return Instant.now() + " " + message;
    }
}

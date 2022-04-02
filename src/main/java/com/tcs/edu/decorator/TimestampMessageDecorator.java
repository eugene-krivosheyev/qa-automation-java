package com.tcs.edu.decorator;

import  java.time.Instant;

public class TimestampMessageDecorator {

    public static int messageCount;

    public static String decorator(String message){
        final var decoratedMessage = ++messageCount + " " + Instant.now() + " " + message;
        return decoratedMessage;
    }
}

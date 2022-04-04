package com.tcs.edu;

import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;
import static com.tcs.edu.decorator.TimestampMessageDecorator.messageCount;

class Application {

    public static void main(String[] args) {
        for (messageCount = 1; messageCount < 11; messageCount++) {
            System.out.println(decorate("Hello world!"));
        }
    }
}

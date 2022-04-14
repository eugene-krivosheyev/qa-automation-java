package com.tcs.edu;

import static com.tcs.edu.decorator.TimestampMessageDecorator.messageCount;
import static com.tcs.edu.printer.ConsolePrinter.print;

import com.tcs.edu.decorator.Severity;

class Application {

    public static void main(String[] args) {
        for (messageCount = 1; messageCount < 11; messageCount++) {
            print(Severity.MAJOR, "Hello world!");
        }
    }
}

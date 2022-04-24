package com.tcs.edu;

import com.tcs.edu.decorator.TimestampMessageDecorator;

/**
 * Main class: entry point
 */
class Application {
    public static void main(String[] args) {
        ConsolePrinter.print(TimestampMessageDecorator.decorate("Hello world!"));
    }
}
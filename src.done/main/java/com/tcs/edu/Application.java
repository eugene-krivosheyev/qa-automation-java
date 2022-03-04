package com.tcs.edu;

import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.printer.ConsolePrinter;

/**
 * Main class: entry point
 */
class Application {
    public static void main(String[] args) {
        ConsolePrinter.print(TimestampMessageDecorator.decorate("Hello world!"));
    }
}
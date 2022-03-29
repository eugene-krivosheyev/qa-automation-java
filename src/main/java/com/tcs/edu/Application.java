package com.tcs.edu;

import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.printer.ConsolePrinter;

class Application {
    public static void main(String[] args) {
        ConsolePrinter.print(TimestampMessageDecorator.decorate("Hello world!"));
        ConsolePrinter.print(TimestampMessageDecorator.decorate("Hello world!"));
        ConsolePrinter.print(TimestampMessageDecorator.decorate("Hello world!"));
    }
}
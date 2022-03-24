package com.tcs.edu;

import static  com.tcs.edu.decorator.TimestampMessageDecorator.decorator;
import static com.tcs.edu.printer.ConsolePrinter.print;

class Application {
    public static void main(String[] args) {
        print(decorator("Hello world!"));
    }
}
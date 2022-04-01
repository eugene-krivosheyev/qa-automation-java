package com.tcs.edu;

import static com.tcs.edu.decorator.TimestampMessageDecorator.*;
import com.tcs.edu.printer.ConsolePrinter;

class Application {
    public static void main(String[] args) {
        for (var i = 0; i<3; i++){
            ConsolePrinter.print(decorate("Hello world!"));
        }
    }
}
package com.tcs.edu;
import com.tcs.edu.decorator.Severity;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.printer.ConsolePrinter;
class Application {
    public static void main(String[] args) {
        ConsolePrinter.print(TimestampMessageDecorator.decorate( Severity.MINOR, "Hello world!"));
        ConsolePrinter.print(TimestampMessageDecorator.decorate(Severity.REGULAR, "Hello world!"));
        ConsolePrinter.print(TimestampMessageDecorator.decorate(Severity.MAJOR, "Hello world!"));
    }
}
package com.tcs.edu;
import com.tcs.edu.decorator.MessageService;
import com.tcs.edu.decorator.Severity;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.printer.ConsolePrinter;
class Application {
    public static void main(String[] args) {
        MessageService.print(Severity.MINOR, "Hello world!");
        MessageService.print(Severity.REGULAR, "Hello world!");
        MessageService.print(Severity.MAJOR, "Hello world!");
    }
}
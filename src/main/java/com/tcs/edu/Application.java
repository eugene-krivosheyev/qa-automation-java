package com.tcs.edu;
import com.tcs.edu.decorator.MessageOrder;
import com.tcs.edu.decorator.MessageService;
import com.tcs.edu.decorator.Severity;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.printer.ConsolePrinter;
class Application {
    public static void main(String[] args) {
        MessageService.print(Severity.MINOR, MessageOrder.DESC,  "Hello world! 1", "Hello again! 2", null, "Hello world! 3");
        MessageService.print(Severity.REGULAR, "Hello world!");
        MessageService.print(Severity.MAJOR, "Hello world!");
    }
}
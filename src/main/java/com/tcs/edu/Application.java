package com.tcs.edu;
import com.tcs.edu.decorator.*;
import com.tcs.edu.printer.ConsolePrinter;
class Application {
    public static void main(String[] args) {
        MessageService.print(Severity.MINOR, MessageOrder.ASC,  Doubling.DISTINCT, "Hello world! 0", "Hello world! 0", "Hello world! 1", "Hello again! 2", null, "Hello world! 3");
        MessageService.print(Severity.REGULAR, "Hello world!");
        MessageService.print(Severity.MAJOR, "Hello world!");
    }
}
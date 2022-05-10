package com.tcs.edu;
import com.tcs.edu.decorator.*;
import com.tcs.edu.domain.Message;
import com.tcs.edu.printer.ConsolePrinter;
class Application {
    public static void main(String[] args) {
        MessageService.print(MessageOrder.ASC,
                Doubling.DISTINCT,
                new Message("Hello world! 0", Severity.MINOR),
                new Message("Hello world! 0", Severity.MINOR),
                new Message("Hello world! 1", Severity.MINOR),
                new Message("Hello world! 2", Severity.MINOR),
                null,
                new Message("Hello world! 3", Severity.MINOR),
                new Message("Hello world!", Severity.REGULAR),
                new Message("Hello world!", Severity.MAJOR));
    }
}
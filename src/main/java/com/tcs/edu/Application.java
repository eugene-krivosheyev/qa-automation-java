package com.tcs.edu;

import com.tcs.edu.printer.MessageService;

import static com.tcs.edu.decorator.Severity.*;

class Application {
    public static void main(String[] args) {
        MessageService.processMessage(MINOR, "Hello world");
        MessageService.processMessage(REGULAR, "Hello world");
        MessageService.processMessage(REGULAR, "Hello world");
        MessageService.processMessage(MAJOR, "Hello world");
        MessageService.processMessage(MINOR, "Hello world");
        MessageService.processMessage(MAJOR, "Hello world");
    }
}
package com.tcs.edu;

import com.tcs.edu.printer.MessageService;

import static com.tcs.edu.decorator.Severity.*;

class Application {
    public static void main(String[] args) {
        MessageService.ProcessMessage(MINOR, "Hello world");
        MessageService.ProcessMessage(REGULAR, "Hello world");
        MessageService.ProcessMessage(REGULAR, "Hello world");
        MessageService.ProcessMessage(MAJOR, "Hello world");
        MessageService.ProcessMessage(MINOR, "Hello world");
        MessageService.ProcessMessage(MAJOR, "Hello world");
    }
}
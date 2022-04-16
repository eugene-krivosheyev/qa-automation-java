package com.tcs.edu;

import static com.tcs.edu.service.MessageService.process;
import static com.tcs.edu.decorator.Severity.*;

class Application {
    public static void main(String[] args) {
        process(MAJOR, "Greetings!");
        process(REGULAR, "Nihao!", "Hey!");
        process(MINOR, "Hello!", "Hi!", "Howdy!");
        //не выводит ничего
        process(MAJOR);
    }
}
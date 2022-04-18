package com.tcs.edu;

import static com.tcs.edu.service.MessageService.print;
import static com.tcs.edu.decorator.Severity.*;

class Application {
    public static void main(String[] args) {
        print(MAJOR, "Greetings!");
        print(REGULAR, "Nihao!", "Hey!");
        print(MINOR, "Hello!", "Hi!", "Howdy!");
    }
}
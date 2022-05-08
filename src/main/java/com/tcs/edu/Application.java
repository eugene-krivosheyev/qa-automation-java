package com.tcs.edu;

import static com.tcs.edu.decorator.Doubling.*;
import static com.tcs.edu.decorator.MessageService.createMessage;
import static com.tcs.edu.decorator.MessageOrder.*;
import static com.tcs.edu.decorator.Severity.*;

class Application {

    public static void main(String[] args) {

        // Хочу оставить эту часть кода для историчности

//        for (int i = 0; i < 5; i++) {
//            Severity severity = values()[new Random().nextInt(values().length)];
//
//            process(severity, "Hello world!-ex1");
//        }
//
//        for (int i = 0; i < 2; i++) {
//            Severity severity = values()[new Random().nextInt(values().length)];
//
//            process(severity, "Hello world!_ex2_1st_message", "Hello world!_ex2_2nd_message", null, "123");
//        }

        // по убыванию
        createMessage(MINOR, DESC, "sort ascending", "1!", "2!");
        // по возрастанию
        createMessage(REGULAR, DESC, "3!", "4!");
        // без дублирования
        createMessage(MINOR, DESC, DOUBLES, "1!", "2!", "3!", "2!");
        // с дублированием
        createMessage(MAJOR, ASC, DISTINCT, "1!", "2!", "3!", "2!");
    }


}

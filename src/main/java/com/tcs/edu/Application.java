package com.tcs.edu;

import static com.tcs.edu.decorator.MessageService.process;
import static com.tcs.edu.decorator.Severity.values;

import com.tcs.edu.decorator.Severity;
import java.util.Random;

class Application {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Severity severity = values()[new Random().nextInt(values().length)];

            process(severity, "Hello world!-ex1");
        }

        for (int i = 0; i < 2; i++) {
            Severity severity = values()[new Random().nextInt(values().length)];

            process(severity, "Hello world!_ex2_1st_message", "Hello world!_ex2_2nd_message");
        }
    }
}

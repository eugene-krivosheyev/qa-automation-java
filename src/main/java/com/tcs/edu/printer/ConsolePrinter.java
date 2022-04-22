package com.tcs.edu.printer;

import static com.tcs.edu.decorator.MessageService.process;

import com.tcs.edu.decorator.Severity;

/**
 * ConsolePrinter печатает сообщение в консоль
 * <p>
 *
 * @author Alexey Fomin
 */
public class ConsolePrinter {

    /**
     * @param message -- сообщение для печати
     * @param postfix -- декоратор для печати
     */

    public static void print(String message, String postfix) {
        System.out.printf("%s %s%n", message, postfix);
    }

    public static void print(String message) {
        System.out.println(message);
    }
}

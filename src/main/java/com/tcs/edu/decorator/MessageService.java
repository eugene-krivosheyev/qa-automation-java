package com.tcs.edu.decorator;

import static com.tcs.edu.decorator.PostfixDecorator.getPostfixSeverity;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;
import static com.tcs.edu.printer.ConsolePrinter.print;

public class MessageService {

    /**
     * Класс склеивает строку в итогове сообщение
     * Умеет работать с любым количеством агрументов через varargs
     */

    private static final int PAGE_SIZE = 2;
    public static int messageCount = 0;

    /**
     * Метод занимается перенаправлением на разные способы
     * вызова метода printMessage
     * Метод принимает на вход Severity
     * и любое количество аргументов для печати
     */
    public static void process(Severity severity, String message, String... messages) {

        printMessage(severity, message);

        for (String s : messages) {
            printMessage(severity, s);
        }
    }

    /**
     *  Метод занимается отправкой на печать строки и серьезности,
     *  увеличением счетчика страниц и добавлением разделителя страниц
     *  Принимает на вход сообщение и степерь серьзности
     */
    private static void printMessage(Severity severity, String message) {

        messageCount++;

        String postfix = getPostfixSeverity(severity);
        String decoratedMessage = decorate(message);

        print(decoratedMessage, postfix);

        if (messageCount % PAGE_SIZE == 0) {
            print("---");
        }
    }
}

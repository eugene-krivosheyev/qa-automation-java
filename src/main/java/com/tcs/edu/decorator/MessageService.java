package com.tcs.edu.decorator;

import static com.tcs.edu.decorator.Doubling.DEFAULT;
import static com.tcs.edu.decorator.Doubling.DISTINCT;
import static com.tcs.edu.decorator.PostfixDecorator.getPostfixSeverity;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;
import static com.tcs.edu.printer.ConsolePrinter.print;
import java.util.Arrays;
import java.util.stream.Stream;

public class MessageService {

    /**
     * Класс склеивает строку в итогове сообщение Умеет работать с любым количеством агрументов через varargs
     */

    private static final int PAGE_SIZE = 2;
    public static int messageCount = 0;

    /**
     * Метод занимается перенаправлением на разные способы вызова метода printMessage Метод принимает на вход Severity и
     * любое количество аргументов для печати
     */
    public static void process(Severity severity, String message, String... messages) {

        printMessage(severity, message);

        for (String s : messages) {
            printMessage(severity, s);
        }
    }

    public static void createMessage(Severity severity, String message, String... additionalMessages) {
        createMessage(severity, MessageOrder.ASC, message, additionalMessages);
    }

    /**
     * Вызывается метод createMessage В консоли печатаются обработанные сообщения
     *
     * @param severity серьезность
     * @param messageOrder порядок
     * @param message сообщение
     * @param messages еще сообщения
     */
    public static void createMessage(Severity severity, MessageOrder messageOrder, String message, String... messages) {
        createMessage(severity, messageOrder, DEFAULT, message, messages);
    }

    /**
     * Создаем сообщения. Сначала проверяем характер дублирования, затем сортируем полученный результат Результат
     * печатаем
     *
     * @param severity серьезность
     * @param messageOrder порядок
     * @param doubling характер дублирования
     * @param message сообщение
     * @param messages еще сообщения
     */
    public static void createMessage(Severity severity, MessageOrder messageOrder, Doubling doubling, String message,
        String... messages) {
        String[] allMessages = Stream.concat(Stream.of(message), Stream.of(messages)).toArray(String[]::new);
        String[] refactoredMessages = refactorMessage(doubling, allMessages);
        String[] sortedMessages = sortMessages(messageOrder, refactoredMessages);
        printMessages(severity, sortedMessages);
    }

    /**
     * Сортировка сообщений
     *
     * @param messageOrder порядок сортировки по возрастанию/убыванию
     * @param messages сообщения
     * @return сообщения в нужном порядке
     */

    private static String[] sortMessages(MessageOrder messageOrder, String... messages) {
        if (messages != null) {
            String[] sortedMessages = new String[messages.length];
            switch (messageOrder) {
                case ASC: {
                    for (int i = 0; i <= messages.length - 1; i++) {
                        sortedMessages[i] = messages[i];
                    }
                    break;
                }
                case DESC: {
                    for (int i = messages.length - 1, j = 0; i >= 0; i--, j++) {
                        sortedMessages[j] = messages[i];
                    }
                }
                break;
            }
            return sortedMessages;
        } else {
            return null;
        }
    }

    /**
     * Обрабатываем сообщения в зависимости от характера дублирования
     *
     * @param doubling режим дублирования сообщений
     * @param messages сообщения
     * @return сообщения после обработки
     */

    private static String[] refactorMessage(Doubling doubling, String... messages) {
        if (messages != null) {
            String[] refactorMessages = new String[messages.length];
            switch (doubling) {
                case DOUBLES:
                case DEFAULT : {
                    refactorMessages =  messages;
                }
                break;
                case DISTINCT: {
                    refactorMessages = new String[messages.length];
                    for (int i = 0; i <= messages.length - 1; i++) {
                        if (!isMessageInArray(messages[i], refactorMessages)) {
                            refactorMessages[i] = messages[i];
                        }
                    }
                }
                break;
            }
            return refactorMessages;
        }
        return null;
    }

    /**
     * Метод занимается отправкой на печать строки и серьезности, увеличением счетчика страниц и добавлением разделителя
     * страниц Принимает на вход сообщение и степерь серьзности
     *
     * @param severity серьезность
     * @param message сообщение
     */
    private static void printMessage(Severity severity, String message) {
        if (message != null) {

            messageCount++;

            String postfix = getPostfixSeverity(severity);
            String decoratedMessage = decorate(message);

            print(decoratedMessage, postfix);

            if (messageCount % PAGE_SIZE == 0) {
                print("---");
            }
        }
    }

    /**
     * Ищем сообщение в массиве
     *
     * @param message сообщение, которое ищем в массиве
     * @param array массив для поиска
     * @return true/false
     */

    private static boolean isMessageInArray(String message, String... array) {
        boolean isMessageInArray = false;
        if (array != null) {
            for (String messageArray : array) {
                if (messageArray != null && messageArray.equals(message)) {
                    isMessageInArray = true;
                    break;
                }
            }
        }
        return isMessageInArray;
    }


    /**
     * Печатаем остальные сообщения, которые переданы
     *
     * @param severity серьезность
     * @param messages остальные сообщения
     */

    private static void printMessages(Severity severity, String... messages) {
        if (messages != null) {
            for (String current : messages) {
                printMessage(severity, current);
            }
        }
    }
}

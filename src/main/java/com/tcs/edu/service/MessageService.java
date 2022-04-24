package com.tcs.edu.service;

import com.tcs.edu.decorator.PaginationDecorator;
import com.tcs.edu.decorator.Severity;
import com.tcs.edu.decorator.SeverityMessageDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.printer.ConsolePrinter;

public class MessageService {
    /**
     * <code>messageCount</code> stores the proceeded line number
     */
    private static int messageCount;
    /**
     * <code>PAGE_SIZE</code> is a fixed message count per page.
     */
    private static final int PAGE_SIZE = 2;

    /**
     * Side effect on global {@link #messageCount} increases depending on the number of rows passed
     *
     * @param severity A parameter to denote the implication and the impact of the defect on the functionality
     * @param message  <code>String</code> to be proceeded. Disables calling without messages.
     * @param messages <code>Strings</code> to be proceeded to print.
     */
    public static void print(Severity severity, String message, String... messages) {
        if (severity == null) {
            return;
        }
        process(severity, message);
        for (String currentMessage : messages) {
            process(severity, currentMessage);
        }
    }

    /**
     * @param order Defines the order in which messages are printed.
     * @see #print(Severity, String, String...)
     */
    public static void print(Severity severity, MessageOrder order, String message, String... messages) {
        if (severity == null) {
            return;
        }
        switch (order) {
            case ASC: {
                print(severity, message, messages);
                break;
            }
            case DESC: {
                printReverse(severity, message, messages);
                break;
            }
        }
    }

    /**
     * @param doubling Presence of repeated messages.
     * @see #print(Severity, String, String...)
     */
    public static void print(Severity severity, Doubling doubling, String message, String... messages) {
        if (severity == null) {
            return;
        }
        switch (doubling) {
            case DOUBLES: {
                print(severity, message, messages);
                break;
            }
            case DISTINCT: {
                printUnique(severity, message, messages);
                break;
            }
        }
    }

    /**
     * @param doubling Presence of repeated messages.
     * @param order   Defines the order in which messages are printed.
     * @see #print(Severity, String, String...)
     */
    public static void print(Severity severity, MessageOrder order, Doubling doubling, String message, String... messages) {
        if (severity == null) {
            return;
        }
        switch (doubling) {
            case DOUBLES: {
                print(severity, order, message, messages);
                break;
            }
            case DISTINCT: {
                printUniqueReverse(severity, message, messages);
                break;
            }
        }
    }

    /**
     * Layer to print incoming data in reverse order.
     *
     * @see #print(Severity, String, String...)
     */
    private static void printReverse(Severity severity, String message, String... messages) {
        String[] messagesList = concatMessageToArray(message, messages);
        for (int i = messagesList.length; i > 0; i--) {
            process(severity, messagesList[i - 1]);
        }
    }

    /**
     * Layer for printing unique messages from incoming data.
     *
     * @see #print(Severity, String, String...)
     */
    private static void printUnique(Severity severity, String message, String... messages) {
        String[] messagesList = concatMessageToArray(message, messages);
        String[] temp = new String[messagesList.length];
        for (int i = 0; i < messages.length; i++) {
            boolean flag = true;
            for (int k = 0; k < messages.length; k++) {
                if (messagesList[i] == null || messagesList[i].equals(temp[k])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                process(severity, messagesList[i]);
                temp[i] = messagesList[i];
            }
        }
    }

    /**
     * Layer for printing unique messages from incoming data in reverse order.
     *
     * @see #print(Severity, String, String...)
     */
    private static void printUniqueReverse(Severity severity, String message, String... messages) {
        String[] messagesList = concatMessageToArray(message, messages);
        String[] temp = new String[messagesList.length];
        for (int i = messages.length; i >= 0; i--) {
            boolean flag = true;
            for (int k = messages.length; k >= 0; k--) {
                if (messagesList[i] == null || messagesList[i].equals(temp[k])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                process(severity, messagesList[i]);
                temp[i] = messagesList[i];
            }
        }
    }

    /**
     * Adds a string to an array of strings
     *
     * @param message  - String to be put in array
     * @param messages - array of Strings
     */
    private static String[] concatMessageToArray(String message, String... messages) {
        String[] messagesList = new String[messages.length + 1];
        messagesList[0] = message;
        System.arraycopy(messages, 0, messagesList, 1, messages.length);
        return messagesList;
    }


    /**
     * Side effect on global {@link #messageCount} - increment.
     * Glues a decorated string with an ordinal number.
     * Includes pagination. The page size is determined by {@link #PAGE_SIZE}.
     * Prints out the result.
     *
     * @param severity       A parameter to denote the implication and the impact of the defect on the functionality
     * @param currentMessage <code>String</code> to be proceeded to print
     */
    private static void process(Severity severity, String currentMessage) {
        //7.1 awaiting for try/catch
        if (currentMessage == null) {
            return;
        }
        messageCount++;
        currentMessage = TimestampMessageDecorator.decorate(currentMessage);
        currentMessage = SeverityMessageDecorator.decorate(severity, currentMessage);
        if (messageCount % PAGE_SIZE == 0) {
            currentMessage = PaginationDecorator.decorate(currentMessage);
        }
        currentMessage = messageCount + " " + currentMessage;
        ConsolePrinter.print(currentMessage);
    }

}

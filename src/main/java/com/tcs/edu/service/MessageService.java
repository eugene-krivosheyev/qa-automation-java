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
        process(severity, concatMessageToArray(message, messages));
    }

    /**
     * @param order Defines the order in which messages are printed.
     * @see #print(Severity, String, String...)
     */
    public static void print(Severity severity, MessageOrder order, String message, String... messages) {
        messages = processReverse(order, concatMessageToArray(message, messages));
        process(severity, messages);
    }

    /**
     * @param doubling Presence of repeated messages.
     * @see #print(Severity, String, String...)
     */
    public static void print(Severity severity, Doubling doubling, String message, String... messages) {
        messages = processUnique(doubling, concatMessageToArray(message, messages));
        process(severity, messages);
    }

    /**
     * @param doubling Presence of repeated messages.
     * @param order    Defines the order in which messages are printed.
     * @see #print(Severity, String, String...)
     */
    public static void print(Severity severity, MessageOrder order, Doubling doubling, String message, String... messages) {
        messages = processReverse(order, concatMessageToArray(message, messages));
        messages = processUnique(doubling, messages);
        process(severity, messages);
    }

    /**
     * Outputs an array in the passed order.
     *
     * @param messages array of <code>String</>s to filter
     * @param order    the order of messages in the transmitted array
     * @return filtered array of <code>String</>s
     */
    private static String[] processReverse(MessageOrder order, String[] messages) {
        if (order == MessageOrder.DESC) {
            String[] reversedList = new String[messages.length];
            int reversedIndex = 0;
            for (int i = messages.length; i > 0; i--) {
                reversedList[reversedIndex++] = messages[i - 1];
            }
            return reversedList;
        } else {
            return messages;
        }
    }

    /**
     * Returns array passed with or without duplicated messages depending on {@link Doubling} passed.
     *
     * @param messages array of <code>String</>s to filter
     * @param doubles  {@link Doubling} filter type
     * @return filtered array of <code>String</>s
     */
    private static String[] processUnique(Doubling doubles, String[] messages) {
        if (doubles == Doubling.DISTINCT) {
            String[] tempList = new String[messages.length];
            String[] uniqueList = new String[messages.length];
            int lastIndex = messages.length - 1;
            for (int i = 0; i < lastIndex; i++) {
                boolean flag = true;
                for (int k = 0; k < lastIndex; k++) {
                    if (messages[i] == null || messages[i].equals(tempList[k])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    uniqueList[i] = messages[i];
                    tempList[i] = messages[i];
                }
            }
            return uniqueList;
        } else {
            return messages;
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
     * Side effect on global {@link #messageCount} - increment for each message passed in.
     * Glues an each decorated string with an ordinal number.
     * Includes pagination. The page size is determined by {@link #PAGE_SIZE}.
     * Prints out the result.
     *
     * @param messages array of <code>Strings</code> to be proceeded to print
     */
    private static void process(Severity severity, String[] messages) {
        if (severity == null) {
            return;
        }
        for (String message : messages) {
            if (message == null) {
                continue;
            }
            messageCount++;
            message = TimestampMessageDecorator.decorate(message);
            message = SeverityMessageDecorator.decorate(severity, message);
            if (messageCount % PAGE_SIZE == 0) {
                message = PaginationDecorator.decorate(message);
            }
            ConsolePrinter.print(messageCount + " " + message);
        }
    }
}


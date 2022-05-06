package com.tcs.edu.service;

import com.tcs.edu.decorator.PaginationDecorator;
import com.tcs.edu.decorator.SeverityMessageDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.Message;
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
     * @param message  <code>Message</code> to be proceeded. Disables calling without messages.
     * @param messages <code>Messages</code> to be proceeded to print.
     */
    public static void print(Message message, Message... messages) {
        process(concatMessageToArray(message, messages));
    }

    /**
     * @param order Defines the order in which messages are printed.
     * @see #print(Message, Message...)
     */
    public static void print(MessageOrder order, Message message, Message... messages) {
        messages = processReverse(order, concatMessageToArray(message, messages));
        process(messages);
    }

    /**
     * @param doubling Presence of repeated messages.
     * @see #print(Message, Message...)
     */
    public static void print(Doubling doubling, Message message, Message... messages) {
        messages = processUnique(doubling, concatMessageToArray(message, messages));
        process(messages);
    }

    /**
     * @param doubling Presence of repeated messages.
     * @param order    Defines the order in which messages are printed.
     * @see #print(Message, Message...)
     */
    public static void print(MessageOrder order, Doubling doubling, Message message, Message... messages) {
        messages = processReverse(order, concatMessageToArray(message, messages));
        messages = processUnique(doubling, messages);
        process(messages);
    }

    /**
     * Outputs an array in the passed order.
     *
     * @param messages array of <code>Message</>s to filter
     * @param order    the order of messages in the transmitted array
     * @return filtered array of <code>Message</>s
     */
    private static Message[] processReverse(MessageOrder order, Message[] messages) {
        if (order == MessageOrder.DESC) {
            Message[] reversedList = new Message[messages.length];
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
     * @param messages array of <code>Message</>s to filter
     * @param doubles  {@link Doubling} filter type
     * @return filtered array of <code>Message</>s
     */
    private static Message[] processUnique(Doubling doubles, Message[] messages) {
        if (doubles == Doubling.DISTINCT) {
            Message[] tempList = new Message[messages.length];
            Message[] uniqueList = new Message[messages.length];
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
     * Adds a Message to an array of Messages
     *
     * @param message  - Message to be put in array
     * @param messages - array of Messages
     */
    private static Message[] concatMessageToArray(Message message, Message... messages) {
        Message[] messagesList = new Message[messages.length + 1];
        messagesList[0] = message;
        System.arraycopy(messages, 0, messagesList, 1, messages.length);
        return messagesList;
    }

    /**
     * Side effect on global {@link #messageCount} - increment for each message passed in.
     * Glues an each decorated Message with an ordinal number.
     * Includes pagination. The page size is determined by {@link #PAGE_SIZE}.
     * Prints out the result.
     *
     * @param messages array of <code>Messages</code> to be proceeded to print
     */
    private static void process(Message[] messages) {
        for (Message message : messages) {
            if (message == null || message.getBody() == null || message.getCurrentSeverity() == null) {
                continue;
            }
            messageCount++;
            String content = message.getBody();
            content = TimestampMessageDecorator.decorate(content);
            content = SeverityMessageDecorator.decorate(message.getCurrentSeverity(), content);
            if (messageCount % PAGE_SIZE == 0) {
                content = PaginationDecorator.decorate(content);
            }
            ConsolePrinter.print(messageCount + " " + content);
        }
    }
}


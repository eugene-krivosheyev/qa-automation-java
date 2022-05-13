package com.tcs.edu.service;

import com.tcs.edu.decorator.MessageDecorator;
import com.tcs.edu.decorator.TypographicMessageDecorator;
import com.tcs.edu.decorator.SeverityMessageDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.printer.MessagePrinter;

import java.util.Objects;

/**
 * {@code OrderedDistinctedMessageService} processes decorated messages with typography and severity labels to print.
 * Allows to specify the order and/or filtering for repetitions.
 *
 * @author Zakhar Starokozhev
 */
public final class OrderedDistinctedMessageService extends ValidatedMessageService implements MessageService {
    private final MessageDecorator decorator;
    private final MessagePrinter printer;

    /**
     * @param decorator {@link MessageDecorator} specific addition to decorate process
     * @param printer   {@link MessagePrinter} variation of output process
     */
    public OrderedDistinctedMessageService(MessageDecorator decorator, MessagePrinter printer) {
        this.decorator = Objects.requireNonNull(decorator, "Service decorator must be not NULL");
        this.printer = Objects.requireNonNull(printer, "Service printer must be not NULL");
    }

    public void process(Message message, Message... messages) {
        if (!isArgsValid(message, messages)) {
            return;
        }
        proceedToPrint(concatMessageToArray(message, messages));
    }

    public void process(Order order, Message message, Message... messages) {
        if (!isArgsValid(message, messages)) {
            return;
        }
        messages = concatMessageToArray(message, messages);
        proceedToPrint(processReverse(order, messages));
    }

    public void process(Doubling doubling, Message message, Message... messages) {
        if (!isArgsValid(message, messages)) {
            return;
        }
        messages = concatMessageToArray(message, messages);
        proceedToPrint(processUnique(doubling, messages));
    }

    public void process(Order order, Doubling doubling, Message message, Message... messages) {
        if (!isArgsValid(message, messages)) {
            return;
        }
        messages = processReverse(order, concatMessageToArray(message, messages));
        proceedToPrint(processUnique(doubling, messages));
    }


    /**
     * Adds a <code>Message</> to an array of <code>Message</>s
     *
     * @param message  <code>Message</>s to be put in array
     * @param messages array of <code>Message</>s
     */
    private Message[] concatMessageToArray(Message message, Message... messages) {
        Message[] messagesList = new Message[messages.length + 1];
        messagesList[0] = message;
        System.arraycopy(messages, 0, messagesList, 1, messages.length);
        return messagesList;
    }

    /**
     * Outputs an array of <code>Message</>s in the passed order.
     *
     * @param messages array of <code>Message</>s to filter
     * @param order    the order of messages in the transmitted array
     * @return filtered array of <code>Message</>s
     */
    private Message[] processReverse(Order order, Message[] messages) {
        if (order == Order.DESC) {
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
     * Returns array of <code>Message</>s with or without duplicated messages depending on {@link Doubling} passed.
     *
     * @param messages array of <code>Message</>s to filter
     * @param doubles  {@link Doubling} filter type
     * @return filtered array of <code>Message</>s
     */
    private Message[] processUnique(Doubling doubles, Message[] messages) {
        if (doubles == Doubling.DISTINCT) {
            Message[] tempList = new Message[messages.length];
            Message[] uniqueList = new Message[messages.length];
            int lastIndex = messages.length - 1;
            for (int i = 0; i <= lastIndex; i++) {
                boolean flag = true;
                for (int k = 0; k <= lastIndex; k++) {
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

    private void proceedToPrint(Message... messages) {
        for (Message message : messages) {
            if (!isMessageValid(message)) {
                continue;
            }
            message = new SeverityMessageDecorator().decorate(message);
            message = decorator.decorate(message);
            message = new TypographicMessageDecorator().decorate(message);
            printer.print(message);
        }
    }
}


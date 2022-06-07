package com.tcs.edu.service;

import com.tcs.edu.decorator.MessageDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.domain.Doubling;
import com.tcs.edu.domain.MessageOrder;
import com.tcs.edu.domain.Severity;
import com.tcs.edu.exception.LogException;
import com.tcs.edu.printer.Printer;

public class OrderedDistinctedMessageService extends ValidatedService implements MessageService {

    Printer printer;
    MessageDecorator messageDecorator;

    public OrderedDistinctedMessageService(Printer printer, MessageDecorator messageDecorator) {
        this.printer = printer;
        this.messageDecorator = messageDecorator;
    }

    public void print(Severity severity, String ...messages) {
        for (String message : messages) {
            if (message != null) {
                printer.print(messageDecorator.decorate(severity, message));
            }
        }
    }
    public void print(Severity severity, MessageOrder messageOrder, String ...messages) {
        if (MessageOrder.ASC.equals(messageOrder)) {
            for (int i = 0; i < messages.length; i++) {
                if (messages[i] != null) {
                    printer.print(messageDecorator.decorate(severity, messages[i]));
                }
            }
        } else {
            for (int i = messages.length - 1; i >= 0; i--) {
                if (messages[i] != null) {
                    printer.print(messageDecorator.decorate(severity, messages[i]));
                }
            }
        }

    }

    public void print(Severity severity, MessageOrder messageOrder, Doubling doubling, String ...messages) {
        if (Doubling.DOUBLES.equals(doubling)) {
            if (MessageOrder.ASC.equals(messageOrder)) {
                for (int i = 0; i < messages.length; i++) {
                    if (messages[i] != null) {
                        printer.print(messageDecorator.decorate(severity, messages[i]));
                    }
                }
            } else {
                for (int i = messages.length - 1; i >= 0; i--) {
                    if (messages[i] != null) {
                        printer.print(messageDecorator.decorate(severity, messages[i]));
                    }
                }
            }
        } else {
            if (MessageOrder.ASC.equals(messageOrder)) {
                if (messages[0] != null) {
                    printer.print(messageDecorator.decorate(severity, messages[0]));
                }
                for (int i = 1; i < messages.length; i++) {
                    if (messages[i] != null) {
                        for (int j = 0; j < i; j++) {
                            if (messages[i].equals(messages[j])) {
                                break;
                            }
                            if (j == i - 1) {
                                printer.print(messageDecorator.decorate(severity, messages[i]));
                            }
                        }
                    }
                }
            } else {
                if (messages[messages.length - 1] != null) {
                    printer.print(messageDecorator.decorate(severity, messages[messages.length - 1]));
                }
                for (int i = messages.length - 2; i >= 0; i--) {
                    if (messages[i] != null) {
                        for (int j = messages.length - 1; j > i; j--) {
                            if (messages[i].equals(messages[j])) {
                                break;
                            }
                            if (j - 1 == i) {
                                printer.print(messageDecorator.decorate(severity, messages[i]));
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void log(MessageOrder messageOrder, Doubling doubling, Message ...messages) {
        try {
            isArgsValid(messages);
        } catch (IllegalArgumentException e) {
            throw new LogException("Messages to print are invalid", e);
        }
        if (Doubling.DOUBLES.equals(doubling)) {
            if (MessageOrder.ASC.equals(messageOrder)) {
                for (int i = 0; i < messages.length; i++) {
                    if (messages[i] != null) {
                        printer.print(messageDecorator.decorate(messages[i].getSeverity(), messages[i].getBody()));
                    }
                }
            } else {
                for (int i = messages.length - 1; i >= 0; i--) {
                    if (messages[i] != null) {
                        printer.print(messageDecorator.decorate(messages[i].getSeverity(), messages[i].getBody()));
                    }
                }
            }
        } else {
            if (MessageOrder.ASC.equals(messageOrder)) {
                if (messages[0] != null) {
                    printer.print(messageDecorator.decorate(messages[0].getSeverity(), messages[0].getBody()));
                }
                for (int i = 1; i < messages.length; i++) {
                    if (messages[i] != null) {
                        for (int j = 0; j < i; j++) {
                            if (messages[j] != null && messages[i].getBody().equals(messages[j].getBody()) && messages[i].getSeverity().equals(messages[j].getSeverity())) {
                                break;
                            }
                            if (j == i - 1) {
                                printer.print(messageDecorator.decorate(messages[i].getSeverity(), messages[i].getBody()));
                            }
                        }
                    }
                }
            } else {
                if (messages[messages.length - 1] != null) {
                    printer.print(messageDecorator.decorate(messages[messages.length - 1].getSeverity(), messages[messages.length - 1].getBody()));
                }
                for (int i = messages.length - 2; i >= 0; i--) {
                    if (messages[i] != null) {
                        for (int j = messages.length - 1; j > i; j--) {
                            if (messages[i].equals(messages[j])) {
                                break;
                            }
                            if (j - 1 == i) {
                                printer.print(messageDecorator.decorate(messages[i].getSeverity(), messages[i].getBody()));
                            }
                        }
                    }
                }
            }
        }
    }

}

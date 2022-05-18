package com.tcs.edu.printer;

import com.tcs.edu.domain.Message;

/**
 * The {@code ConsolePrinter} print the message body to the console and adds a newline.
 *
 * @author Zakhar Starokozhev
 */
public class ConsolePrinter implements MessagePrinter {
    public void print(Message message) {
        System.out.println(message);
    }
}

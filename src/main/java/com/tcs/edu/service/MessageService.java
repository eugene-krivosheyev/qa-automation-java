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
        process(severity, message);
        for (String currentMessage : messages) {
            process(severity, currentMessage);
        }
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
        messageCount++;
        currentMessage = TimestampMessageDecorator.decorate(currentMessage);
        currentMessage = SeverityMessageDecorator.decorate(severity, currentMessage);
        if (messageCount % PAGE_SIZE == 0) {
            currentMessage = PaginationDecorator.decorate(currentMessage);
        }
        ConsolePrinter.print(messageCount + " " + currentMessage);
    }
}

package com.tcs.edu.service;

import com.tcs.edu.decorator.PaginationDecorator;
import com.tcs.edu.decorator.Severity;
import com.tcs.edu.decorator.SeverityMessageDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;

import static com.tcs.edu.printer.ConsolePrinter.print;

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
     * Side effect on global {@link #messageCount} - increment.
     * Glues a decorated string with an ordinal number.
     * Includes pagination. The page size is determined by {@link #PAGE_SIZE}.
     * Prints out the result.
     *
     * @param severity A parameter to denote the implication and the impact of the defect on the functionality
     * @param messages <code>Strings</code> to be proceeded to print
     */
    public static void process(Severity severity, String... messages) {
        for (String message : messages) {
            messageCount++;
            message = TimestampMessageDecorator.decorate(message);
            message = SeverityMessageDecorator.decorate(severity, message);
            if (messageCount % PAGE_SIZE == 0) {
                message = PaginationDecorator.decorate(message);
            }
            print(messageCount + " " + message);
        }
    }
}

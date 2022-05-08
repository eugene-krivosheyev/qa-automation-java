package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;

/**
 * The {@code TypographicMessageDecorator}
 * is used to add current line number to the <code>Message</code> body
 * and page break to to the last one on the page.
 *
 * @author Zakhar Starokozhev
 */
public class TypographicMessageDecorator implements MessageDecorator {
    /**
     * <code>messageCount</code> stores the proceeded line number
     */
    private static int messageCount;
    /**
     * <code>PAGE_SIZE</code> is a fixed message count per page before delimiter appends.
     */
    private static final int PAGE_SIZE = 2;
    /**
     * <code>PAGE_DELIMITER</code> appends to the last line of the page.
     */
    public static final String PAGE_DELIMITER = "\n---";

    /**
     * Side effect on global {@link #messageCount} - increment for each message passed in.
     * Includes pagination. The page size is determined by {@link #PAGE_SIZE}.
     * Decorate message with an ordinal number i.e. line number
     * and decorates the last one by {@link TypographicMessageDecorator#PAGE_DELIMITER}
     */
    public Message decorate(Message message) {
        messageCount++;
        String body = String.format("%d %s", messageCount, message.getBody());
        if (messageCount % PAGE_SIZE == 0) {
            body = String.format("%s %s", body, PAGE_DELIMITER);
        }
        return new Message(message.getSeverity(), body);
    }
}

package com.tcs.edu.decorator;

import static java.time.Instant.now;

/**
 * The {@code TimestampMessageDecorator} is used to add a system UTC timestamp to the <code>String</code>.
 *
 * @author Zakhar Starokozhev
 */
public class TimestampMessageDecorator {

    /**
     * <code>PAGE_SIZE</code> is a fixed message count per page.
     */
    public final static int PAGE_SIZE = 2;
    /**
     * <code>PAGE_DELIMITER</code> appends to the last string of the page.
     */
    public final static String PAGE_DELIMITER = "\n---";
    /**
     * <code>messageCount</code> stores the number of {@link #decorate(String)} calls.
     */
    private static int messageCount;

    /**
     * Adds a space-delimited timestamp to the beginning of the passed string using concatenation.
     * Includes pagination. The page size is determined by {@link #PAGE_SIZE}.
     * Side effect on global {@link #messageCount} - increment.
     *
     * @param message The <code>String</code> to be decorated
     * @return The <code>String</code> decorated with a timestamp
     */
    public static String decorate(String message) {
        if (++messageCount % PAGE_SIZE == 0) {
            message += PAGE_DELIMITER;
        }
        return String.format("%d %s %s", messageCount, now(), message);
    }
}
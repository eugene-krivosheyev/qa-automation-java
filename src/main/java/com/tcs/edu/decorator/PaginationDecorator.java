package com.tcs.edu.decorator;

/**
 * The {@code PaginationDecorator} is used to adda a page break to the <code>String</code>.
 * Relevant to apply to the last line of the page.
 *
 * @author Zakhar Starokozhev
 */
public class PaginationDecorator {
    /**
     * <code>PAGE_DELIMITER</code> appends to the last string of the page.
     */
    public static final String PAGE_DELIMITER = "\n---";

    /**
     * Adds a text line separator (i.e. page break) to the the string passed.
     *
     * @param message The <code>String</code> to be decorated
     * @return The <code>String</code> decorated with a text line separator
     */
    public static String decorate(String message) {
        return String.format("%s %s", message, PAGE_DELIMITER);
    }
}

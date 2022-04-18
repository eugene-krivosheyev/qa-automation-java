package com.tcs.edu.decorator;

/**
 * The {@code SeverityMessageDecorator} is used to add severity label to the <code>String</code>.
 *
 * @author Zakhar Starokozhev
 */
public class SeverityMessageDecorator {
    /**
     * Adds a space-delimited hard coded severity label to the the string passed.
     *
     * @param message The <code>String</code> to be decorated
     * @return The <code>String</code> decorated with severity label
     */
    public static String decorate(Severity severity, String message) {
        switch (severity) {
            case MINOR: {
                message += " ()";
                break;
            }
            case REGULAR: {
                message += " (!)";
                break;
            }
            case MAJOR: {
                message += " (!!!)";
                break;
            }
        }
        return message;
    }
}


package com.tcs.edu.decorator;

public class SeverityDecorator {

    /**
     *
     * @param severity severity level (MINOR, REGULAR, MAJOR)
     * @param prefixDecoratedMessage any message
     * @return decorated message with added severity symbols
     */

    public static String mapToString(Severity severity, String prefixDecoratedMessage) {
        String severityString = null;
        switch (severity) {
            case MINOR: severityString = "( )"; break;
            case REGULAR: severityString = "(!)"; break;
            case MAJOR: severityString = "(!!!)"; break;
        }

        return prefixDecoratedMessage + " " + severityString;
    }
}

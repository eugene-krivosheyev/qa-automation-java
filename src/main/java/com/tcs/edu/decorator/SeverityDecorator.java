package com.tcs.edu.decorator;

/**
 * Decorator to add a severity
 *
 * @author k.s.savelev
 */
public class SeverityDecorator {

    /**
     * map string severity level: MINOR -> (), REGULAR -> (!), MAJOR -> (!!!)
     *
     * @param severity enum
     * @return String
     */
    public static String mapSeverity(Severity severity) {
        String severityString = null;
        switch (severity) {
            case MINOR:
                severityString = "()";
                break;
            case REGULAR:
                severityString = "(!)";
                break;
            case MAJOR:
                severityString = "(!!!)";
                break;
        }
        return severityString;
    }
}

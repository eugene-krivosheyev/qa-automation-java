package com.tcs.edu.decorator;

/**
 * {@code Severity} types that can be used:
 * {@link #MINOR},
 * {@link #REGULAR},
 * {@link #MAJOR}
 *
 * @author Zakhar Starokozhev
 */
public enum Severity {
    /**
     * Minor severity, appears in string as "()"
     */
    MINOR,
    /**
     * Regular severity, appears in string as "(!)"
     */
    REGULAR,
    /**
     * Major severity, appears in string as "(!!!)"
     */
    MAJOR
}

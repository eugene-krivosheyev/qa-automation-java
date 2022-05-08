package com.tcs.edu.printer;

import com.tcs.edu.domain.Message;

/**
 * Prints the <code>Message</code> passed to the output interface.
 *
 * @author Zakhar Starokozhev
 */
public interface Printer {
    /**
     * @param message The <code>Message</code> to be printed
     */
    void print(Message message);
}

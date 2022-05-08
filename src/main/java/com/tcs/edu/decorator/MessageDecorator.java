package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;

/**
 * Transforms the <code>Message</code> body by adding content
 *
 * @author Zakhar Starokozhev
 */
public interface MessageDecorator {
    /**
     * @param message The <code>Message</code> to be decorated
     * @return The <code>Message</code> with body decorated by severity label
     */
    Message decorate(Message message);
}

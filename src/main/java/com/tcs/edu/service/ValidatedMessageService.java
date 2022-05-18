package com.tcs.edu.service;

import com.tcs.edu.domain.Message;

/**
 * Checks the messaging service to process valid values
 *
 * @author Zakhar Starokozhev
 */
public abstract class ValidatedMessageService {
    /**
     * @param messages Array of <code>Messages</code> to be validated.
     */
    public final void isArgsValid(Message... messages) {
        if (messages != null) {
            for (Message message : messages) {
                isArgValid(message);
            }
            return;
        }
        throw new IllegalArgumentException("Null passed instead of Messages...");
    }

    /**
     * @param message Specific <code>Message</code> to be validated.
     */
    public final void isArgValid(Message message) {
        if (message == null || message.getBody() == null || message.getSeverity() == null) {
            throw new IllegalArgumentException("Current Message value contains null");
        }
    }

}

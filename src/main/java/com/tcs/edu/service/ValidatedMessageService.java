package com.tcs.edu.service;

import com.tcs.edu.domain.Message;

public abstract class ValidatedMessageService {
    public final boolean isArgsValid(Message message, Message... messages) {
        if (messages != null && isMessageValid(message)) {
            for (Message current : messages) {
                if (!isMessageValid(current)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final boolean isMessageValid(Message message) {
        return (message != null && message.getBody() != null && message.getSeverity() != null);
    }

}

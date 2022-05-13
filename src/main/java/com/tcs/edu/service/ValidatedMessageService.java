package com.tcs.edu.service;

import com.tcs.edu.domain.Message;

public abstract class ValidatedMessageService {
    public final boolean isArgsValid(Message message, Message... messages) {
        return (messages != null && isMessageValid(message));
    }

    public final boolean isMessageValid(Message message) {
        return (message != null && message.getBody() != null && message.getSeverity() != null);
    }

}

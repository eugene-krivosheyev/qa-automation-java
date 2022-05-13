package com.tcs.edu.service;

import com.tcs.edu.domain.Message;

public abstract class ValidatedMessageService {
    public boolean isArgsValid(Message message, Message... messages) {
        if (messages != null && message != null) {
            for (Message current : messages) {
                if (current == null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}

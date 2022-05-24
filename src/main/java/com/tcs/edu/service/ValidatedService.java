package com.tcs.edu.service;

import com.tcs.edu.domain.Message;

public abstract class ValidatedService {
    public void isArgsValid(Message ...messages) {
        if (messages == null || messages.length == 0) {
            throw new IllegalArgumentException("Messages cannot be null");
        }
    }

    public void isArgValid(Message message) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
    }
}

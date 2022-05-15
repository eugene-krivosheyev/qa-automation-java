package com.tcs.edu.service;

import com.tcs.edu.domain.Message;

public abstract class ValidatedService {
    public boolean isArgsValid(Message...messages) {
        return messages != null && messages.length != 0;
    }
}

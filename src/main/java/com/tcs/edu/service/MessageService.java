package com.tcs.edu.service;

import com.tcs.edu.domain.Message;
import com.tcs.edu.domain.Doubling;
import com.tcs.edu.domain.MessageOrder;

public interface MessageService {

    void print(MessageOrder messageOrder, Doubling doubling, Message... messages);
}

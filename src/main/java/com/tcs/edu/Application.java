package com.tcs.edu;

import com.tcs.edu.domain.Doubling;
import com.tcs.edu.domain.Message;
import com.tcs.edu.domain.MessageOrder;
import com.tcs.edu.domain.Severity;
import com.tcs.edu.service.HashMapMessageRepository;
import com.tcs.edu.service.MessageService;
import com.tcs.edu.service.RepositoryMessageService;

class Application {
    public static void main(String[] args) {
        HashMapMessageRepository messageRepository = new HashMapMessageRepository();
        MessageService messageService = new RepositoryMessageService(messageRepository);
        messageService.log(MessageOrder.ASC,
                Doubling.DISTINCT,
                new Message("Hello world! 0", Severity.MINOR),
                new Message("Hello world! 0", Severity.MINOR),
                new Message("Hello world! 1", Severity.MINOR),
                new Message("Hello world! 2", Severity.MINOR),
                new Message("Hello world! 3", Severity.MINOR),
                new Message("Hello world!", Severity.REGULAR),
                new Message("Hello world!", Severity.MAJOR));
    }
}
package com.tcs.edu.service;

import com.tcs.edu.decorator.MessageDecorator;
import com.tcs.edu.domain.Doubling;
import com.tcs.edu.domain.Message;
import com.tcs.edu.domain.MessageOrder;
import com.tcs.edu.domain.Severity;
import com.tcs.edu.exception.LogException;

import java.util.Collection;
import java.util.UUID;

public class RepositoryMessageService extends ValidatedService implements MessageService {

    private MessageRepository messageRepository;

    public RepositoryMessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void log(MessageOrder messageOrder, Doubling doubling, Message ...messages) {
        try {
            isArgsValid(messages);
        } catch (IllegalArgumentException e) {
            throw new LogException("Messages to print are invalid", e);
        }
        for (Message message : messages) {
            isArgValid(message);
            messageRepository.create(message);
        }
    }

    public Message findByPrimaryKey(UUID key) {
        return messageRepository.findByPrimaryKey(key);
    }

    public Collection<Message> findAll() {
        return messageRepository.findAll();
    }

    public Collection<Message> findBySeverity(Severity by) {
        return messageRepository.findBySeverity(by);
    }
}

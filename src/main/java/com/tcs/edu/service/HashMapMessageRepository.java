package com.tcs.edu.service;

import com.tcs.edu.domain.Message;
import com.tcs.edu.domain.Severity;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;
import java.util.stream.Collectors;

public class HashMapMessageRepository implements MessageRepository {
    HashMap<UUID, Message> messages;

    public HashMapMessageRepository() {
        messages = new HashMap<>();
    }

    @Override
    public UUID create(Message message) {
        UUID id = UUID.randomUUID();
        message.setId(id);
        messages.put(id, message);
        return id;
    }

    @Override
    public Message findByPrimaryKey(UUID key) {
        return messages.get(key);
    }

    @Override
    public Collection<Message> findAll() {
        return messages.values();
    }

    @Override
    public Collection<Message> findBySeverity(Severity by) {
        return messages.values().stream()
                .filter(message -> by.equals(message.getSeverity()))
                .collect(Collectors.toList());
    }
}

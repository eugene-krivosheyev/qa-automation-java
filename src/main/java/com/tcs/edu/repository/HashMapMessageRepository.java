package com.tcs.edu.repository;

import com.tcs.edu.domain.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HashMapMessageRepository implements MessageRepository {
    private final Map<UUID, Message> messages = new HashMap<>();

    @Override
    public UUID create(Message message) {
        message.setId(UUID.randomUUID());
        messages.put(message.getId(), message);
        return message.getId();
    }

    @Override
    public Message findByPrimaryKey(UUID key) {
        return messages.get(key);
    }
}

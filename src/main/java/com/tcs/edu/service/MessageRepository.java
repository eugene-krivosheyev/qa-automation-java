package com.tcs.edu.service;

import com.tcs.edu.domain.Message;

import java.util.Collection;
import java.util.UUID;

public interface MessageRepository {

    UUID create(Message message);

    Message findByPrimaryKey(UUID key);

    Collection<Message> findAll();
}

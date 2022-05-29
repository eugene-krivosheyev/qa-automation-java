package com.tcs.edu.repository;

import com.tcs.edu.domain.Message;

import java.util.UUID;

public interface MessageRepository {
    UUID create(Message message);

    Message findByPrimaryKey(UUID key);
}

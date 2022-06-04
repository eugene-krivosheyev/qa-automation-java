package com.tcs.edu.repository;

import com.tcs.edu.decorator.Severity;
import com.tcs.edu.domain.Message;

import java.util.Collection;
import java.util.UUID;

public interface MessageRepository {
    /**
     *
     * @param message to put in storage
     * @return unique id of message stored
     */
    UUID create(Message message);

    /**
     * Look for the stored message matching specific id
     * @param key unique id of the message
     * @return message with id matching the key
     */
    Message findByPrimaryKey(UUID key);

    /**
     *
     * @return all stored messages at once
     */
    Collection<Message> findAll();

    /**
     * @param by - specific message {@link Severity} to search by
     * @return stored messages filtered by {@link Severity} passed
     */
    Collection<Message> findAllBySeverity(Severity by);
}

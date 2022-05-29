package com.tcs.edu.service;

import com.tcs.edu.decorator.Severity;
import com.tcs.edu.domain.Message;

import java.util.Collection;
import java.util.UUID;

/**
 * Processes message or messages according to the given parameters, including sorting and message order.
 *
 * @author Zakhar Starokozhev
 */
public interface MessageService {
    /**
     * @param messages <code>Messages</code> to be proceeded.
     */
    void process(Message... messages) throws LogException;

    /**
     * @param order Defines the order in which messages are proceeded.
     */
    void process(Order order, Message... messages) throws LogException;

    /**
     * @param doubling Presence of repeated messages.
     */
    void process(Doubling doubling, Message... messages) throws LogException;

    /**
     * @param doubling Presence of repeated messages.
     * @param order    Defines the order in which messages are proceeded.
     */
    void process(Order order, Doubling doubling, Message... messages) throws LogException;

    /**
     * @return all logged messages
     */
    Collection<Message> findAll();

    /**
     * @param by - specific message {@link Severity} to search by
     * @return logged messages filtered by {@link Severity} passed
     */
    Collection<Message> findAllBySeverity(Severity by);

    /**
     * @param id - unique id of message logged by service
     * @return - specific message matching id passed
     */
    Message findByPrimaryKey(UUID id);
}

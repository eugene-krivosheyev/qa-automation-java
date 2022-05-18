package com.tcs.edu.service;

import com.tcs.edu.domain.Message;

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
     * @param order Defines the order in which messages are printed.
     */
    void process(Order order, Message... messages) throws LogException;

    /**
     * @param doubling Presence of repeated messages.
     */
    void process(Doubling doubling, Message... messages) throws LogException;

    /**
     * @param doubling Presence of repeated messages.
     * @param order    Defines the order in which messages are printed.
     */
    void process(Order order, Doubling doubling, Message... messages) throws LogException;
}

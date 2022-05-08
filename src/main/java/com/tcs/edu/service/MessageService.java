package com.tcs.edu.service;

import com.tcs.edu.domain.Message;

/**
 * Processes message or messages according to the given parameters, including sorting and message order.
 *
 * @author Zakhar Starokozhev
 */
public interface MessageService {
    /**
     * @param message  <code>Message</code> to be proceeded. Disables calling without messages.
     * @param messages <code>Messages</code> to be proceeded.
     */
    void process(Message message, Message... messages);

    /**
     * @param order Defines the order in which messages are printed.
     * @see #process(Message, Message...)
     */
    void process(MessageOrder order, Message message, Message... messages);

    /**
     * @param doubling Presence of repeated messages.
     * @see #process(Message, Message...)
     */
    void process(Doubling doubling, Message message, Message... messages);


    /**
     * @param doubling Presence of repeated messages.
     * @param order    Defines the order in which messages are printed.
     * @see #process(Message, Message...)
     */
    void process(MessageOrder order, Doubling doubling, Message message, Message... messages);
}

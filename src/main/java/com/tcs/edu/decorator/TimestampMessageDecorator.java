package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;

import static java.time.Instant.now;

/**
 * The {@code TimestampMessageDecorator} is used to add a system UTC timestamp to the <code>Message</code> body.
 *
 * @author Zakhar Starokozhev
 */
public class TimestampMessageDecorator implements MessageDecorator {
    /**
     * Adds a space-delimited timestamp to the beginning of the message body.
     */
    public Message decorate(Message message) {
        String body = String.format("%s %s", now(), message.getBody());
        return new Message(message.getSeverity(), body);
    }
}
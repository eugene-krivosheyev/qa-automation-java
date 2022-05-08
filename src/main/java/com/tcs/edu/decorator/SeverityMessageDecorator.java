package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;

/**
 * The {@code SeverityMessageDecorator} is used to add severity label to the <code>Message</code> body.
 *
 * @author Zakhar Starokozhev
 */
public class SeverityMessageDecorator implements MessageDecorator {
    /**
     * Adds a space-delimited hard coded severity label to the the message body.
     */
    public Message decorate(Message message) {
        String body = message.getBody();
        switch (message.getSeverity()) {
            case MINOR: {
                body += " ()";
                break;
            }
            case REGULAR: {
                body += " (!)";
                break;
            }
            case MAJOR: {
                body += " (!!!)";
                break;
            }
        }
        return new Message(message.getSeverity(), body);
    }
}


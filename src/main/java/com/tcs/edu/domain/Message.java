package com.tcs.edu.domain;

import com.tcs.edu.decorator.Severity;

import java.util.Objects;

/**
 * The {@code Message} corries a message line with a specific severity level.
 *
 * @author Zakhar Starokozhev
 */
public class Message {
    private final String body;
    private final Severity severityLevel;

    /**
     * @param level {@link Severity} - impact of the message content to the system
     * @param body  {@link String} - content itself
     */
    public Message(Severity level, String body) {
        this.severityLevel = Objects.requireNonNull(level, "Message severity must be not NULL");
        this.body = Objects.requireNonNull(body, "Message body must be not NULL");
    }

    public Message(String body) {
        this(Severity.MINOR, body);
    }

    public Message(Severity level) {
        this(level, "Default message");
    }

    public Message() {
        this(Severity.MINOR, "Default message");
    }

    public String getBody() {
        return body;
    }

    public Severity getSeverity() {
        return severityLevel;
    }

    @Override
    public String toString() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return body.equals(message.body) && severityLevel == message.severityLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, severityLevel);
    }
}

package com.tcs.edu.domain;

import com.tcs.edu.decorator.Severity;

import java.util.Objects;
import java.util.UUID;

/**
 * The {@code Message} corries a message line with a specific severity level.
 *
 * @author Zakhar Starokozhev
 */
public class Message {
    private final String body;
    private final Severity severityLevel;
    /**
     * mutable {@code UUID} for specific message
     */
    private UUID id;

    /**
     * @param level {@link Severity} - impact of the message content to the system
     * @param body  {@link String} - content itself
     */
    public Message(Severity level, String body) {
        this.severityLevel = level;
        this.body = body;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID newId) {
        id = newId;
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
        return Objects.equals(body, message.body)
                && severityLevel == message.severityLevel
                && Objects.equals(id, message.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, severityLevel, id);
    }
}

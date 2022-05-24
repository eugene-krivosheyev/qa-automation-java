package com.tcs.edu.domain;

import java.util.Objects;
import java.util.UUID;

public class Message {
    UUID id;
    String body;
    Severity severity;

    public Message(String body, Severity severity) {
        this.body = body;
        this.severity = severity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) && Objects.equals(body, message.body) && severity == message.severity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, body, severity);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", severity=" + severity +
                '}';
    }
}

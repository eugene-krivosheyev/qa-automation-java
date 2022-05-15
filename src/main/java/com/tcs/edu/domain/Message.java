package com.tcs.edu.domain;

import java.util.Objects;

public class Message {
    String body;
    Severity severity;

    public Message(String body, Severity severity) {
        this.body = body;
        this.severity = severity;
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
        return Objects.equals(body, message.body) && severity == message.severity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, severity);
    }

    @Override
    public String toString() {
        return "Message{" +
                "body='" + body + '\'' +
                ", severity=" + severity +
                '}';
    }
}

package com.tcs.edu.domain;

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
}

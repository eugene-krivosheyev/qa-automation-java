package com.tcs.edu.domain;

import com.tcs.edu.decorator.Severity;

public class Message {
    private final String body;
    private final Severity severityLevel;

    public Message(Severity level, String body) {
        this.severityLevel = level;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public Severity getCurrentSeverity() {
        return severityLevel;
    }

}

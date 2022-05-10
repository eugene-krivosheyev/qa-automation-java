package domain;

import javax.print.attribute.standard.Severity;

public class Message {

    private String body;
    private Severity severity;

    public Message(String body, Severity severity) {
        this.body = body;
        this.severity = severity;
    }

    public String getBody() {
        return body;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }
}

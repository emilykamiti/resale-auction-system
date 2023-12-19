package com.resale.app.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Email {
    public String senderEmail;
    public String recipientEmail;
    public String subject;
    public String body;

    public Email() {
    }

    public Email(String senderEmail, String recipientEmail, String subject, String body) {
        this.senderEmail = senderEmail;
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.body = body;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}

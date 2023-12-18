package com.resale.app.bean;

import javax.mail.MessagingException;

import com.resale.app.model.entity.Email;

public interface EmailBeanI {
    void sendEmail(Email email) throws MessagingException;
}

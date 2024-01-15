package com.resale.app.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.resale.app.model.entity.Email;
import java.util.Properties;

@Stateless
@Remote
public class EmailBean {

    public void sendEmail(Email email, String emessage) throws MessagingException {
        System.out.println("sending email...");

        String to = email.getRecipientEmail();
        String from = email.getSenderEmail();

        String host = "sandbox.smtp.mailtrap.io";

        System.out.println("Sending email...");

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("cee092022a4cd2", "e6f79f0297523e");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(email.getSubject());
            message.setText(email.getBody());

            Transport.send(message);
            System.out.println("Sent message successfully...");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMail(Email email, String message) {
    }
}
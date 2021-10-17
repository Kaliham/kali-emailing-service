package me.yourfavoritesde.kaliemailingservice.service;

import me.yourfavoritesde.kaliemailingservice.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class MailingService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private ApplicationContext context;

    public void sendSimpleEmail(Email email){
        SimpleMailMessage message =(SimpleMailMessage) context.getBean("argsMailMessage",email);
        mailSender.send(message);
        System.out.println("Mail send...");
    }
    public void sendQuickEmail(Email email){
        SimpleMailMessage message =(SimpleMailMessage) context.getBean("argsMailMessage",email);
        mailSender.send(message);
        System.out.println("Mail send...");
    }
    public void sendHTMLEmail(Email email)throws IOException, MessagingException {

        MimeMessage message =(MimeMessage) context.getBean("htmlEmailMessage",email);
        mailSender.send(message);
        System.out.println("Mail send...");
    }
}

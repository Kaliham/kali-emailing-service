package me.yourfavoritesde.kaliemailingservice.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@Component
@Scope("prototype")
public class Email {

    @Value("${spring.mail.username}")
    @Setter(AccessLevel.NONE)
    private String fromEmail;
    @Value("${email.cc}")
    @Setter(AccessLevel.NONE)
    private String[] ccEmail;

    private String toEmail;
    private String body;
    private String subject;


    public Email(String toEmail, String body, String subject) {
        this.toEmail = toEmail;
        this.body = body;
        this.subject = subject;
    }
}

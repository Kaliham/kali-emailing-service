package me.yourfavoritesde.kaliemailingservice.service;

import me.yourfavoritesde.kaliemailingservice.model.Email;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailingServiceTest {
    @Autowired
    MailingService mailingService;

//    @Test
//    void sendEmail() {
//        Email email = Email.builder()
//                .toEmail("jotaroham@gmail.com")
//                .body("Hi,\n this is a test\nsincerely\npog champ")
//                .subject("Test PogChamp").build();
//        mailingService.sendSimpleEmail(email);
//    }
}
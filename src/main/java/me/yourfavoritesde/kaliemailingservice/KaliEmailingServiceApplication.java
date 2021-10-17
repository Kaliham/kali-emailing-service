package me.yourfavoritesde.kaliemailingservice;

import me.yourfavoritesde.kaliemailingservice.model.Email;
import me.yourfavoritesde.kaliemailingservice.service.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.MimeMessage;

@SpringBootApplication
public class KaliEmailingServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(KaliEmailingServiceApplication.class, args);
	}
}

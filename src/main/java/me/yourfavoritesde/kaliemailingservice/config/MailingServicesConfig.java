package me.yourfavoritesde.kaliemailingservice.config;

import me.yourfavoritesde.kaliemailingservice.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.stream.Collectors;

@Configuration
public class MailingServicesConfig {

    @Value("${email.file}")
    private String MAIL_FILE;
    @Value("${quick.subject}")
    private String quickSubject;
    @Value("${quick.body}")
    private String quickBody;

    @Autowired
    ApplicationContext applicationContext;


    @Bean
    @Scope("prototype")
    public SimpleMailMessage simpleMailMessage(){
        return new SimpleMailMessage();
    }

    @Bean("argsMailMessage")
    @Scope("prototype")
    public SimpleMailMessage argsMailMessage(Email email){
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom(email.getFromEmail());
        message.setTo(email.getToEmail());
        message.setCc(email.getCcEmail());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());
        return message;
    }

    @Bean("quickMailMessage")
    @Scope("prototype")
    public SimpleMailMessage quickMailMessage(Email email){
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom(email.getFromEmail());
        message.setTo(email.getToEmail());
        message.setCc(email.getCcEmail());
        message.setSubject(quickSubject);
        message.setText(quickBody);
        return message;
    }

    @Bean("htmlEmailMessage")
    @Scope("prototype")
    public MimeMessage htmlEmailMessage(Email email) throws IOException, MessagingException {
        MimeMessage mimeMessage= applicationContext.getBean(JavaMailSender.class).createMimeMessage();
     final MimeMessageHelper message =
                new MimeMessageHelper(mimeMessage, true, "UTF-8");
        message.setFrom(email.getFromEmail());
        message.setTo(email.getToEmail());
        message.setCc(email.getCcEmail());
        message.setSubject(email.getSubject());
        final String htmlContent =  (new BufferedReader(new InputStreamReader(applicationContext.getResource(MAIL_FILE).getInputStream())))
                .lines()
                .map(text->{
                    if(text.contains("**Message**")){
                        text=text.replace("**Message**", email.getBody());
                    }
                    return text;
                })
                .collect(Collectors.joining());
        message.setText(htmlContent, true);

        return mimeMessage;
    }
}

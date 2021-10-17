package me.yourfavoritesde.kaliemailingservice.controllers;

import me.yourfavoritesde.kaliemailingservice.model.Email;
import me.yourfavoritesde.kaliemailingservice.model.StatusCode;
import me.yourfavoritesde.kaliemailingservice.model.StatusResponse;
import me.yourfavoritesde.kaliemailingservice.service.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://yourfavoritesde.com")
@RestController
public class EmailController {

    @Autowired
    MailingService mailingService;
    @Autowired
    ApplicationContext context;

    @PostMapping("/text-email")
    public StatusResponse textEmail(@RequestBody Email emailArg){
        try{
            final Email email = context.getBean(Email.class);
            email.setToEmail(emailArg.getToEmail());
            email.setSubject(emailArg.getSubject());
            email.setBody(emailArg.getBody());
            mailingService.sendSimpleEmail(email);
        }catch(Exception e){
            return StatusResponse .builder()
                    .status(StatusCode.InternalServerError)
                    .additionalMessage(e.getMessage())
                    .build();
        }
        return StatusResponse.builder()
                .status(StatusCode.OK)
                .additionalMessage("Successful!")
                .build();
    }

    @PostMapping("/quick-email")
    public StatusResponse quickEmail(@RequestBody Email emailArg){
        try{
            final Email email = context.getBean(Email.class);
            email.setToEmail(emailArg.getToEmail());
            mailingService.sendQuickEmail(email);
        }catch(Exception e){
            return StatusResponse .builder()
                    .status(StatusCode.InternalServerError)
                    .additionalMessage(e.getMessage())
                    .build();
        }
        return StatusResponse.builder()
                .status(StatusCode.OK)
                .additionalMessage("Successful!")
                .build();
    }
    @PostMapping("/html-email")
    public StatusResponse htmlEmail(@RequestBody Email emailArg){
        final Email email = context.getBean(Email.class);
        email.setToEmail(emailArg.getToEmail());
        try{
            mailingService.sendHTMLEmail(email);
        }catch(Exception e){
            return StatusResponse .builder()
                    .status(StatusCode.InternalServerError)
                    .additionalMessage(e.getMessage())
                    .build();
        }
        return StatusResponse.builder()
                .status(StatusCode.OK)
                .additionalMessage("Successful!")
                .build();
    }

}

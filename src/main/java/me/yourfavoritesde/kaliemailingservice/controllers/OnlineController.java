package me.yourfavoritesde.kaliemailingservice.controllers;

import me.yourfavoritesde.kaliemailingservice.model.Email;
import me.yourfavoritesde.kaliemailingservice.model.StatusResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnlineController {
    @GetMapping ("/")
    public String status() {
    return "ONLINE";
    }
}

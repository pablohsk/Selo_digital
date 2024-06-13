package com.tjsc.selodigital.controller;

import com.tjsc.selodigital.dto.UserCredentialsDTO;
import com.tjsc.selodigital.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody UserCredentialsDTO credentials) {
        return authService.login(credentials);
    }

    @PostMapping("/register")
    public String register(@RequestBody UserCredentialsDTO credentials) {
        return authService.register(credentials);
    }
}

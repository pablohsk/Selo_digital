package com.tjsc.selodigital.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody UserCredentials credentials) {
        // Lógica de autenticação
        return "Token de autenticação";
    }

    @PostMapping("/register")
    public String register(@RequestBody UserCredentials credentials) {
        // Lógica de registro
        return "Usuário registrado com sucesso";
    }
}

class UserCredentials {
    public String username;
    public String password;
}

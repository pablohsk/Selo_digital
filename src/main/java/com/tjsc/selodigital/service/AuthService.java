package com.tjsc.selodigital.service;

import com.tjsc.selodigital.dto.UserCredentialsDTO;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public String login(UserCredentialsDTO credentials) {
        // Lógica de autenticação
        return "Token de autenticação";
    }

    public String register(UserCredentialsDTO credentials) {
        // Lógica de registro
        return "Usuário registrado com sucesso";
    }
}

package com.tjsc.selodigital.service;

import com.tjsc.selodigital.dto.UserCredentialsDTO;
import com.tjsc.selodigital.model.User;
import com.tjsc.selodigital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.*;
import com.nimbusds.jwt.SignedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import java.util.Date;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final byte[] sharedSecret = "your_secret_key_your_secret_key".getBytes(); // Chave segura

    public String login(UserCredentialsDTO credentials) {
        User user = userRepository.findByUsername(credentials.getUsername());
        if (user != null && passwordEncoder.matches(credentials.getPassword(), user.getPassword())) {
            return generateToken(user.getUsername());
        }
        throw new RuntimeException("Invalid username or password");
    }

    public String register(UserCredentialsDTO credentials) {
        if (userRepository.findByUsername(credentials.getUsername()) != null) {
            throw new RuntimeException("Username already taken");
        }
        User user = new User();
        user.setUsername(credentials.getUsername());
        user.setPassword(passwordEncoder.encode(credentials.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }

    private String generateToken(String username) {
        try {
            JWSSigner signer = new MACSigner(sharedSecret);

            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .subject(username)
                    .issueTime(new Date())
                    .expirationTime(new Date(System.currentTimeMillis() + 86400000)) // 1 dia de expiração
                    .build();

            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJWT.sign(signer);

            return signedJWT.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException("Error generating token", e);
        }
    }
}

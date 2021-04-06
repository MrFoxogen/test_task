package com.example.test.controller;

import com.example.test.filter.GenerateToken;
import com.example.test.model.TokenPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/token")
public class GenerateTokenController {

    private final GenerateToken generateToken;

    @Autowired
    public GenerateTokenController(GenerateToken generateToken) {
        this.generateToken = generateToken;
    }

    @GetMapping
    public ResponseEntity<String> getToken(@RequestBody TokenPayload tokenPayload) {
        return ResponseEntity.ok(generateToken.generateToken(tokenPayload.getUserId()));
    }
}

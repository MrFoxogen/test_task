package com.example.test.filter;

import com.example.test.model.User;
import com.example.test.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.example.test.filter.JwtUtil.*;

@Component
public class GenerateToken {

    private final UserRepository userRepository;

    @Autowired
    public GenerateToken(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String generateToken(String userId) {
        Optional<User> byUsername = userRepository.findById(userId);
        if (!byUsername.isPresent()) {
            throw new EntityNotFoundException("User with name - " + userId + "doesn't found");
        }
        User user = byUsername.get();
        Map<String, Object> claims = new HashMap<>();
        claims.put(ROLE, user.getUserRole().getName());
        claims.put("Issue", "Issue");
        claims.put(USER_ID, user.getId());
        return generateToken(claims);
    }

    String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                   .setClaims(claims)
                   .setExpiration(generateExpirationDate())
                   .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                   .compact();
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + 604800 * 1000);
    }
}

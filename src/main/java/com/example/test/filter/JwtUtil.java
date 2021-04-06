package com.example.test.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public static final String ROLE = "Role";
    public static final String USER_ID = "UserId";
    public static final String SECRET_KEY = "Test";

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                         .setSigningKey(SECRET_KEY)
                         .parseClaimsJws(token)
                         .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public String getRoleFromToken(String token) {
        String authorities;
        try {
            final Claims claims = getClaimsFromToken(token);
            authorities = (String) claims.get(ROLE);
        } catch (Exception e) {
            authorities = null;
        }
        return authorities;
    }

    public String getUserId(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = (String) claims.get(USER_ID);
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
}

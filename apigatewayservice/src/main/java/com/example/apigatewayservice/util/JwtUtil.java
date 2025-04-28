package com.example.apigatewayservice.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final String SECRET = "Aryan#2004";

    public void validateToken(final String token) {
        Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace("Bearer ", ""));
    }

    public String extractRole(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();
        return claims.get("role", String.class);
    }
}

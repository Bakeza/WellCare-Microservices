package com.wellcare.API.Gateway;

import java.security.Key;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    public static final String SECRET = "======================WellCare=Spring===========================";

    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET));
    }


    public Long getUserIdFromJwtToken(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody();
        Object userIdObject = claims.get("userId");
        if (userIdObject != null) {
            return Long.parseLong(userIdObject.toString());
        } else {
            throw new IllegalArgumentException("User ID not found in JWT token");
        }
    }
}

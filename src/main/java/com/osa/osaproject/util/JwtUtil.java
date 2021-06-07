package com.osa.osaproject.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtil {

    @Value("SECRET")
    private String secret;

    @Value("900000")
    private Long expiration;

    public Claims getClaimsFromToken(String token) {
        Claims claims;

        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }
        catch (Exception ex) {
            claims = null;
        }

        return claims;
    }

    public String getUsernameFromToken(String token) {
        String username = null;

        Claims claims = getClaimsFromToken(token);
        username = claims.getSubject();

        return username;
    }

    public Date getExpirationDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        Date expirationDate = claims.getExpiration();

        return expirationDate;
    }

    public boolean isTokenExpired(String token) {
        Date expirationDate = getExpirationDateFromToken(token);

        return expirationDate.before(new Date(System.currentTimeMillis()));
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("sub", userDetails.getUsername());
        claims.put("role", userDetails.getAuthorities().toArray()[0]);
        claims.put("created", new Date(System.currentTimeMillis()));

        return Jwts.builder().setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        boolean isExpired = isTokenExpired(token);

        return !isExpired && username.equals(userDetails.getUsername());
    }

}

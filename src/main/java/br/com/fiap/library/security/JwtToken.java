package br.com.fiap.library.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtToken {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expire}")
    private int expire;

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        Date dataCriacao = Date.from(LocalDateTime.now().toInstant(OffsetDateTime.now().getOffset()));
        Date dataExpiracao = Date.from(LocalDateTime.now().plusMinutes(expire).toInstant(OffsetDateTime.now().getOffset()));
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(dataCriacao)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();
        return claims.getSubject();
    }

}
package com.martins.helina.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.martins.helina.config.SecretsManagerService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {
	
	private final Key key;
    private final Long expiration;

	public JWTUtil(SecretsManagerService secretsManagerService) {
        String secret = secretsManagerService.getSecretValue("JWT_SECRET");
		this.key = Keys.hmacShaKeyFor(secret.getBytes());
        String expirationStr = secretsManagerService.getSecretValue("JWT_EXPIRATION");
        this.expiration = Long.parseLong(expirationStr);
    }
	
	
	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(key, SignatureAlgorithm.HS512)
				.compact();
	}


	public boolean tokenValido(String token) {
		Claims claims = getClaims(token);
		if(claims != null) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			if(username != null && expirationDate != null && now.before(expirationDate)) {
				return true;
			}
		}
		return false;
	}


	private Claims getClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
    }


	public String getUsername(String token) {
		Claims claims = getClaims(token);
		if(claims != null) {
			return claims.getSubject();
		}
		return null;
	}
}

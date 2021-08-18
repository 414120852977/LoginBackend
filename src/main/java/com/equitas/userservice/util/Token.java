package com.equitas.userservice.util;

import java.util.Date;


import java.util.UUID;


import org.springframework.stereotype.Service;

import com.equitas.userservice.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class Token {
	
	SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	public final String TOKEN_SECRET = "sd5745FAHFW";
	
	public String generateVerificationtoken(User userdata) {	
		long currentTime = System.currentTimeMillis();
        return Jwts.builder()
                .setId(String.valueOf(userdata.getUserId()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(currentTime +100000000))
                .signWith(signatureAlgorithm, TOKEN_SECRET)
                .compact();
	}
	
	public UUID decodeJWT(String jwt) throws JwtException {
        try {
            Claims claims = Jwts.parser().setSigningKey("sd5745FAHFW")
            		                     .parseClaimsJws(jwt)
            		                     .getBody();
            return UUID.fromString(claims.getId());
        } catch (ExpiredJwtException e) {
            throw new JwtException("Session time out");
        }
    }
}

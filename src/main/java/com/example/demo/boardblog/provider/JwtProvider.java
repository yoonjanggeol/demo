package com.example.demo.boardblog.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {
    
    private String secretKey = "S3cr3tK3y";

    public String create(String email) {
        
        Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        // jwt 생성
        String jwt = Jwts.builder()
            .signWith(SignatureAlgorithm.ES256, secretKey) // 알고리즘 선택, 시크릿키
            .setSubject(email).setIssuedAt(new Date()).setExpiration(expiredDate) // 주체(이메일), 생성시간(현재시간), 만료시간(expiredDate)
            .compact(); // 압축

        return jwt;
    }

    public String validata(String jwt) {

        Claims claims = null; 

        try {
            claims = Jwts.parser().setSigningKey(secretKey) // sign키가 맞는지
                .parseClaimsJws(jwt).getBody(); // 토큰의 유효기간
        } catch (Exception e) {
                e.printStackTrace();
                return null;
        }

        return claims.getSubject();
    }
}


























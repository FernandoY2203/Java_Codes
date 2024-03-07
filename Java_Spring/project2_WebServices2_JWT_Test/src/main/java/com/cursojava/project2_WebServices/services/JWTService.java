package com.cursojava.project2_WebServices.services;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTService {

	@Value("${token.signing.key}")
	private String jwtSingInKey;

	private Claims extractAllClaims(String token) {
		return Jwts;
	}

	private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
		final Claims claims = extractAllClaims(token);
	}
}

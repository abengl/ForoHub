package com.alessandragodoy.forohub.config.security;

import com.alessandragodoy.forohub.model.UserForo;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Service for generating and verifying JWT tokens.
 */
@Service
public class TokenService {

	@Value("${api.security.secret}")
	private String apiSecret;

	/**
	 * Generates a JWT token for the given user.
	 *
	 * @param user the user for whom the token is generated
	 * @return the generated JWT token
	 */
	public String generateToken(UserForo user) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(apiSecret);
			return JWT.create()
					.withIssuer("ForoHub")
					.withSubject(user.getUsername())
					.withClaim("id", user.getId())
					.withExpiresAt(generateExpirationDate())
					.sign(algorithm);
		} catch (JWTCreationException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * Extracts the subject (username) from the given JWT token.
	 *
	 * @param token the JWT token
	 * @return the subject (username) extracted from the token
	 * @throws RuntimeException if the token is null or invalid
	 */
	public String getSubject(String token) {

		if (token == null) {
			throw new RuntimeException();
		}

		DecodedJWT verifier = null;

		try {
			Algorithm algorithm = Algorithm.HMAC256(apiSecret);
			verifier = JWT.require(algorithm)
					.withIssuer("ForoHub")
					.build()
					.verify(token);
			verifier.getSubject();
		} catch (JWTVerificationException e) {
			System.out.println(e.getMessage());
		}

		if (verifier.getSubject() == null) {
			throw new RuntimeException("Verifier invalido");
		}

		return verifier.getSubject();
	}

	/**
	 * Generates the expiration date for the JWT token.
	 *
	 * @return the expiration date as an Instant
	 */
	private Instant generateExpirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
	}
}
package com.alessandragodoy.forohub.controller;

import com.alessandragodoy.forohub.config.security.TokenService;
import com.alessandragodoy.forohub.dto.AuthenticateUser;
import com.alessandragodoy.forohub.dto.JWTTokenDTO;
import com.alessandragodoy.forohub.model.UserForo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling user authentication.
 */
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationManager authenticationManager;
	private final TokenService tokenService;

	/**
	 * Authenticates a user and generates a JWT token.
	 *
	 * @param request the authentication request containing the user's email and password
	 * @return a ResponseEntity containing the generated JWT token
	 */
	@PostMapping
	public ResponseEntity<JWTTokenDTO> autenticarUsuario(@RequestBody @Valid AuthenticateUser request) {

		Authentication authToken = new UsernamePasswordAuthenticationToken(request.email(),
				request.password());

		var user = authenticationManager.authenticate(authToken);

		var jwtToken = tokenService.generateToken((UserForo) user.getPrincipal());

		return ResponseEntity.ok(new JWTTokenDTO(jwtToken));
	}

}

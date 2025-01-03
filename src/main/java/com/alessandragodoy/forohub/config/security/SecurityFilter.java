package com.alessandragodoy.forohub.config.security;

import com.alessandragodoy.forohub.repository.UserForoRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Security filter that processes JWT tokens from the Authorization header.
 */
@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

	private final TokenService tokenService;
	private final UserForoRepository userForoRepository;

	/**
	 * Filters incoming requests and processes JWT tokens.
	 *
	 * @param request the HTTP request
	 * @param response the HTTP response
	 * @param filterChain the filter chain
	 * @throws ServletException if an error occurs during filtering
	 * @throws IOException if an I/O error occurs during filtering
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authHeader = request.getHeader("Authorization");

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			String token = authHeader.substring(7);

			try {
				String username = tokenService.getSubject(token);

				if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

					UserDetails user = userForoRepository.findByEmail(username);
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null,
							user.getAuthorities());
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			} catch (RuntimeException e) {
				System.out.println("Authentication failed: " + e.getMessage());
			}

		}
		filterChain.doFilter(request, response);
	}
}
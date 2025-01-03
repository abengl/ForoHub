package com.alessandragodoy.forohub.service;

import com.alessandragodoy.forohub.repository.UserForoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service class for handling authentication.
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

	private final UserForoRepository userForoRepository;

	/**
	 * Loads the user by username (email).
	 *
	 * @param username the email of the user
	 * @return UserDetails of the user
	 * @throws UsernameNotFoundException if the user is not found
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userForoRepository.findByEmail(username);
	}
}
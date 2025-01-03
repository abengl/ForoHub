package com.alessandragodoy.forohub.repository;

import com.alessandragodoy.forohub.model.UserForo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

/**
 * Repository interface for UserForo entities.
 */
public interface UserForoRepository extends JpaRepository<UserForo, Long> {

	/**
	 * Finds a UserForo entity by email, ignoring case.
	 *
	 * @param email the email to search for
	 * @return an Optional containing the found UserForo, or empty if not found.
	 */
	Optional<UserForo> findByEmailIgnoreCase(String email);

	/**
	 * Finds a UserDetails entity by email.
	 *
	 * @param email the email to search for
	 * @return the UserDetails associated with the given email
	 */
	UserDetails findByEmail(String email);
}
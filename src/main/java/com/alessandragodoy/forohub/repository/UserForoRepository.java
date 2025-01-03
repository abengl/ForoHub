package com.alessandragodoy.forohub.repository;

import com.alessandragodoy.forohub.model.UserForo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserForoRepository extends JpaRepository<UserForo, Long> {
	Optional<UserForo> findByEmailIgnoreCase(String email);

	UserDetails findByEmail(String email);
}

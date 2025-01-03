package com.alessandragodoy.forohub.repository;

import com.alessandragodoy.forohub.model.UserForo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserForoRepository extends JpaRepository<UserForo, Long> {
	Optional<UserForo> findByEmail(String email);
}

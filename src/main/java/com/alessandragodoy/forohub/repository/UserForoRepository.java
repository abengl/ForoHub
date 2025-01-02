package com.alessandragodoy.forohub.repository;

import com.alessandragodoy.forohub.model.UserForo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserForoRepository extends JpaRepository<UserForo, Long> {
}

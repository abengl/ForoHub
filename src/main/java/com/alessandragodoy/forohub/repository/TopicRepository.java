package com.alessandragodoy.forohub.repository;

import com.alessandragodoy.forohub.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing `Topic` entities.
 */
public interface TopicRepository extends JpaRepository<Topic, Long> {
}

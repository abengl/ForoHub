package com.alessandragodoy.forohub.repository;

import com.alessandragodoy.forohub.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}

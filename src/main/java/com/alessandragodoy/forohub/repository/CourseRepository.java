package com.alessandragodoy.forohub.repository;

import com.alessandragodoy.forohub.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
	Optional<Course> findByNameIgnoreCase(String course);
}

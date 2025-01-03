package com.alessandragodoy.forohub.repository;

import com.alessandragodoy.forohub.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for managing `Course` entities.
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
	/**
	 * Finds a `Course` entity by its name, ignoring case considerations.
	 *
	 * @param course the name of the course to search for
	 * @return an `Optional` containing the found `Course` entity, or empty if not found.
	 */
	Optional<Course> findByNameIgnoreCase(String course);
}

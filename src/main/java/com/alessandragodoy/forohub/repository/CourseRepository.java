package com.alessandragodoy.forohub.repository;

import com.alessandragodoy.forohub.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

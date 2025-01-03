package com.alessandragodoy.forohub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a course in the forum.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 100)
	private String name;

	@Enumerated(EnumType.STRING)
	@NotNull
	private CourseCategory category;
}

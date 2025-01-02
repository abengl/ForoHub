package com.alessandragodoy.forohub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topic")
@Entity
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 100)
	private String title;

	@NotBlank
	@Size(max = 500)
	private String message;

	@NotNull
	private LocalDateTime creationDate;

	@Enumerated(value = EnumType.STRING)
	@NotNull
	private TopicStatus status;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private UserForo author;

	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;

	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Answer> answers;

}

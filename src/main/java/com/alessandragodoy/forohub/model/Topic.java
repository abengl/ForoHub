package com.alessandragodoy.forohub.model;

import com.alessandragodoy.forohub.dto.RequestCreateTopic;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
	@Column(unique = true)
	private String title;

	@NotBlank
	@Size(max = 500)
	@Column(unique = true)
	private String message;

	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
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


	public Topic(RequestCreateTopic request, LocalDateTime date,UserForo userForo, Course course) {
		title = request.title();
		message = request.message();
		creationDate = date;
		status = TopicStatus.OPEN;
		author = userForo;
		this.course = course;
		answers = new ArrayList<>();
	}
}

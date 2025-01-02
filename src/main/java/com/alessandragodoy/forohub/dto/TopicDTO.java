package com.alessandragodoy.forohub.dto;

import com.alessandragodoy.forohub.model.Topic;

import java.util.List;

public record TopicDTO(
		String title,
		String message,
		String creationDate,
		String status,
		String author,
		String course,
		List<AnswerDTO> answers
){
	public TopicDTO(Topic topic){
		this(
				topic.getTitle(),
				topic.getMessage(),
				topic.getCreationDate().toString(),
				topic.getStatus().toString(),
				topic.getAuthor().getName(),
				topic.getCourse().getName(),
				topic.getAnswers().stream().map(AnswerDTO::new).toList()
		);
	}
}

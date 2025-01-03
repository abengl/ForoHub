package com.alessandragodoy.forohub.dto;

import com.alessandragodoy.forohub.model.Topic;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

/**
 * Represents a Topic with its details.
 *
 * @param title        the title of the topic
 * @param message      the message content of the topic
 * @param creationDate the creation date of the topic
 * @param status       the status of the topic
 * @param author       the author of the topic
 * @param course       the course related to the topic
 * @param answers      the list of answers to the topic
 */
public record TopicDTO(
		String title,
		String message,
		@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
		String creationDate,
		String status,
		String author,
		String course,
		List<AnswerDTO> answers
) {
	public TopicDTO(Topic topic) {
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

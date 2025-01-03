package com.alessandragodoy.forohub.dto;

import com.alessandragodoy.forohub.model.Answer;

public record AnswerDTO(
		Long id,
		String replyMessage,
		String creationDate,
		String author
) {
	public AnswerDTO(Answer answer) {
		this(
				answer.getId(),
				answer.getReplyMessage(),
				answer.getCreationDate().toString(),
				answer.getAuthor().getName()
		);
	}
}

package com.alessandragodoy.forohub.dto;

import com.alessandragodoy.forohub.model.Answer;

/**
 * Data Transfer Object for Answer.
 *
 * @param id           the ID of the answer
 * @param replyMessage the reply message of the answer
 * @param creationDate the creation date of the answer
 * @param author       the author of the answer
 */
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

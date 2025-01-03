package com.alessandragodoy.forohub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating a new topic.
 *
 * @param title   the title of the topic
 * @param message the message of the topic
 * @param email   the email of the user creating the topic
 * @param course  the course related to the topic
 */
public record RequestCreateTopic(
		@NotBlank(message = "The title is a required value can not be empty.")
		@Size(max = 100, message = "The maximum number of characters is 100")
		String title,
		@NotBlank(message = "The message is a required value can not be empty.")
		@Size(max = 500, message = "The maximum number of characters is 500")
		String message,
		@Email
		@NotBlank(message = "The email is a required value can not be empty.")
		String email,
		@NotBlank(message = "The course is a required value can not be empty.")
		String course
) {
}

package com.alessandragodoy.forohub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestCreateTopic(
		@NotBlank(message = "The title is a required value can not be empty.")
		@Size(max = 100, message = "The maximum number of characters is 100")
		String title,
		@NotBlank(message = "The message is a required value can not be empty.")
		@Size(max = 100, message = "The maximum number of characters is 500")
		String message,
		@Email
		@NotBlank(message = "The username is a required value can not be empty.")
		String email,
		@NotBlank(message = "The course is a required value can not be empty.")
		String course
) {
}

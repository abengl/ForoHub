package com.alessandragodoy.forohub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO for user authentication.
 *
 * @param email    the email of the user
 * @param password the password of the user
 */
public record AuthenticateUser(
		@NotBlank(message = "The email is a required value can not be empty.")
		@Email
		String email,
		@NotBlank(message = "The password is a required value can not be empty.")
		String password) {
}

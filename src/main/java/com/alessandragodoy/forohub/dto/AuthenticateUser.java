package com.alessandragodoy.forohub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticateUser(
		@NotBlank
		@Email
		String email,
		@NotBlank
		String password) {
}

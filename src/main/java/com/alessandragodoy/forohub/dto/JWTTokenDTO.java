package com.alessandragodoy.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public record JWTTokenDTO(@NotBlank String token) {
}

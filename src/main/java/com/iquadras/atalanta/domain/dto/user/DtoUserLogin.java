package com.iquadras.atalanta.domain.dto.user;

import jakarta.validation.constraints.NotBlank;

public record DtoUserLogin(@NotBlank String email, @NotBlank String password) {
}

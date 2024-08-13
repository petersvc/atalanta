package com.iquadras.atalanta.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record DtoUserLogin(@NotBlank String userEmail,
        @NotBlank String userPassword) {
}

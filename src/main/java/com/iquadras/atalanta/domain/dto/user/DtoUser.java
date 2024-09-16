package com.iquadras.atalanta.domain.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DtoUser(
    @NotBlank String name,
    @NotBlank String email,
    @NotBlank @Pattern(regexp = "^\\d{11}$", message = "O número do celular deve conter 11 dígitos") String phone,
    @NotBlank String password
) {
}

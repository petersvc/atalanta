package com.iquadras.atalanta.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DtoUser(@NotBlank String userFullName,
                      @NotBlank String userEmail,
                      @NotBlank @Pattern(regexp = "^\\d{11}$", message = "O número do celular deve conter 11 dígitos") String userPhoneNumber,
                      @NotBlank String userPassword) {
}

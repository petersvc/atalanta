package com.iquadras.atalanta.domain.dto.court;

import com.iquadras.atalanta.util.CourtType;
import com.iquadras.atalanta.util.Sports;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.ArrayList;

public record DtoCourt(
    @NotBlank String name,
    @NotBlank @Pattern(regexp = "^\\d{11}$", message = "O número do celular deve conter 11 dígitos") String phone,
    @NotNull Double price,
    @NotBlank String description,
    @NotNull Double latitude,
    @NotNull Double longitude,
    @NotNull ArrayList<Sports> sports,
    @NotNull CourtType type,
    @NotNull Integer capacity,
    @NotNull Double score,
    @NotBlank String imageUrl,
    @NotBlank String address
) {
}

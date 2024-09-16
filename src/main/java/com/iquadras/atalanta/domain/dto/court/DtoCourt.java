package com.iquadras.atalanta.domain.dto.court;

import com.iquadras.atalanta.util.CourtType;
import com.iquadras.atalanta.util.Sports;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;

public record DtoCourt(
    @NotBlank String name,
    @NotBlank String phone,
    @NotBlank Double price,
    @NotBlank String description,
    @NotBlank ArrayList<Sports> sports,
    @NotBlank CourtType type,
    @NotBlank Integer capacity,
    @NotBlank Double score
) {
}

package com.iquadras.atalanta.domain.dto.booking;

import com.iquadras.atalanta.domain.entity.Court;
import com.iquadras.atalanta.domain.entity.User;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoBooking(
    @NotNull Long userId,
    @NotNull Long courtId,
    @NotBlank String date,
    @NotBlank String startTime,
    @Min(1) int durationHours
) {
}
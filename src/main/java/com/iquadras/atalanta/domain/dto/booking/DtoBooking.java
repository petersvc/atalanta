package com.iquadras.atalanta.domain.dto.booking;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record DtoBooking(
    @NotNull Long userId,
    @NotNull Long courtId,
    @NotNull LocalDate date,
    @NotBlank String startTime,
    @NotNull @Min(1) int durationHours
) {
}
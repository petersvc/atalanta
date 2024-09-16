package com.iquadras.atalanta.domain.dto.booking;

import com.iquadras.atalanta.domain.entity.Court;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DtoBooking(
    @NotNull Long userId,
    @NotNull Court court,
    @NotNull LocalDateTime startTime,
    @Min(1) int durationHours
) {
}
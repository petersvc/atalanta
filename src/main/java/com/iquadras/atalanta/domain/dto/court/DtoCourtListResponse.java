package com.iquadras.atalanta.domain.dto.court;

import com.iquadras.atalanta.util.CourtType;
import com.iquadras.atalanta.util.Sports;
import java.util.ArrayList;

public record DtoCourtListResponse(
    Long id,
    String name,
    String phone,
    Double price,
    String description,
    ArrayList<Sports> sports,
    CourtType type,
    Integer capacity,
    Double score
) {
}

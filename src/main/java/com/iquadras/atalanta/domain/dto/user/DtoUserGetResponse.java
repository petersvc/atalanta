package com.iquadras.atalanta.domain.dto.user;

public record DtoUserGetResponse(
    Long id,
    String name,
    String email,
    String phone,
    String imageUrl
) {
}

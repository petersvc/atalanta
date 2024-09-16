package com.iquadras.atalanta.domain.dto.user;

public record DtoUserPostResponse(
    Long id,
    String name,
    String email,
    String phone) {
}

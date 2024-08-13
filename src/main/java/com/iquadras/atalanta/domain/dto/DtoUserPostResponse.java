package com.iquadras.atalanta.domain.dto;

public record DtoUserPostResponse(
    Long userId,
    String userFullName,
    String userEmail,
    String userPhoneNumber) {
}

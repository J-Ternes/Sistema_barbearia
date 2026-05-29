package com.jonathandev.barberia.dto;

import com.jonathandev.barberia.model.UserEnum;

public record UserResponseDto(
        String nome,
        UserEnum role
) {
}

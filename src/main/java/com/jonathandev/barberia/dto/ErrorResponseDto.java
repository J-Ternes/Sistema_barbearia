package com.jonathandev.barberia.dto;

import java.time.LocalDateTime;

public record ErrorResponseDto(
        int status,
        String mensagem,
        LocalDateTime timestamp
) {
}

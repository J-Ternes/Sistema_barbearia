package com.jonathandev.barberia.dto;

import java.util.UUID;

public record BarbeiroRegisterDto(
        String cpf,
        UUID userId,
        UUID barbeariaId

) {
}

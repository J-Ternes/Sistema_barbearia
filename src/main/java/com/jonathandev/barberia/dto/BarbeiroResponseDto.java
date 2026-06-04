package com.jonathandev.barberia.dto;

import com.jonathandev.barberia.model.BarbeariaModel;
import com.jonathandev.barberia.model.BarbeiroModel;
import com.jonathandev.barberia.model.UserModel;

public record BarbeiroResponseDto(
        String cpf,
        String nomeBarbeiro,
        String emailBarbeiro,
        String nomeBarbearia
) {
}

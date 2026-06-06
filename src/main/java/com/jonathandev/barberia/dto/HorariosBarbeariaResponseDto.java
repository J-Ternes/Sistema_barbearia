package com.jonathandev.barberia.dto;

import com.jonathandev.barberia.model.BarbeariaModel;
import com.jonathandev.barberia.model.DiaSemana;

import java.time.LocalTime;
import java.util.UUID;

public record HorariosBarbeariaResponseDto(
        DiaSemana diaFuncionamento,
        LocalTime horarioAbertura,
        LocalTime horarioEncerramento,
        String nomeBarbearia
) {
}

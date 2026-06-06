package com.jonathandev.barberia.dto;

import com.jonathandev.barberia.model.DiaSemana;

import java.time.LocalTime;
import java.util.UUID;

public record HorarioBarbeariaRegisterDto(
        DiaSemana diaFuncionamento,
        LocalTime horarioAbertura,
        LocalTime horarioEncerramento,
        UUID barbearia
) {
}

package com.jonathandev.barberia.dto;

import com.jonathandev.barberia.model.DiaSemana;


import java.time.LocalTime;

public record HorarioBarbeiroResponseDto(
        DiaSemana diaDisponivel,
        LocalTime horarioInicio,
        LocalTime horarioFim,
        String nomeBarbeiro
) {
}

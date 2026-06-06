package com.jonathandev.barberia.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record HorarioBarbeiroResponseDto(
        DayOfWeek diaDisponivel,
        LocalTime horarioInicio,
        LocalTime horarioFim,
        String nomeBarbeiro
) {
}

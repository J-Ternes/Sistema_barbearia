package com.jonathandev.barberia.dto;


import com.jonathandev.barberia.model.DiaSemana;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

public record HorarioBarbeiroRegisterDto(
        DiaSemana diaDisponivel,
        LocalTime horarioInicio,
        LocalTime horarioFim,
        UUID barbeiro
) {
}

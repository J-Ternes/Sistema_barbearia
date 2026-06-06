package com.jonathandev.barberia.dto;


import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

public record HorarioBarbeiroRegisterDto(
        DayOfWeek diaDisponivel,
        LocalTime horarioInicio,
        LocalTime horarioFim,
        UUID barbeiro
) {
}

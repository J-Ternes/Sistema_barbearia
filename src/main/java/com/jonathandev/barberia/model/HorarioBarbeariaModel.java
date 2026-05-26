package com.jonathandev.barberia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "horario_barbearia")
@Data
public class HorarioBarbeariaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "dia_funcionamento", nullable = false)
    @NotNull(message = "O dia de funcionamento é obrigatorio")
    private DayOfWeek diaFuncionamento;

    @Column(name = "horario_abertura", nullable = false)
    @NotNull(message = "O horario de abertura é obrigatório")
    private LocalTime horarioAbertura;

    @Column(name = "horario_encerramento", nullable = false)
    @NotNull(message = "O horario de encerramento é obrigatório")
    private LocalTime horarioEncerramento;

    @ManyToOne
    @JoinColumn(name = "barbearia_id",nullable = false)
    private BarbeariaModel barbearia;

}

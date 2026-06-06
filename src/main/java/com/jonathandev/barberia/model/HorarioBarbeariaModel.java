package com.jonathandev.barberia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
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
    private DiaSemana diaFuncionamento;

    @Column(name = "horario_abertura", nullable = false)
    @NotNull(message = "O horario de abertura é obrigatório")
    private LocalTime horarioAbertura;

    @Column(name = "horario_encerramento", nullable = false)
    @NotNull(message = "O horario de encerramento é obrigatório")
    private LocalTime horarioEncerramento;

    @ManyToOne
    @JoinColumn(name = "barbearia_id",nullable = false)
    private BarbeariaModel barbearia;

    @CreationTimestamp
    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    @UpdateTimestamp
    private LocalDateTime atualizadoEm;
}

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
@Table(name = "horario_barbeiro")
@Data
public class HorarioBarbeiroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "dia_disponivel", nullable = false)
    @Enumerated(EnumType.STRING)
    private DayOfWeek diaDisponivel;

    @Column(name = "horario_inicio", nullable = false)
    @NotNull(message = "O campo horarioInicio é obrigatório")
    private LocalTime horarioInicio;

    @Column(name = "horario_fim", nullable = false)
    @NotNull(message = "O campo horarioFim é obrigatório")
    private LocalTime horarioFim;

    @ManyToOne
    @JoinColumn(name = "barbeiro_id", nullable = false)
    private BarbeiroModel barbeiro;

    @CreationTimestamp
    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    @UpdateTimestamp
    private LocalDateTime atualizadoEm;
}

package com.jonathandev.barberia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "agendamento")
@Data
public class AgendamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "dia_agendamento", nullable = false)
    @NotNull(message = "O dia do agendamento é obrigatório")
    private  LocalDateTime diaAgendamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @NotNull(message = "O campo status é obrigatório")
    private StatusAgendamentoEnum status;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private UserModel usuario;

    @ManyToOne
    @JoinColumn(name = "barbeiro_id", nullable = false)
    private BarbeiroModel barbeiroEscolhido;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private ServicosModel servicoEscolhido;

    @ManyToOne
    @JoinColumn(name = "barbearia_id", nullable = false)
    private BarbeariaModel barbearia;

    @CreationTimestamp
    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    @UpdateTimestamp
    private LocalDateTime atualizadoEm;
}

package com.jonathandev.barberia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name= "barbeiros")
@Data
public class BarbeiroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "É obrigatório preencher o CPF")
    @Column(name = "cpf", nullable = false, unique = true)
    @Size(max = 14)
    private String cpf;

    private boolean ativo;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UserModel usuario;

    @ManyToOne
    @JoinColumn(name = "id_barbearia", nullable = false)
    private BarbeariaModel barbearia;

    @CreationTimestamp
    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    @UpdateTimestamp
    private LocalDateTime atualizadoEm;
}

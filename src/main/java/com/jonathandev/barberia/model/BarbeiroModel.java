package com.jonathandev.barberia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;


@Entity
@Table(name= "barbeiros")
@Data
public class BarbeiroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "É obrigatório preencher o CPF")
    @Column(name = "CPF", nullable = false, unique = true)
    private String cpf;

    private boolean ativo;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UserModel usuario;

    @ManyToOne
    @JoinColumn(name = "id_barbearia", nullable = false)
    private BarbeariaModel barbearia;
}

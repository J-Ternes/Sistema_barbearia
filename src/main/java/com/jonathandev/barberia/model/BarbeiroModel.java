package com.jonathandev.barberia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table(name= "barbeiros")
public class BarbeiroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "É obrigatório preencher o campo nome")
    @Column(name = "nome_barbeiro", nullable = false)
    private String nomeBarbeiro;

    @NotBlank(message = "É obrigatório preencher o CPF")
    @Column(name = "CPF", nullable = false)
    private String cpf;

    private boolean ativo;

    @ManyToOne
    private BarbeiroModel idBarbearia;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UserModel usuario;

    @ManyToOne
    @JoinColumn(name = "id_barbearia", nullable = false)
    private BarbeariaModel barbearia;
}

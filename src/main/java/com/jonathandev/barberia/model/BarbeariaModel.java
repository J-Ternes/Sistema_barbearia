package com.jonathandev.barberia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "barbearias")
public class BarbeariaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank (message = "O campo nome é obrigatório")
    @Column(nullable = false, name = "nome_barbearia")
    private String nomeBarbearia;

    @NotBlank (message = "O campo nome é obrigatório")
    @Column(nullable = false)
    private String cnpj;

    @OneToMany(mappedBy = "barbearia", cascade = CascadeType.ALL)
    private List<BarbeiroModel> barbeiros;

    @Column(name = "criado_em")
    @CreationTimestamp
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    @UpdateTimestamp
    private LocalDateTime atualizadoEm;

}

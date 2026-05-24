package com.jonathandev.barberia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O campo nome é obrigatório!")
    @Column(nullable = false) //Não pode ser nulo
    private String nome;

    @NotBlank(message = "O campo email é obrigatório!")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "O campo senha é obrigatório!")
    @Column(nullable = false)
    private String senha;

    private LocalDate data_aniversario;

    @Enumerated(EnumType.STRING)
    private UserEnum role;

    @Column(name = "criado_em")
    @CreationTimestamp
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    @UpdateTimestamp
    private LocalDateTime atualizadoEm;
}

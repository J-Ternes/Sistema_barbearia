package com.jonathandev.barberia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O campo nome é obrigatório!")
    @Column(nullable = false) //Não pode ser nulo
    @Size(max = 50)
    private String nome;

    @NotBlank(message = "O campo email é obrigatório!")
    @Column(nullable = false, unique = true)
    @Email(message = "O email deve ser um email válido")
    private String email;

    @NotBlank(message = "O campo senha é obrigatório!")
    @Column(nullable = false)
    private String senha;

    private LocalDate data_aniversario;

    @Enumerated(EnumType.STRING)
    private UserEnum role;

    @OneToOne(mappedBy = "usuario")
    private BarbeiroModel barbeiro;

    @Column(name = "criado_em")
    @CreationTimestamp
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    @UpdateTimestamp
    private LocalDateTime atualizadoEm;
}

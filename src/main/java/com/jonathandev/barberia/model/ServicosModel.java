package com.jonathandev.barberia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "servicos_barbearia")
@Data
public class ServicosModel {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @Column(name = "nome_servico", nullable = false)
    @NotBlank(message = "O campo nomeServico é obrigatório")
    @Size(max = 30)
    private String nomeServico;

    @Column(name = "preco_servico", nullable = false)
    @NotNull(message = "O campo precoServico é obrigatório")
    private BigDecimal precoServico;

    private String descricaoServico;

    @Column(name = "duracao_servico", nullable = false)
    @Positive(message = "O campo duracaoServicoMinuto deve ser um valor positivo")
    private int duracaoServicoMinuto;

    @ManyToOne
    @JoinColumn(name = "barbearia_id", nullable = false) //Chave estrangeira
    private BarbeariaModel barbearia;

    @CreationTimestamp
    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    @UpdateTimestamp
    private LocalDateTime atualizadoEm;
}

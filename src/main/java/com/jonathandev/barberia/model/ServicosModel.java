package com.jonathandev.barberia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
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
    private String nomeServico;

    @Column(name = "preco_servico", nullable = false)
    @NotBlank(message = "O campo precoServico é obrigatório")
    private BigDecimal precoServico;

    private String descricaoServico;

    @Column(name = "duracao_servico", nullable = false)
    @NotBlank(message = "O campo duracaoServicoMinuto é obrigatório")
    private int duracaoServicoMinuto;

    @ManyToOne
    @JoinColumn(name = "barbearia_id", nullable = false) //Chave estrangeira
    private BarbeariaModel barbearia;
}

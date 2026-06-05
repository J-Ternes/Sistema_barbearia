package com.jonathandev.barberia.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ServicoRegisterDto(
        String nomeServico,
        BigDecimal precoServico,
        String descricao,
        int duracaoServicoMinuto,
        UUID barbearia
) {
}

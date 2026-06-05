package com.jonathandev.barberia.dto;

import java.math.BigDecimal;

public record ServicoResponseDto(
        String nomeServico,
        BigDecimal precoServico,
        int DuracaoServicoMinuto,
        String descricao
) {
}

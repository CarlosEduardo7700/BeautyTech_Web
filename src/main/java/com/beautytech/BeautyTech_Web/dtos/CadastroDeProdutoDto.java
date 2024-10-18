package com.beautytech.BeautyTech_Web.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CadastroDeProdutoDto(
        String nome,
        String descricao,
        BigDecimal preco,
        LocalDate dataDeFabricacao,
        LocalDate validade,
        Integer quantidadeEmEstoque,
        Integer quantidadeMinimaParaEstoque,
        Integer quantidadeMaximaParaEstoque
) {
}

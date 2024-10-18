package com.beautytech.BeautyTech_Web.dtos;

import com.beautytech.BeautyTech_Web.models.Produto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EdicaoDoProdutoDto(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        LocalDate dataDeFabricacao,
        LocalDate validade,
        LocalDate dataDeCadastro,
        Integer quantidadeEmEstoque,
        Integer quantidadeMinimaParaEstoque,
        Integer quantidadeMaximaParaEstoque
) {

}

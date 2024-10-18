package com.beautytech.BeautyTech_Web.dtos;

import com.beautytech.BeautyTech_Web.models.Produto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ListagemDosProdutosDto(
        Long id,
        String nome,
        BigDecimal preco,
        LocalDate dataDeFabricacao,
        LocalDate validade,
        Integer quantidadeEmEstoque,
        Integer quantidadeMinimaParaEstoque,
        Integer quantidadeMaximaParaEstoque
) {
    public ListagemDosProdutosDto(Produto produto) {
        this(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getDataDeFabricacao(),
                produto.getValidade(),
                produto.getQuantidadeEmEstoque(),
                produto.getQuantidadeMinimaParaEstoque(),
                produto.getQuantidadeMaximaParaEstoque()
        );
    }
}

package com.beautytech.BeautyTech_Web.dtos;

import com.beautytech.BeautyTech_Web.models.Produto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DetalhesDoProdutoDto(
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
    public DetalhesDoProdutoDto(Produto produto) {
        this(
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getDataDeFabricacao(),
                produto.getValidade(),
                produto.getDataDeCadastro(),
                produto.getQuantidadeEmEstoque(),
                produto.getQuantidadeMinimaParaEstoque(),
                produto.getQuantidadeMaximaParaEstoque()
        );
    }
}
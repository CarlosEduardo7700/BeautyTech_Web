package com.beautytech.BeautyTech_Web.dtos;

import com.beautytech.BeautyTech_Web.models.Produto;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EdicaoDoProdutoDto(
        Long id,
        @NotBlank(message = "Nome é obrigatório!")
        @Size(max = 150, message = "Nome deve ter no máximo 150 caracteres.")
        String nome,
        @NotBlank(message = "Descrição é obrigatório!")
        @Size(max = 150, message = "Descrição deve ter no máximo 150 caracteres.")
        String descricao,
        @NotNull(message = "Preço é obrigatório!")
        @Digits(integer = 8, fraction = 2, message = "Preço deve ter até 8 digitos antes da vírgula e até 2 digitos após a vírgula.")
        BigDecimal preco,
        @NotNull(message = "Data de fabricação é obrigatória!")
        @PastOrPresent(message = "A data deve estar no passado ou ser o dia de hoje.")
        LocalDate dataDeFabricacao,
        @Future(message = "Data de validade deve estar no futuro.")
        LocalDate validade,
        LocalDate dataDeCadastro,
        @NotNull(message = "Quantidade de produtos em estoque é obrigatório!")
        @PositiveOrZero(message = "Quantidade de produtos em estoque deve ser positivo ou igual a 0.")
        Integer quantidadeEmEstoque,
        @NotNull(message = "Quantidade mínima de produtos em estoque é obrigatório!")
        @PositiveOrZero(message = "Quantidade mínima de produtos em estoque deve ser positivo ou igual a 0.")
        Integer quantidadeMinimaParaEstoque,
        @NotNull(message = "Quantidade máxima de produtos em estoque é obrigatório!")
        @Positive(message = "Quantidade máxima de produtos em estoque deve ser positivo.")
        Integer quantidadeMaximaParaEstoque
) {

}

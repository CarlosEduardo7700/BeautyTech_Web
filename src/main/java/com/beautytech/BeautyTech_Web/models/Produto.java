package com.beautytech.BeautyTech_Web.models;

import com.beautytech.BeautyTech_Web.dtos.CadastroDeProdutoDto;
import com.beautytech.BeautyTech_Web.dtos.EdicaoDoProdutoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "BT_WEB_PRODUTO")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Produto {

    @Id
    @GeneratedValue
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "NM_PRODUTO", length = 150, nullable = false)
    private String nome;

    @Column(name = "DS_PRODUTO", length = 150, nullable = false)
    private String descricao;

    @Column(name = "VL_PRODUTO", precision = 8, scale = 2, nullable = false)
    private BigDecimal preco;

    @Column(name = "DT_FABRICACAO_PRODUTO", nullable = false)
    private LocalDate dataDeFabricacao;

    @Column(name = "DT_VALIDADE")
    private LocalDate validade;

    @CreatedDate
    @Column(name = "DT_CADASTRO", nullable = false)
    private LocalDate dataDeCadastro;

    @Column(name = "QT_ESTOQUE", nullable = false)
    private Integer quantidadeEmEstoque;

    @Column(name = "QT_MIN_ESTOQUE", nullable = false)
    private Integer quantidadeMinimaParaEstoque;

    @Column(name = "QT_MAX_ESTOQUE", nullable = false)
    private Integer quantidadeMaximaParaEstoque;

    public Produto(CadastroDeProdutoDto produto) {
        nome = produto.nome();
        descricao = produto.descricao();
        preco = produto.preco();
        dataDeFabricacao = produto.dataDeFabricacao();
        validade = produto.validade();
        quantidadeEmEstoque = produto.quantidadeEmEstoque();
        quantidadeMinimaParaEstoque = produto.quantidadeMinimaParaEstoque();
        quantidadeMaximaParaEstoque = produto.quantidadeMaximaParaEstoque();
    }

    public Produto(EdicaoDoProdutoDto produto) {
        id = produto.id();
        nome = produto.nome();
        descricao = produto.descricao();
        preco = produto.preco();
        dataDeFabricacao = produto.dataDeFabricacao();
        validade = produto.validade();
        dataDeCadastro = produto.dataDeCadastro();
        quantidadeEmEstoque = produto.quantidadeEmEstoque();
        quantidadeMinimaParaEstoque = produto.quantidadeMinimaParaEstoque();
        quantidadeMaximaParaEstoque = produto.quantidadeMaximaParaEstoque();
    }
}

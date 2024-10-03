package com.beautytech.BeautyTech_Web.controllers;

import com.beautytech.BeautyTech_Web.models.Produto;
import com.beautytech.BeautyTech_Web.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public String exibirHome(Model model) {

        var quantidadeEmEstoque = 0;

        for (Produto produto : produtoRepository.findAll()) {
            quantidadeEmEstoque += produto.getQuantidadeEmEstoque();
        }

        model.addAttribute("quantidadeDeProdutos", quantidadeEmEstoque);

        var produtosEmExcesso = produtoRepository.findAll().stream()
                .filter(produto -> produto.getQuantidadeEmEstoque() > produto.getQuantidadeMaximaParaEstoque()).toList();

        model.addAttribute("quantidadeDeProdutosEmExcesso", produtosEmExcesso.size());

        var produtosEmFalta = produtoRepository.findAll().stream()
                .filter(produto -> produto.getQuantidadeEmEstoque() < produto.getQuantidadeMinimaParaEstoque()).toList();

        model.addAttribute("quantidadeDeProdutosEmFalta", produtosEmFalta.size());

        return "home";
    }
}

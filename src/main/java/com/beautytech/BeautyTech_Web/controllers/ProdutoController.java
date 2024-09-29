package com.beautytech.BeautyTech_Web.controllers;

import com.beautytech.BeautyTech_Web.models.Produto;
import com.beautytech.BeautyTech_Web.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("cadastrar")
    public String exibirFormularioCadastrar(Model model) {
        model.addAttribute("produto", new Produto());
        return "produto/form-cadastrar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrarProduto(Produto produto, Model model) {
        produtoRepository.save(produto);
        model.addAttribute("mensagem", "Produto cadastrado!");
        return "produto/form-cadastrar";
    }

    @GetMapping
    public String exibirProdutos(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "produto/list-produtos";
    }
}

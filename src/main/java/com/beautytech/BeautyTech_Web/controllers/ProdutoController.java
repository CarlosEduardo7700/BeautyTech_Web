package com.beautytech.BeautyTech_Web.controllers;

import com.beautytech.BeautyTech_Web.models.Produto;
import com.beautytech.BeautyTech_Web.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public String exibirProdutos(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "produto/list-produtos";
    }

    @GetMapping("cadastrar")
    public String exibirFormularioCadastrar(Model model) {
        model.addAttribute("produto", new Produto());
        return "produto/form-cadastrar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrarProduto(Produto produto, RedirectAttributes redirectAttributes) {
        produtoRepository.save(produto);
        redirectAttributes.addFlashAttribute("mensagem", "Produto cadastrado!");
        return "redirect:/produto/cadastrar";
    }

    @GetMapping("editar/{id}")
    public String exibirFormularioEditar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("produto", produtoRepository.getReferenceById(id));
        return "produto/form-editar";
    }

    @PostMapping("editar")
    public String editarProduto(Produto produto, RedirectAttributes redirectAttributes){
        produtoRepository.save(produto);
        redirectAttributes.addFlashAttribute("mensagem", "O produto foi atualizado!");
        return "redirect:/produto";
    }

    @PostMapping("deletar")
    @Transactional
    public String deletarProduto(Long id, RedirectAttributes redirectAttributes) {
        produtoRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Produto Deletado!");
        return "redirect:/produto";
    }

    @GetMapping("info/{id}")
    public String exibirInformacoesDoProduto(@PathVariable("id") Long id, Model model) {
        model.addAttribute("produto", produtoRepository.getReferenceById(id));
        return "produto/detail-produto";
    }

    @GetMapping("pesquisar-por-nome")
    public String exibirProdutosPesquisados(@RequestParam("nomePesquisa") String nomePesquisa, Model model) {
        model.addAttribute("produtos", produtoRepository.findByNomeContainingIgnoreCase(nomePesquisa));
        return "produto/list-produtos";
    }


}

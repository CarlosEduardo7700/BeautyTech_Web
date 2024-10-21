package com.beautytech.BeautyTech_Web.controllers;

import com.beautytech.BeautyTech_Web.dtos.*;
import com.beautytech.BeautyTech_Web.models.Produto;
import com.beautytech.BeautyTech_Web.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public String exibirProdutos(Model model) {
        List<ListagemDosProdutosDto> produtos = produtoRepository.findAll()
                .stream().map(ListagemDosProdutosDto::new).toList();
        model.addAttribute("produtos", produtos);
        return "produto/list-produtos";
    }

    @GetMapping("cadastrar")
    public String exibirFormularioCadastrar(CadastroDeProdutoDto dto, Model model) {
        model.addAttribute("produto", dto);
        return "produto/form-cadastrar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrarProduto(@Valid @ModelAttribute("produto") CadastroDeProdutoDto dto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "produto/form-cadastrar";
        }
        Produto produto = new Produto(dto);
        produtoRepository.save(produto);
        redirectAttributes.addFlashAttribute("mensagem", "Produto cadastrado!");
        return "redirect:/produto/cadastrar";
    }

    @GetMapping("editar/{id}")
    public String exibirFormularioEditar(@PathVariable("id") Long id, Model model) {
        ProdutoDto dto = new ProdutoDto(produtoRepository.getReferenceById(id));
        model.addAttribute("produto", dto);
        return "produto/form-editar";
    }

    @PostMapping("editar")
    public String editarProduto(@Valid @ModelAttribute("produto") EdicaoDoProdutoDto dto, BindingResult result, RedirectAttributes redirectAttributes, Model model){
        if (result.hasErrors()) {
            return "produto/form-editar";
        }
        Produto produto = new Produto(dto);
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
        DetalhesDoProdutoDto dto = new DetalhesDoProdutoDto(produtoRepository.getReferenceById(id));
        model.addAttribute("produto", dto);
        return "produto/detail-produto";
    }

    @GetMapping("pesquisar-por-nome")
    public String exibirProdutosPesquisados(@RequestParam("nomePesquisa") String nomePesquisa, Model model) {

        List<ListagemDosProdutosDto> produtos = produtoRepository.findByNomeContainingIgnoreCase(nomePesquisa)
                .stream().map(ListagemDosProdutosDto::new).toList();

        model.addAttribute("produtos", produtos);
        return "produto/list-produtos";
    }


}

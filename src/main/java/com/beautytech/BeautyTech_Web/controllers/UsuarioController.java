package com.beautytech.BeautyTech_Web.controllers;

import com.beautytech.BeautyTech_Web.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("cadastrar")
    public String exibirCadastroDeUsuario(Model model) {
        model.addAttribute("roles", roleRepository.findAll());
        return "usuario/form-cadastrar";
    }
}

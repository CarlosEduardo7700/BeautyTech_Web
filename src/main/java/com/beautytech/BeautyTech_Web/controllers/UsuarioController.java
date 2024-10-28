package com.beautytech.BeautyTech_Web.controllers;

import com.beautytech.BeautyTech_Web.dtos.usuario.CadastroDeUsuarioDto;
import com.beautytech.BeautyTech_Web.repositories.RoleRepository;
import com.beautytech.BeautyTech_Web.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("cadastrar")
    public String exibirCadastroDeUsuario(CadastroDeUsuarioDto dto, Model model) {
        model.addAttribute("usuario", dto);
        model.addAttribute("roles", roleRepository.findAll());
        return "usuario/form-cadastrar";
    }

    @PostMapping("cadastrar")
    public String cadastrarUsuario(@ModelAttribute("usuario") CadastroDeUsuarioDto dto) {
        usuarioService.saveUser(dto.email(), passwordEncoder.encode(dto.senha()), dto.roles());
        return "redirect:/login";
    }
}

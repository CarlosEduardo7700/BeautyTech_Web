package com.beautytech.BeautyTech_Web.services;

import com.beautytech.BeautyTech_Web.models.Role;
import com.beautytech.BeautyTech_Web.models.Usuario;
import com.beautytech.BeautyTech_Web.repositories.RoleRepository;
import com.beautytech.BeautyTech_Web.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new UsernameNotFoundException("O email do usuário não foi encontrado em nossa base de dados!");
        }

        Set<SimpleGrantedAuthority> authorities = usuario.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getNome()))
                .collect(Collectors.toSet());

        return new User(
                usuario.getEmail(),
                usuario.getSenha(),
                authorities
        );
    }

    public void saveUser(String email, String senha, List<String> roles){
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);

        HashSet<Role> rolesDoUsuario = new HashSet<>();
        for (String nomeDaRole : roles) {
            Role role = roleRepository.findByNome(nomeDaRole);
            if (role != null) {
                rolesDoUsuario.add(role);
            }
        }
        usuario.setRoles(rolesDoUsuario);
        usuarioRepository.save(usuario);
    }
}

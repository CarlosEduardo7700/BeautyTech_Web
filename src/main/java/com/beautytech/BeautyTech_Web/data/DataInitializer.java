//package com.beautytech.BeautyTech_Web.data;
//
//import com.beautytech.BeautyTech_Web.models.Role;
//import com.beautytech.BeautyTech_Web.models.Usuario;
//import com.beautytech.BeautyTech_Web.repositories.RoleRepository;
//import com.beautytech.BeautyTech_Web.repositories.UsuarioRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.time.LocalDate;
//import java.util.Set;
//
//@Configuration
//public class DataInitializer {
//    @Bean
//    CommandLineRunner initDatabase(UsuarioRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
//        return args -> {
//            Role adminRole = new Role();
//            adminRole.setNome("ROLE_ADMIN");
//            adminRole.setLabel("Administrador");
//            roleRepository.save(adminRole);
//
//            Role userRole = new Role();
//            userRole.setNome("ROLE_USER");
//            userRole.setLabel("Usuário");
//            roleRepository.save(userRole);
//
//            Usuario admin = new Usuario();
//            admin.setNome("Rodolfo Santos");
//            admin.setCpf("1234567890");
//            admin.setDataDeNascimento(LocalDate.now());
//            admin.setEmail("rodolfo@email.com");
//            admin.setSenha(passwordEncoder.encode("admin"));
//            admin.setRoles(Set.of(adminRole));
//            userRepository.save(admin);
//
//            Usuario user = new Usuario();
//            user.setNome("Lucas Augusto");
//            user.setCpf("1234567891");
//            user.setDataDeNascimento(LocalDate.now());
//            user.setEmail("lucas@email.com");
//            user.setSenha(passwordEncoder.encode("user"));
//            user.setRoles(Set.of(userRole));
//            userRepository.save(user);
//        };
//    }
//}
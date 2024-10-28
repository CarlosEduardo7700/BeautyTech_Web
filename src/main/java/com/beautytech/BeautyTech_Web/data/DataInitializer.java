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
//            adminRole.setNome("ADMIN");
//            adminRole.setLabel("Admin");
//            roleRepository.save(adminRole);
//
//            Role userRole = new Role();
//            userRole.setNome("USER");
//            userRole.setLabel("User");
//            roleRepository.save(userRole);
//
//            Usuario admin = new Usuario();
//            admin.setNome("admin");
//            admin.setCpf("1234567891");
//            admin.setDataDeNascimento(LocalDate.now());
//            admin.setEmail("admin@email");
//            admin.setSenha(passwordEncoder.encode("admin"));
//            admin.setRoles(Set.of(adminRole));
//            userRepository.save(admin);
//
//            Usuario user = new Usuario();
//            user.setNome("user");
//            user.setCpf("1234567892");
//            user.setDataDeNascimento(LocalDate.now());
//            user.setEmail("user@email");
//            user.setSenha(passwordEncoder.encode("user"));
//            user.setRoles(Set.of(userRole));
//            userRepository.save(user);
//        };
//    }
//}
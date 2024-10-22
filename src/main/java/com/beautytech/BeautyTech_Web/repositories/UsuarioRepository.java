package com.beautytech.BeautyTech_Web.repositories;

import com.beautytech.BeautyTech_Web.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

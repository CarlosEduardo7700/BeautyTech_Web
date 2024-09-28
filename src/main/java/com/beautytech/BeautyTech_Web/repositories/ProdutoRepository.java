package com.beautytech.BeautyTech_Web.repositories;

import com.beautytech.BeautyTech_Web.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

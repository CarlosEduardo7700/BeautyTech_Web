package com.beautytech.BeautyTech_Web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "BT_WEB_USUARIO")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "NM_USUARIO", length = 150, nullable = false)
    private String nome;

    @Column(name = "DS_EMAIL", length = 150, nullable = false, unique = true)
    private String email;

    @Column(name = "DS_SENHA", nullable = false)
    private String senha;

    @Column(name = "DS_CPF", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "DT_NASCIMENTO", nullable = false)
    private LocalDate dataDeNascimento;

    @CreatedDate
    @Column(name = "DT_CADASTRO", nullable = false)
    private LocalDate dataDeCadastro;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "BT_WEB_ROLE_USUARIO",
            joinColumns = @JoinColumn(name = "ID_USUARIO"),
            inverseJoinColumns = @JoinColumn(name = "ID_ROLE")
    )
    private Set<Role> roles;
}

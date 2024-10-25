package com.beautytech.BeautyTech_Web.dtos.usuario;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public record CadastroDeUsuarioDto(
        @NotBlank(message = "Nome é obrigatório!")
        @Size(max = 150, message = "Nome deve ter no máximo 150 caracteres.")
        String nome,
        @NotBlank(message = "Email é obrigatório!")
        @Size(max = 150, message = "Email deve ter no máximo 150 caracteres.")
        @Email(message = "Formato de email inválido.")
        String email,
        @NotBlank(message = "Senha é obrigatória!")
        @Pattern(
                regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
                message = "A senha deve conter ao menos um número, uma letra maiúscula, uma letra minúscula, um caractere especial e não pode conter espaços em branco."
        )
        String senha,
        @NotBlank(message = "CPF é obrigatório!")
        @Size(min = 11, max = 11, message = "CPF deve ter no máximo 11 caracteres.")
        @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas números")
        String cpf,
        @NotNull(message = "Data de nascimento é obrigatória!")
        @Past(message = "A data de nascimento deve estar no passado")
        LocalDate dataDeNascimento,
        List<String> roles
) {
}

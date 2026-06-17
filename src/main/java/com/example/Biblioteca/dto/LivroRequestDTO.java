package com.example.Biblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroRequestDTO(
        @NotBlank String nome,
        @NotBlank String descricao,

       // boolean lido,
        @NotNull Long autorId,
        @NotNull Long editoraId
) { }

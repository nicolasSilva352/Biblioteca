package com.example.Biblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EditoraRequestDTO(
        @NotNull Long id,
        @NotBlank String nome,

        @NotBlank String cnpj
) {
}

package com.example.Biblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AutorRequestDTO(
        @NotBlank String nome,
        @NotNull Integer idade,
        String biografia
) {
}

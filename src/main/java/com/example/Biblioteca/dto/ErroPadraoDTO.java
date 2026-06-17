package com.example.Biblioteca.dto;

import java.time.Instant;

public record ErroPadraoDTO(
        Instant timestamp,
        Integer status,
        String erro,
        String mensagem,
        String caminho
        ) {
}

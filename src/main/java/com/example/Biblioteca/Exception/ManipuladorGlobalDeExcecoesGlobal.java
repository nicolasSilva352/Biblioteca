package com.example.Biblioteca.Exception;

import com.example.Biblioteca.dto.ErroPadraoDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ManipuladorGlobalDeExcecoesGlobal {

    @ExceptionHandler
    public ResponseEntity<ErroPadraoDTO> tratarRuntimeException(RuntimeException e, HttpServletRequest request){

        //404 not found
        HttpStatus status = HttpStatus.NOT_FOUND;

        //DTO bonitao
        ErroPadraoDTO erro = new ErroPadraoDTO(
                Instant.now(),
                status.value(),
                "Recurso nao encontrado",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(erro);
    }
}

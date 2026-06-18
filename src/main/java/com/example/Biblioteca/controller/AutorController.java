package com.example.Biblioteca.controller;


import com.example.Biblioteca.dto.AutorRequestDTO;
import com.example.Biblioteca.dto.AutorResponseDTO;
import com.example.Biblioteca.dto.EditoraRequestDTO;
import com.example.Biblioteca.dto.EditoraResponseDTO;
import com.example.Biblioteca.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorResponseDTO> criarAutor(@RequestBody AutorRequestDTO dto) {
        AutorResponseDTO autorSalvo = autorService.criar(dto);
        // status 201
        return ResponseEntity.status(HttpStatus.CREATED).body(autorSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> atualizarAutor(@PathVariable Long id, @RequestBody AutorRequestDTO dto) {
        AutorResponseDTO autorAtualizado = autorService.atualizarPorID(id, dto);
        return ResponseEntity.ok(autorAtualizado);
    }

    @PutMapping("nome/{nome}")
    public ResponseEntity<AutorResponseDTO> atualizarAutorPorNome(@PathVariable String nome, @RequestBody AutorRequestDTO dto) {
        AutorResponseDTO autorAtualizado = autorService.atualizarPorNome(nome, dto);
        return ResponseEntity.ok(autorAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> obterAutorPorId(@PathVariable Long id){
        AutorResponseDTO autor = autorService.buscarPorId(id);
        return ResponseEntity.ok(autor);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<AutorResponseDTO>> obterAutorPorNome(@PathVariable String nome) {
        List<AutorResponseDTO> autores = autorService.buscarPorNome(nome);
        return ResponseEntity.ok(autores);
    }

    @GetMapping
    public ResponseEntity<List<AutorResponseDTO>> listarTodosAutores() {
        List<AutorResponseDTO> autores = autorService.listarTodos();
        return ResponseEntity.ok(autores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> deletarAutorPorId(@PathVariable Long id) {
        AutorResponseDTO autor = autorService.deletarPorId(id);
        return ResponseEntity.ok(autor);
    }

    @DeleteMapping("/nome/{nome}")
    public ResponseEntity<AutorResponseDTO> deletarAutorPorNome(@PathVariable String nome) {
        AutorResponseDTO autor = autorService.deletarPorNome(nome);
        return ResponseEntity.ok(autor);
    }

}

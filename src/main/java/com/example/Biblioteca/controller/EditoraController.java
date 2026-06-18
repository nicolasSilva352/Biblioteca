package com.example.Biblioteca.controller;

import com.example.Biblioteca.dto.AutorRequestDTO;
import com.example.Biblioteca.dto.AutorResponseDTO;
import com.example.Biblioteca.dto.EditoraRequestDTO;
import com.example.Biblioteca.dto.EditoraResponseDTO;
import com.example.Biblioteca.service.EditoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoras")
@RequiredArgsConstructor
public class EditoraController {

    private final EditoraService editoraService;

    @PutMapping("/{id}")
    public ResponseEntity<EditoraResponseDTO> atualizarEditora(@PathVariable Long id, @RequestBody EditoraRequestDTO dto) {
        EditoraResponseDTO editoraAtualizada = editoraService.atualizarPorID(id, dto);
        return ResponseEntity.ok(editoraAtualizada);
    }

    @PutMapping("nome/{nome}")
    public ResponseEntity<EditoraResponseDTO> atualizarEditoraPorNome(@PathVariable String nome, @RequestBody EditoraRequestDTO dto) {
        EditoraResponseDTO editoraAtualizada = editoraService.atualizarPorNome(nome, dto);
        return ResponseEntity.ok(editoraAtualizada);
    }

    @PostMapping
    public ResponseEntity<EditoraResponseDTO> criarEditora(@RequestBody EditoraRequestDTO dto) {
        EditoraResponseDTO editoraSalva = editoraService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(editoraSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditoraResponseDTO> obterEditoraPorId(@PathVariable Long id){
        EditoraResponseDTO editora = editoraService.buscarPorId(id);
        return ResponseEntity.ok(editora);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<EditoraResponseDTO>> obterEditoraPorNome(@PathVariable String nome) {
        List<EditoraResponseDTO> editoras = editoraService.buscarPorNome(nome);
        return ResponseEntity.ok(editoras);
    }

    @GetMapping
    public ResponseEntity<List<EditoraResponseDTO>> listarTodasEditoras() {
        List<EditoraResponseDTO> editoras = editoraService.listarTodos();
        return ResponseEntity.ok(editoras);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EditoraResponseDTO> deletarEditoraPorId(@PathVariable Long id) {
        EditoraResponseDTO editora = editoraService.deletarPorId(id);
        return ResponseEntity.ok(editora);
    }

    @DeleteMapping("/nome/{nome}")
    public ResponseEntity<EditoraResponseDTO> deletarEditoraPorNome(@PathVariable String nome) {
        EditoraResponseDTO editora = editoraService.deletarPorNome(nome);
        return ResponseEntity.ok(editora);
    }
}

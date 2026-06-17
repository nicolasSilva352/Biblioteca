package com.example.Biblioteca.repository;

import com.example.Biblioteca.Entity.LivroEntity;
//import com.exemplo.projeto.model.Livro;
import com.example.Biblioteca.dto.LivroResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

    @Query("""
        select new com.example.Biblioteca.dto.LivroResponseDTO(
            l.id,
            l.nome,
            l.descricao,
            l.autor.nome,
            l.editora.nome
        )from LivroEntity l 
        where lower(l.nome) like lower(concat('%', :nome, '%'))
""")
    List<LivroResponseDTO> findByNomeContainingIgnoreCase(@Param("nome") String nome);
}
package com.example.Biblioteca.repository;

import com.example.Biblioteca.Entity.EditoraEntity;
import com.example.Biblioteca.dto.EditoraResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditoraRepository extends JpaRepository <EditoraEntity, Long>{

    @Query("""
          select new com.example.Biblioteca.dto.EditoraResponseDTO(
                e.id,
                e.nome,
                e.cnpj
            )
            from EditoraEntity e
            where lower(e.nome) like lower(concat('%', :nome, '%'))
    """)
    List<EditoraResponseDTO> findByNomeContainingIgnoreCase(@Param("nome") String nome);

}

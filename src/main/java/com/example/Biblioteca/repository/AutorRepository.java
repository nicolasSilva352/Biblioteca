package com.example.Biblioteca.repository;

import com.example.Biblioteca.Entity.AutorEntity;
import com.example.Biblioteca.dto.AutorRequestDTO;
import com.example.Biblioteca.dto.AutorResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AutorRepository extends JpaRepository<AutorEntity, Long> {
    @Query("""
          select new com.example.Biblioteca.dto.AutorResponseDTO(
                a.id,
                a.nome,
                a.idade,
                a.biografia
            )
            from AutorEntity a
            where lower(a.nome) like lower(concat('%', :nome, '%'))
    """)
    List<AutorResponseDTO> findByNomeContainingIgnoreCase(@Param("nome") String nome);
}

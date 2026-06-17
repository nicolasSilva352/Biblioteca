package com.example.Biblioteca.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.jspecify.annotations.NonNull;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "EDITORA")
public class EditoraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "nome")
    private String nome;

    @Size(max = 255)
    @Column(name = "cnpj")
    private String cnpj;

    @CreationTimestamp
    @Column(name = "CRIADO_EM")
    private Instant criadoEm;

    @ColumnDefault("NULL")
    @Column(name = "EXCLUIDO_EM")
    private Instant excluidoEm;

    @NonNull
    @OneToMany(mappedBy = "editora")
    private Set<LivroEntity> livros = new LinkedHashSet<>();


}
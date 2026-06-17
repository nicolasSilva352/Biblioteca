package com.example.Biblioteca.Entity;

import jakarta.persistence.*;
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
@Table(name = "AUTOR")
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;


    @Column(name = "NOME")
    private String nome;

    @Column(name = "IDADE")
    private Integer idade;


    @Column(name = "BIOGRAFIA")
    private String biografia;

    @CreationTimestamp
    @Column(name = "CRIADO_EM")
    private Instant criadoEm;

    @ColumnDefault("NULL")
    @Column(name = "EXCLUIDO_EM")
    private Instant excluidoEm;

    @NonNull
    @OneToMany(mappedBy = "autor")
    private Set<LivroEntity> livros = new LinkedHashSet<>();
}

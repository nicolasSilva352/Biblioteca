package com.example.Biblioteca.Entity;

@lombok.Getter
@lombok.Setter@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "emprestimo")
public class Emprestimo {
@jakarta.persistence.Id
@jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
@jakarta.persistence.Column(name = "id", nullable = false)
private java.lang.Long id;

@jakarta.validation.constraints.NotNull
@jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.LAZY, optional = false)
@jakarta.persistence.JoinColumn(name = "usuario_id", nullable = false)
private com.example.Biblioteca.Entity.UsuarioEntity usuario;

@jakarta.validation.constraints.NotNull
@jakarta.persistence.ManyToOne(fetch = jakarta.persistence.FetchType.LAZY, optional = false)
@jakarta.persistence.JoinColumn(name = "livro_id", nullable = false)
private com.example.Biblioteca.Entity.LivroEntity livro;

@jakarta.validation.constraints.NotNull
@jakarta.persistence.Column(name = "data_emprestimo", nullable = false)
private java.time.LocalDate dataEmprestimo;

@jakarta.validation.constraints.NotNull
@jakarta.persistence.Column(name = "data_devolucao_prevista", nullable = false)
private java.time.LocalDate dataDevolucaoPrevista;

@jakarta.validation.constraints.NotNull
@org.hibernate.annotations.ColumnDefault("false")
@jakarta.persistence.Column(name = "devolvido", nullable = false)
private java.lang.Boolean devolvido;

@org.hibernate.annotations.ColumnDefault("now()")
@jakarta.persistence.Column(name = "criado_em")
private java.time.OffsetDateTime criadoEm;

@jakarta.persistence.Column(name = "excluido_em")
private java.time.OffsetDateTime excluidoEm;



}
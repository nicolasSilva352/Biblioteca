package com.example.Biblioteca.Entity;

@lombok.Getter
@lombok.Setter@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "usuario")
public class Usuario {
@jakarta.persistence.Id
@jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
@jakarta.persistence.Column(name = "id", nullable = false)
private java.lang.Long id;

@jakarta.validation.constraints.Size(max = 255)
@jakarta.validation.constraints.NotNull
@jakarta.persistence.Column(name = "nome", nullable = false)
private java.lang.String nome;

@jakarta.validation.constraints.Size(max = 255)
@jakarta.validation.constraints.NotNull
@jakarta.persistence.Column(name = "login", nullable = false)
private java.lang.String login;

@jakarta.validation.constraints.Size(max = 255)
@jakarta.validation.constraints.NotNull
@jakarta.persistence.Column(name = "senha", nullable = false)
private java.lang.String senha;

@org.hibernate.annotations.ColumnDefault("now()")
@jakarta.persistence.Column(name = "criado_em")
private java.time.Instant criadoEm;

@jakarta.persistence.Column(name = "excluido_em")
private java.time.Instant excluidoEm;

@jakarta.persistence.OneToMany(mappedBy = "usuario")
private java.util.Set<com.example.Biblioteca.Entity.UsuarioRole> usuarioRoles = new java.util.LinkedHashSet<>();



}
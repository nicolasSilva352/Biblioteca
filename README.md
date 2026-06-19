# 📚 Biblioteca - Sistema de Gerenciamento de Acervo

> Uma API REST completa para gerenciar livros, autores, editoras e empréstimos em uma biblioteca.

![Java](https://img.shields.io/badge/Java-26-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.0-green?style=flat-square&logo=spring)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-blue?style=flat-square&logo=postgresql)
![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)

## ✨ Features

- ✅ **Autenticação e Autorização** - Sistema JWT seguro com roles de usuário
- 📖 **Gerenciamento de Livros** - CRUD completo com busca avançada
- ✍️ **Controle de Autores** - Gerencie informações dos autores
- 🏢 **Gestão de Editoras** - Catalogar e organizar editoras
- 👥 **Gestão de Usuários** - Sistema de usuários com papéis (roles)
- 📦 **Sistema de Empréstimos** - Controle de empréstimos com data de retorno
- ⏰ **Verificação de Atrasos** - Job automático para verificar empréstimos atrasados
- 🛡️ **Tratamento de Exceções Global** - Respostas de erro padronizadas
- 🚀 **Migrations Automáticas** - Flyway para versionamento de banco de dados

## 🛠️ Stack Tecnológico

### Backend
- **Java 26** - Linguagem de programação
- **Spring Boot 4.1.0** - Framework REST
- **Spring Security** - Autenticação e autorização
- **Spring Data JPA** - Acesso a dados
- **Spring Data JDBC** - Acesso alternativo a dados

### Database
- **PostgreSQL** - Banco de dados relacional
- **Flyway** - Migrations de banco de dados
- **H2 Database** - Banco em memória para testes

### Ferramentas
- **Maven** - Gerenciador de dependências
- **Lombok** - Redução de boilerplate
- **Validation** - Validação de dados

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **Java 26** ou superior
- **Maven 3.6+**
- **PostgreSQL 12+**
- **Git**

## 🚀 Como Instalar e Executar

### 1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/Biblioteca.git
cd Biblioteca
```

### 2. Configure o banco de dados PostgreSQL
```sql
CREATE DATABASE biblioteca;
CREATE USER postgres_user WITH PASSWORD 'senha_segura';
ALTER ROLE postgres_user SET client_encoding TO 'utf8';
ALTER ROLE postgres_user SET default_transaction_isolation TO 'read committed';
ALTER ROLE postgres_user SET timezone TO 'UTC';
GRANT ALL PRIVILEGES ON DATABASE biblioteca TO postgres_user;
```

### 3. Configure as credenciais no `application.yaml`
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/biblioteca
    username: seu_usuario
    password: sua_senha
```

### 4. Compile e execute o projeto
```bash
# Windows
mvnw clean install
mvnw spring-boot:run

# Linux/Mac
./mvnw clean install
./mvnw spring-boot:run
```

A aplicação estará disponível em: **http://localhost:8080**

## 📁 Estrutura do Projeto

```
src/main/java/com/example/Biblioteca/
├── controller/              # Controladores REST
│   ├── AutenticacaoController.java
│   ├── AutorController.java
│   ├── EditoraController.java
│   ├── LivroController.java
│   └── UsuarioController.java
├── dto/                     # Data Transfer Objects
│   ├── LoginRequestDTO.java
│   ├── TokenResponseDTO.java
│   ├── LivroRequestDTO.java
│   ├── LivroResponseDTO.java
│   └── ... outros DTOs
├── entity/                  # Entidades JPA
│   ├── LivroEntity.java
│   ├── AutorEntity.java
│   ├── EditoraEntity.java
│   ├── UsuarioEntity.java
│   ├── EmprestimoEntity.java
│   └── RoleEntity.java
├── repository/              # Repositórios Data Access
│   ├── LivroRepository.java
│   ├── AutorRepository.java
│   ├── EditoraRepository.java
│   ├── UsuarioRepository.java
│   └── EmprestimoRepository.java
├── service/                 # Lógica de Negócio
│   ├── LivroService.java
│   ├── AutorService.java
│   ├── EditoraService.java
│   ├── UsuarioService.java
│   ├── AutenticacaoService.java
│   └── TokenService.java
├── security/                # Configurações de Segurança
│   ├── SecurityConfiguration.java
│   ├── SecurityFilter.java
│   └── UsuarioSecurityAdapter.java
├── exception/               # Manipulação de Exceções
│   └── ManipuladorGlobalDeExcecoesGlobal.java
└── job/                     # Jobs Agendados
    └── VerificarAtrasosJob.java
```

## 🔌 API Endpoints

### 📖 Livros
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/livros` | Criar novo livro |
| GET | `/livros` | Listar todos os livros |
| GET | `/livros/{id}` | Obter livro por ID |
| GET | `/livros/nome/{nome}` | Buscar livros por nome |
| PUT | `/livros/{id}` | Atualizar livro por ID |
| PUT | `/livros/nome/{nome}` | Atualizar livro por nome |
| DELETE | `/livros/{id}` | Deletar livro por ID |
| DELETE | `/livros/nome/{nome}` | Deletar livro por nome |

### ✍️ Autores
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/autores` | Criar novo autor |
| GET | `/autores` | Listar todos os autores |
| GET | `/autores/{id}` | Obter autor por ID |
| PUT | `/autores/{id}` | Atualizar autor |
| DELETE | `/autores/{id}` | Deletar autor |

### 🏢 Editoras
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/editoras` | Criar nova editora |
| GET | `/editoras` | Listar todas as editoras |
| GET | `/editoras/{id}` | Obter editora por ID |
| PUT | `/editoras/{id}` | Atualizar editora |
| DELETE | `/editoras/{id}` | Deletar editora |

### 👥 Usuários
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/usuarios` | Criar novo usuário |
| GET | `/usuarios` | Listar todos os usuários |
| GET | `/usuarios/{id}` | Obter usuário por ID |
| PUT | `/usuarios/{id}` | Atualizar usuário |
| DELETE | `/usuarios/{id}` | Deletar usuário |

### 🔐 Autenticação
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/auth/login` | Fazer login e obter token JWT |
| POST | `/auth/logout` | Fazer logout |

## 📝 Exemplos de Uso

### Autenticação
```bash
# Login
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "usuario@biblioteca.com",
    "senha": "senha123"
  }'

# Resposta
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "tipo": "Bearer",
  "expiracaoEm": 3600000
}
```

### Criar um Livro
```bash
curl -X POST http://localhost:8080/livros \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer seu_token_jwt" \
  -d '{
    "nome": "Clean Code",
    "descricao": "Um manual para escrever código que humanos consigam ler",
    "autorId": 1,
    "editoraId": 1,
    "lido": false
  }'
```

### Buscar Livro por Nome
```bash
curl -X GET http://localhost:8080/livros/nome/Clean%20Code \
  -H "Authorization: Bearer seu_token_jwt"
```

### Listar Todos os Livros
```bash
curl -X GET http://localhost:8080/livros \
  -H "Authorization: Bearer seu_token_jwt"
```

## 🔒 Segurança

- **JWT (JSON Web Tokens)** para autenticação stateless
- **Spring Security** para autorização baseada em roles
- **Validação de entrada** em todas as requisições
- **Tratamento global de exceções** para segurança
- **Proteção contra SQL Injection** via prepared statements

## 📊 Banco de Dados

### Tabelas Principais

- **USUARIO** - Usuários do sistema
- **LIVRO** - Livros do acervo
- **AUTOR** - Autores dos livros
- **EDITORA** - Editoras dos livros
- **EMPRESTIMO** - Registro de empréstimos
- **ROLE** - Papéis de acesso do sistema
- **USUARIO_ROLE** - Associação usuário-papéis

### Migrations
As migrations SQL estão em `src/main/resources/db/migration/` e são executadas automaticamente pelo Flyway.

## 🐛 Troubleshooting

### Problema: Conexão recusada ao PostgreSQL
**Solução:** Verifique se o PostgreSQL está rodando e se as credenciais em `application.yaml` estão corretas.

### Problema: Erro de permissão no Flyway
**Solução:** Certifique-se de que o usuário PostgreSQL tem todas as permissões necessárias no banco.

### Problema: Java version incompatível
**Solução:** Instale Java 26 ou superior (ou modifique a versão em `pom.xml` conforme necessário).

## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. Faça um Fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👨‍💻 Autor

Desenvolvido com ❤️ por [Nicolas]

## 📞 Suporte

Para suporte, abra uma issue no GitHub ou entre em contato através de [nicelarsilva@gmail.com]

---

**⭐ Se este projeto foi útil, considere dar uma estrela! ⭐**


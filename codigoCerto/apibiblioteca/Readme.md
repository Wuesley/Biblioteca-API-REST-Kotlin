# Biblioteca Online - API RESTful

## 📝 Descrição do Projeto

Esta API foi desenvolvida para gerenciar o acervo digital de uma escola técnica, permitindo o controle de livros, autores, usuários e empréstimos de forma segura e eficiente.

## 🔧 Funcionalidades Principais

- **Autenticação segura** com JWT (JSON Web Tokens)
- CRUD completo para:
    - 📚 Livros
    - ✍️ Autores
    - 👥 Usuários
    - 🔄 Empréstimos
- Validações de negócio para empréstimos
- Documentação interativa com Swagger

## 🛠 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Security**
- **JWT**
- **H2 Database** (para desenvolvimento)
- **Lombok**
- **Swagger UI**
- **JUnit 5** (para testes)

## 📚 Documentação da API

A documentação interativa da API está disponível via Swagger UI:

🔗 [Acessar Documentação Swagger](http://localhost:8080/swagger-ui/index.html#/)

## 🚀 Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone [URL_DO_REPOSITORIO]
   ```

2. Configure o ambiente:
    - JDK 17
    - Maven

3. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse:
    - API: `http://localhost:8080`
    - Swagger UI: `http://localhost:8080/swagger-ui/index.html`

## 🧪 Testes

O projeto inclui testes unitários para todas as camadas principais (controller, service, repository). Para executar os testes:

```bash
mvn test
```

## 📊 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── biblioteca/
│   │           ├── config/       # Configurações (Security, Swagger)
│   │           ├── controller/   # Controladores REST
│   │           ├── dto/          # Objetos de Transferência de Dados
│   │           ├── model/        # Entidades JPA
│   │           ├── repository/   # Repositórios Spring Data
│   │           ├── service/      # Lógica de negócio
│   │           └── util/         # Utilitários
│   └── resources/
│       ├── application.properties
└── test/                         # Testes unitários
```

## 🔗 Repositório

📁 [Link do Repositório]() *(https://github.com/Wuesley/Biblioteca-API-REST-Kotlin/tree/main?tab=readme-ov-file)*

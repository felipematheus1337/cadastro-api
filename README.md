# Cadastro API

API de cadastro de pessoas físicas e jurídicas, com validações automáticas de CPF, CNPJ e e-mail. Desenvolvido em Java 21 com Spring Boot, PostgreSQL e Docker.

## 🚀 Tecnologias

- Java 21
- Spring Boot 3
- Spring Data JPA
- Hibernate Validator
- PostgreSQL
- Docker + Docker Compose

## 📄 Funcionalidades

- Cadastro de pessoa física (CPF) e jurídica (CNPJ).
- Confirmação de e-mail no cadastro.
- Validação automática de campos obrigatórios.
- Restrições de unicidade para CPF e e-mail.
- Docker Compose para orquestração dos containers.

## 🛠️ Como executar

### Pré-requisitos
- Docker e Docker Compose instalados
- (Opcional) Java 21 e Gradle instalados localmente

### Executar com Docker

1. Gere o JAR:
    ```bash
    ./gradlew build -x test
    ```

2. Construa e suba os containers:
    ```bash
    docker-compose up --build
    ```

3. A API estará disponível em:
    ```
    http://localhost:8080
    ```

### Executar localmente (sem Docker)

1. Suba o banco de dados PostgreSQL localmente.
2. Altere as propriedades de conexão em `application.properties`.
3. Rode o projeto com:
    ```bash
    ./gradlew bootRun
    ```

## 📋 Estrutura da API

| Entidade | Descrição |
|:---------|:----------|
| Pessoa | Dados da pessoa física ou jurídica |
| Endereço | Endereço da pessoa |

## 🖼️ Diagrama ER (Entidade-Relacionamento)

![Diagrama ER](./assets/er-diagrama.png)

## 📃 Licença

Este projeto está licenciado sob a licença MIT.

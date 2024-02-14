# Redway-test

Redway-test é uma aplicação web MVC desenvolvida em Java utilizando o framework Spring Boot. Utiliza a template engine Thymeleaf para as views e o banco de dados PostgreSQL para persistência de dados. A aplicação foi containerizada usando Docker e é gerenciada por um arquivo Docker Compose.

## Instruções para testar a aplicação

### Pré-requisitos

- Docker
- Docker Compose

### Passo-a-passo

1. Clone ou baixe o projeto para sua máquina local.
2. Abra o terminal na raiz do projeto (pasta backend).
3. Execute o seguinte comando no terminal:
   ```
   docker compose up --build
   ```
4. Abra o navegador e vá até o endereço http://localhost:8080.

A aplicação contém um formulário que permite coletar o nome, sobrenome e email do usuário. Ela valida se o email já existe na base de dados e retorna uma página de sucesso ou de erro conforme o caso.

# 📦 Cadastro de Produtos

![Java](https://img.shields.io/badge/Java-17-blue?style=flat&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-green?style=flat&logo=spring)
![Maven](https://img.shields.io/badge/Maven-3.8.6-orange?style=flat&logo=apache-maven)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat&logo=mysql)
![GitHub](https://img.shields.io/badge/GitHub-Repository-black?style=flat&logo=github)

Sistema desenvolvido em **Java com Spring Boot** para gerenciar produtos com **segurança integrada (Spring Security + JWT)**.  
O projeto segue a arquitetura em camadas (**Controller, Service, Repository, Model e Security**) e utiliza **JPA/Hibernate** para persistência em banco de dados MySQL.

---

## ⚙️ Funcionalidades
- 🔐 Autenticação e autorização de usuários com JWT  
- Cadastrar novos produtos  
- Listar todos os produtos  
- Buscar produto por ID  
- Atualizar informações de um produto  
- Deletar produto  

---

## 🔧 Como Executar o Projeto

### 1️⃣ Clonar o repositório
```bash
git clone https://github.com/joaogt01/CadastroDeEstoque.git 
```
### 2️⃣ Configurar o banco de dados
```bash
CREATE DATABASE cadastro_produtos;
```
Edite src/main/resources/application.properties:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/cadastro_produtos
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
### 3️⃣ Rodar o projeto
```bash
./mvnw spring-boot:run
```
📌 Endpoints da API

Nota: Todos os endpoints de produtos estão protegidos. É necessário autenticar-se primeiro para obter um token JWT.

🔹 Autenticação
```bash
POST /produtos/autenticacao/registrar

{
  "nome": "maria",
  "usuario": "teste",
  "senha": "123"
}

POST /produtos/autenticacao/login

{
  "usuario": "teste",
  "senha": "123"
}
```
🔹 Cadastrar produto
```bash
POST /produtos/criar

{
  "nome": "Notebook Dell",
  "preco": 3500.00,
  "quantidade": 5
}
```

🔹 Listar todos os produtos
```bash 
GET /produtos/listar
```

🔹 Buscar produto por ID
```bash
GET /produtos/listar/{id}
```
🔹 Atualizar produto
```bash
PUT /produtos/alterar/{id}

{
  "nome": "Notebook Dell Inspiron",
  "preco": 3800.00,
  "quantidade": 4
}
```
🔹 Deletar produto
```bash
DELETE /produtos/deletar/{id}

# 📦 Cadastro De Estoque

![Java](https://img.shields.io/badge/Java-24-blue?style=flat&logo=java) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-green?style=flat&logo=spring) ![Maven](https://img.shields.io/badge/Maven-3.8.6-orange?style=flat&logo=apache-maven) ![MySQL](https://img.shields.io/badge/Postgres-16-blue?style=flat&logo=mysql) ![GitHub](https://img.shields.io/badge/GitHub-Repository-black?style=flat&logo=github) ![Spring Security](https://img.shields.io/badge/Spring%20Security-black?style=flat&logo=springsecurity)

---

## 📖 Descrição

**CadastroDeEstoque** é um backend desenvolvido em Spring Boot para **gerenciar clientes, produtos, estoque e vendas** de uma loja.  

O sistema oferece:  
- Cadastro, listagem, atualização e remoção de clientes e produtos.  
- Controle de estoque com atualização de quantidades.  
- Registro de vendas associadas a produtos e clientes.  
- Autenticação e autorização JWT para proteger endpoints.  
- Migrações automáticas do banco com Flyway e integração com PostgreSQL.  

---

## ⚙️ Funcionalidades

- 🔐 Autenticação e autorização com JWT  
- 🧾 Cadastro de clientes, produtos , localização de estoques e vendas 
- 📦 Controle de estoque (adicionar/remover produtos)  
- 💳 Registro de vendas e associação de produtos  
- 🔍 Listagem e busca por ID  
- ✏️ Atualização e remoção de registros  

---

## 🔧 Como Executar o Projeto

### 1️⃣ Clonar o repositório
```bash
git clone https://github.com/joaogt01/CadastroDeEstoque.git
cd CadastroDeEstoque

```
### 2️⃣ Configurar o banco de dados
```bash
CREATE DATABASE cadastro_db;
```
Edite src/main/resources/application.properties:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/cadastro_db
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
POST /autenticacao/registrar

{
  "nome": "maria",
  "usuario": "teste",
  "senha": "123"
}

POST /autenticacao/login

{
  "usuario": "teste",
  "senha": "123"
}

Use o token JWT retornado nos endpoints protegidos:

Authorization: Bearer <TOKEN>
```
📋 Endpoints Principais
Clientes

Criar cliente
```bash
POST /clientes/criar

{
  "nome": "teste",
  "email": "teste@email.com",
  "telefone": "999999999"
}
```

Listar todos os clientes
```bash
GET /clientes/listar
```

Buscar cliente por ID
```bash
GET /clientes/listar/{id}
```

Atualizar cliente
```bash
PUT /clientes/alterar/{id}

{
  "nome": "teste_atualizado",
  "email": "teste2@email.com",
  "telefone": "999999991"
}
```

Deletar cliente
```bash
DELETE /clientes/deletar/{id}
```
Produtos

Criar produto
```bash
POST /produtos/criar

{
  "nome": "Balão Metalizado",
  "preco": 10.50,
  "quantidade": 50
}

```
Listar todos os produtos
```bash
GET /produtos/listar
```

Buscar produto por ID
```
GET /produtos/listar/{id}
```

Atualizar produto
```bash
PUT /produtos/alterar/{id}

{
  "nome": "Balão Metalizado Grande",
  "preco": 12.00,
  "quantidade": 40
}

```
Deletar produto
```bash
DELETE /produtos/deletar/{id}
```
Estoque

Adicionar produto ao estoque
```bash
POST /estoque/adicionar
```

Remover produto do estoque
```bash
PUT /estoque/remover
```

Listar produtos no estoque
```bash
GET /estoque/listar
```
Vendas

Registrar venda
```bash
POST /vendas/criar
```

Listar todas as vendas
```bash
GET /vendas/listar
```

Buscar venda por ID
```bash
GET /vendas/listar/{id}
```

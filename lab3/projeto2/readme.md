# 🐾 SBUR REST Demo - API de Petshops

## 📌 Descrição

Esta é uma aplicação REST desenvolvida com **Spring Boot** que realiza operações CRUD (Create, Read, Update, Delete) para gerenciamento de petshops.
Os dados são armazenados em um banco de dados **MySQL**, com inicialização automática via scripts SQL.

---

## 🚀 Tecnologias Utilizadas

* Java
* Spring Boot
* JDBC (Java Database Connectivity)
* MySQL
* Jackson (para serialização JSON)

---

## 📂 Estrutura do Projeto

* `SburRestDemoApplication` → Classe principal que inicializa a aplicação e o banco
* `RestApiDemoController` → Controlador REST com endpoints
* `Petshop` → Classe modelo (entidade)
* `Database` → Classe utilitária para conexão e inicialização do banco
* `/db/schema-bootstrap.sql` → Script para criação do banco
* `/db/schema-app.sql` → Script para criação das tabelas

---

## ▶️ Como Executar

1. Clone o projeto
2. Abra em sua IDE (IntelliJ, Eclipse, VS Code)
3. Execute a classe:

```java
SburRestDemoApplication
```

Ao iniciar:

* O banco será criado automaticamente (se não existir)
* As tabelas serão configuradas
* A API ficará disponível em:

```
http://localhost:8080/petshops
```

---

## 📡 Endpoints da API

### 🔍 Listar todos os petshops

```http
GET /petshops
```

---

### 🔍 Buscar petshop por ID

```http
GET /petshops/{id}
```

---

### ➕ Criar um novo petshop

```http
POST /petshops
```

#### Body (JSON):

```json
{
  "name": "Petshop Exemplo"
}
```

---

### ✏️ Atualizar um petshop

```http
PUT /petshops/{id}
```

#### Body (JSON):

```json
{
  "name": "Novo Nome"
}
```

* Se o ID existir → atualiza
* Se não existir → cria um novo registro

---

### ❌ Deletar um petshop

```http
DELETE /petshops/{id}
```

---

## 🔄 Funcionamento Interno

* A classe `Database` executa automaticamente scripts SQL ao iniciar
* A conexão com o banco é feita via `DriverManager`
* Queries são executadas com:

  * `Statement` (simples)
  * `PreparedStatement` (seguro contra SQL Injection)

---

## ⚠️ Observações

* O CORS está liberado para todas as origens (`@CrossOrigin("*")`)
* Não há camada de serviço ou repositório (arquitetura simplificada)
* O projeto usa JDBC puro (sem JPA/Hibernate)

---

## 💡 Possíveis Melhorias

* Implementar Spring Data JPA
* Adicionar validações (Bean Validation)
* Criar camada de serviço
* Implementar tratamento global de exceções
* Autenticação e autorização (Spring Security)
* Dockerizar a aplicação

---

## 👨‍💻 Autor

Desenvolvido para fins acadêmicos.

---

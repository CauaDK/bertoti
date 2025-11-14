# 🚀 trabalho-backend

[](https://quarkus.io/)
[](http://www.apache.org/licenses/LICENSE-2.0)
Um serviço de backend desenvolvido com **Quarkus**, o Framework Java Supersônico e Subatômico. Este projeto demonstra uma API REST conectada a um banco de dados PostgreSQL.

-----

## 🛠️ Tecnologias Utilizadas

  * **Java 17+**
  * **Quarkus:** Framework principal
  * **Maven:** Gerenciador de dependências e build
  * **RESTEasy (JAX-RS):** Para a criação dos endpoints da API
  * **JDBC Driver:** Para conexão com o **PostgreSQL**

-----

## ⚙️ Começando (Modo de Desenvolvimento)

Para rodar a aplicação em modo de desenvolvimento (com *live reload*):

```bash
./mvnw quarkus:dev
```

Após iniciar, a aplicação estará disponível em `http://localhost:8080`.

> **💡 Interface de Dev:** O Quarkus oferece uma interface de desenvolvimento muito útil. Acesse **[http://localhost:8080/q/dev/](https://www.google.com/search?q=http://localhost:8080/q/dev/)** para explorar seus endpoints, testar rotas e ver a configuração.

-----

## 📦 Gerando o Pacote da Aplicação (Build)

Você pode gerar o pacote da aplicação de duas formas principais.

### 1\. Pacote Padrão (Recomendado)

Este comando cria o `.jar` e coloca as dependências na pasta `lib/`.

```bash
./mvnw package
```

**Para executar:**

```bash
java -jar target/quarkus-app/quarkus-run.jar
```

### 2\. Pacote Único (Über-Jar)

Para gerar um **único arquivo `.jar`** que já inclui todas as dependências:

```bash
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

**Para executar:**

```bash
java -jar target/*-runner.jar
```

-----

## ⚡ Compilação Nativa (Opcional)

Uma das maiores vantagens do Quarkus é compilar para um executável nativo (usando GraalVM), o que resulta em um tempo de inicialização quase instantâneo.

**Se você tem o GraalVM instalado:**

```bash
./mvnw package -Dnative
```

**Se você NÃO tem o GraalVM (usará o Docker):**

```bash
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

**Para executar o arquivo nativo gerado:**

```bash
./target/trabalho-backend-1.0.0-SNAPSHOT-runner
```

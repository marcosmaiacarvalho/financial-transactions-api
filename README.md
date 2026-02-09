# Financial Transactions API

<div align="center">
  <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt="Spring" />
</div>

<br />

## 📋 Sobre o Projeto

Este projeto consiste em uma **API RESTful** para gerenciamento de transações financeiras (receitas e despesas), desenvolvida aplicando boas práticas de desenvolvimento backend.

O sistema foi construído com foco em **organização em camadas**, validações de integridade, tratamento de exceções e uso de agregações para geração de métricas financeiras.

## 🚀 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA**
* **H2 Database** (Banco em memória para desenvolvimento)
* **Bean Validation**
* **Lombok**
* **Maven**

## ✨ Funcionalidades

* **Gestão de Transações:** Cadastro, leitura, busca por ID e remoção.
* **Filtros de Busca:**
    * Por mês e ano.
    * Por descrição (parcial).
* **Dashboard Financeiro:**
    * Total de receitas e despesas.
    * Saldo consolidado.
    * Categoria com maior gasto.
* **Validação de Dados:**
    * Impede cadastro sem descrição, valor ou data.
    * Retorna erros detalhados (Status 422).
* **Tratamento de Exceções:** Handler global (`@RestControllerAdvice`) para capturar erros e devolver JSON padronizado.

## 📂 Modelo de Dados

A entidade principal `Transaction` possui os seguintes atributos:

| Atributo | Tipo | Descrição |
| :--- | :--- | :--- |
| `id` | Long | Identificador único (Auto Increment) |
| `description` | String | Descrição da transação |
| `amount` | BigDecimal | Valor monetário |
| `date` | LocalDate | Data da transação |
| `type` | Enum | Tipo (`REVENUE` ou `EXPENSE`) |
| `category` | Category | Categoria associada |

## 🔌 Endpoints

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `GET` | `/transactions` | Lista transações (com filtros opcionais). |
| `GET` | `/transactions/{id}` | Busca uma transação por ID. |
| `POST` | `/transactions` | Cadastra uma nova transação. |
| `DELETE` | `/transactions/{id}` | Remove uma transação. |
| `GET` | `/dashboard` | Gera totais e estatísticas consolidadas. |

### Exemplo de Requisição (JSON)

Corpo esperado para criar (`POST`) uma transação:

```json
{
  "description": "Compra no Supermercado",
  "amount": 450.50,
  "date": "2026-02-15",
  "type": "EXPENSE",
  "category": {
    "id": 1
  }
}
```

## 🛠️ Como Executar

Pré-requisitos: Java 17+

```bash
# 1. Clone o repositório
git clone [https://github.com/marcosmaiacarvalho/financial-transactions-api.git](https://github.com/marcosmaiacarvalho/financial-transactions-api.git)

# 2. Entre na pasta
cd financial-transactions-api

# 3. Execute o projeto
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080/transactions`.

---

## 🎯 Objetivo do Projeto

Este projeto tem como objetivo **praticar e consolidar conceitos de desenvolvimento backend**, como:

* **Design de APIs REST**
* **Boas práticas de organização de código** (Clean Code)
* **Validação de dados** e **Tratamento de exceções**
* **Uso de Streams** e agregações de dados
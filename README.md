# Financial Transactions API

Projeto de estudo em **Java com Spring Boot**, desenvolvido com foco em boas práticas de backend, organização em camadas, validações, tratamento de exceções e agregação de dados.

A API permite o gerenciamento de transações financeiras (receitas e despesas) e a geração de um dashboard consolidado a partir dessas informações.

---

## 🧩 Funcionalidades

- Cadastro de transações financeiras
- Listagem de transações com filtros opcionais:
  - Mês e ano
  - Descrição
- Busca de transação por ID
- Remoção de transações
- Geração de dashboard com:
  - Total de receitas
  - Total de despesas
  - Saldo
  - Categoria com maior gasto
- Validação de dados de entrada
- Tratamento global de exceções com respostas padronizadas

---

## 🛠️ Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation
- Lombok
- JPA / Hibernate
- Banco de dados relacional (H2 para ambiente de desenvolvimento)

---

## 🧱 Organização do projeto

O projeto segue uma estrutura em camadas:

- **Controller**: exposição dos endpoints REST
- **Service**: regras de negócio e processamento
- **Repository**: acesso a dados com Spring Data JPA
- **DTOs**: transporte e validação de dados
- **Exception Handler**: tratamento centralizado de erros e validações

---

## 🚨 Tratamento de erros

A API possui um handler global para exceções, retornando respostas padronizadas com:
- Timestamp
- Status HTTP
- Mensagem de erro
- Caminho da requisição

Erros de validação retornam também os campos inválidos e suas respectivas mensagens.

---

## 🎯 Objetivo do projeto

Este projeto tem como objetivo **praticar e consolidar conceitos de desenvolvimento backend**, como:

- Design de APIs REST
- Boas práticas de organização de código
- Validação de dados
- Tratamento de exceções
- Uso consciente de Streams e agregações
- Separação de responsabilidades

Não se trata de um sistema finalizado para produção, mas sim de um projeto focado em aprendizado e evolução técnica.

---

## ▶️ Como executar

1. Clone o repositório
2. Importe o projeto em sua IDE
3. Configure o banco de dados conforme necessário
4. Execute a aplicação via Spring Boot
5. A API ficará disponível em: http://localhost:8080

---

## 📌 Observações

O projeto foi desenvolvido com foco em clareza, legibilidade e boas práticas, priorizando código limpo e fácil de manter.

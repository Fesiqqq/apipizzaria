# 🍕 API Pizzaria Tuesday

Bem-vindo ao projeto **API Pizzaria Tuesday**! Esta é uma API REST completa desenvolvida para gerenciar os processos de uma pizzaria, desde o cardápio até o controle de fornecedores e funcionários.

O projeto foi construído com foco em escalabilidade, organização em camadas e documentação automática.

---

## 🚀 Tecnologias Utilizadas

O projeto utiliza o ecossistema **Java** com as melhores práticas do mercado:

* **Java 17+**: Linguagem base.
* **Spring Boot 3**: Framework para agilizar o desenvolvimento.
* **Spring Data JPA**: Para persistência de dados e mapeamento objeto-relacional (ORM).
* **H2 Database**: Banco de dados em memória para desenvolvimento e testes rápidos.
* **Lombok**: Para reduzir o código boilerplate (Getters, Setters, etc).
* **SpringDoc OpenAPI (Swagger)**: Para documentação e testes dos endpoints.
* **Render**: Plataforma utilizada para o Deploy e hospedagem da API.

---

## 🏛️ Arquitetura do Projeto

O projeto segue o padrão de **Arquitetura em Camadas**, garantindo a separação de responsabilidades:

1.  **Model**: Classes que representam as entidades do banco de dados (Pizza, Bebida, Cliente, Funcionario, Fornecedor).
2.  **Repository**: Interfaces que herdam do `JpaRepository`, responsáveis pelas operações de CRUD no banco de dados.
3.  **Service**: Camada de regras de negócio, que faz a ponte entre o Controller e o Repository.
4.  **Controller**: Camada de exposição da API, onde os Endpoints são definidos e documentados.

---

## 🛠️ Funcionalidades (Endpoints)

A API possui um CRUD completo para 5 entidades principais:

* **Pizzas**: Gerenciamento de sabores e preços.
* **Bebidas**: Controle de estoque e catálogo de refrescos.
* **Clientes**: Cadastro de clientes e informações de contato.
* **Funcionários**: Gestão da equipe e RH.
* **Fornecedores**: Controle de parceiros e insumos.

Todas as rotas seguem o padrão RESTful (GET, POST, PUT, DELETE) e estão documentadas com descrições claras no Swagger.

---

## 📖 Como Acessar

A API está rodando ao vivo e pode ser testada através do link abaixo:

🔗 `https://api-pizzaria-fernando.onrender.com/v1/clientes`

### Documentação Interativa (Swagger):
Para visualizar e testar todos os métodos da API de forma visual, acesse:
`https://api-pizzaria-fernando.onrender.com/swagger-ui/index.html#/`

---

Desenvolvido por **Fernando Siqueira** 🚀

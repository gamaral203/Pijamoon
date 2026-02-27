

Pijamoon é uma aplicação web de e-commerce desenvolvida com **Java e Spring Boot**, focada na venda de pijamas.  
O projeto foi criado com fins educacionais e para portfólio, simulando uma aplicação real com **persistência em MySQL**.

---

## 📌 Funcionalidades

- Listagem de produtos  
- Cadastro de produtos  
- Edição de produtos  
- Remoção de produtos  
- Persistência de dados em banco MySQL  
- Interface web simples para interação com o sistema  

---

## 🛠️ Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Spring Data JPA  
- Hibernate  
- MySQL  
- Maven  
- HTML  
- CSS  
- JavaScript  

---

## 🗄️ Banco de Dados

O projeto utiliza **MySQL** como banco de dados relacional.

O Hibernate é responsável pelo mapeamento objeto-relacional (ORM) e pela criação e atualização automática das tabelas.

### Exemplo de configuração (`application.properties`)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pijamoon
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
▶️ Como Executar o Projeto
Pré-requisitos

Java 17 ou superior

MySQL

Maven

Passo a passo

Clone o repositório:

git clone https://github.com/gamaral203/Pijamoon.git

Crie o banco de dados no MySQL:

CREATE DATABASE pijamoon;

Configure o arquivo application.properties com suas credenciais do MySQL.

Execute o projeto:

mvn spring-boot:run

Acesse no navegador:

http://localhost:8080
📂 Estrutura do Projeto

controller → Controladores da aplicação

service → Regras de negócio

repository → Acesso ao banco de dados

model → Entidades JPA

resources → Arquivos de configuração e templates

🚀 Próximas Melhorias

Autenticação e autorização de usuários (JWT)

Carrinho de compras

Painel administrativo

Validações no front-end

Interface responsiva

Deploy em ambiente cloud

🎯 Objetivo do Projeto

Este projeto tem como objetivo praticar o desenvolvimento back-end com Spring Boot, o uso de banco de dados relacional (MySQL) e a construção de uma aplicação próxima a um cenário real, servindo como projeto de estudo e portfólio.

📄 Licença

Este projeto está sob a licença MIT.
Sinta-se livre para estudar, modificar e contribuir.

👨‍💻 Autor

Desenvolvido por Gabriel Amaral e Riquelme Pereira
🔗 GitHub: https://github.com/gamaral203

🛍️ Pijamoon

Pijamoon é uma aplicação web de e-commerce desenvolvida com Java e Spring Boot, focada na venda de pijamas.
O projeto foi criado com fins educacionais e para portfólio, simulando uma aplicação real com persistência em MySQL.

✨ Funcionalidades

Listagem de produtos

Cadastro de produtos

Edição de produtos

Remoção de produtos

Persistência de dados em banco MySQL

Interface web simples para interação com o sistema

🛠️ Tecnologias Utilizadas

Java 17

Spring Boot

Spring Data JPA

Hibernate

MySQL

Maven

HTML

CSS

JavaScript

🗄️ Banco de Dados

O projeto utiliza MySQL como banco de dados relacional.

O Hibernate é responsável pelo mapeamento objeto-relacional (ORM) e pela criação e atualização automática das tabelas.

Exemplo de configuração (application.properties)

spring.datasource.url=jdbc:mysql://localhost:3306/pijamoon
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

▶️ Execução
Pré-requisitos

Java 17 ou superior

MySQL

Maven

Passos

git clone https://github.com/gamaral203/Pijamoon.git

cd Pijamoon
mvn spring-boot:run

A aplicação estará disponível em:
http://localhost:8080

📂 Estrutura do Projeto

controller

service

repository

model

resources

🚀 Melhorias Futuras

Autenticação de usuários

Carrinho de compras

Painel administrativo

Validações no front-end

Deploy em nuvem

📄 Licença

MIT

👨‍💻 Autor

Gabriel Amaral e Riquelme pereira
https://github.com/gamaral203

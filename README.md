# API Barbearia Manodi

## Descrição
A **API Barbearia Manodi** é uma aplicação backend desenvolvida em **Spring Boot** com **Maven**, projetada para gerenciar agendamentos de clientes em uma barbearia. A API fornece funcionalidades como cadastro de clientes, gestão de barbeiros, controle de agendamentos e gerenciamento de serviços oferecidos.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Maven**
- **PostgreSQL** (banco de dados hospedado no **Supabase**)
- **JWT (JSON Web Token)** para autenticação
- **Spring Security** para segurança da API
- **Lombok** para reduzir boilerplate
- **Hibernate** para ORM

## Instalação e Configuração

1. Clone o repositório:
   ```sh
   git clone https://github.com/matheuslima19/api-barbeariamanodi.git
   ```

2. Acesse a pasta do projeto:
   ```sh
   cd api-barbeariamanodi
   ```

3. Configure as variáveis de ambiente:
   - Crie um arquivo `.env` ou configure no `application.properties`:
     ```properties
     spring.datasource.url=jdbc:postgresql://<URL_DO_SUPABASE>:5432/<NOME_DO_BANCO>
     spring.datasource.username=<USUARIO>
     spring.datasource.password=<SENHA>
     spring.jpa.hibernate.ddl-auto=update
     jwt.secret=<CHAVE_SECRETA>
     ```

4. Compile e execute a API:
   ```sh
   mvn spring-boot:run
   ```

## Endpoints Principais

### Autenticação
- **POST** `/auth/login` - Realiza login e retorna um token JWT.
- **POST** `/auth/register` - Registra um novo usuário.

### Clientes
- **GET** `/clientes` - Lista todos os clientes.
- **POST** `/clientes` - Cadastra um novo cliente.

### Barbeiros
- **GET** `/barbeiros` - Lista todos os barbeiros.
- **POST** `/barbeiros` - Cadastra um novo barbeiro.

### Agendamentos
- **GET** `/agendamentos` - Lista todos os agendamentos.
- **POST** `/agendamentos` - Cria um novo agendamento.

## Autenticação
A API utiliza **JWT** para autenticação. Para acessar endpoints protegidos, é necessário incluir o token no cabeçalho da requisição:
```http
Authorization: Bearer <seu_token>
```

## Contribuição
Pull requests são bem-vindos! Para maiores informações, abra uma issue ou entre em contato.

## Licença
Este projeto é licenciado sob a [MIT License](LICENSE).# api-barbeariamanodi
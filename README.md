# Blog Backend API

## Descrição
Este projeto é um backend RESTful para um blog, desenvolvido com Spring Boot, JPA, MySQL e autenticação JWT. Ele permite o gerenciamento de artigos e usuários, com controle de acesso baseado em papéis (ADMINISTRADOR e ANONIMO).

## Funcionalidades
- Cadastro e login de usuários (com senha criptografada via BCrypt)
- Geração e validação de tokens JWT
- Controle de acesso por papel:
  - ADMINISTRADOR: pode criar, editar e deletar artigos
  - ANONIMO: pode apenas visualizar artigos
- CRUD de artigos
- Integração com banco de dados MySQL
- CORS liberado para todos os endpoints

## Estrutura de Pastas
```
src/
  main/
    java/
      com/gabriel/blog_backend/
        controller/   # Controllers REST
        Entity/       # Entidades JPA
        repository/   # Repositórios JPA
        security/     # Segurança (JWT, PasswordEncoder, Config)
        service/      # Serviços de negócio
    resources/
      application.properties # Configurações do Spring Boot/MySQL
```

## Endpoints Principais
### Autenticação
- `POST /auth/register` — Cadastro de usuário
  - Body: `{ "nome": "string", "username": "string", "password": "string", "role": "ADMINISTRADOR" | "ANONIMO" }`
- `POST /auth/login` — Login
  - Body: `{ "username": "string", "password": "string" }`
  - Response: `{ "token": "JWT" }`

### Artigos
- `GET /artigo/todos_artigos` — Listar todos os artigos (público)
- `POST /artigo/post_artigo` — Criar artigo (ADMINISTRADOR)
- `PUT /artigo/editar_artigo/{id}` — Editar artigo (ADMINISTRADOR)
- `DELETE /artigo/deletar_artigo/{id}` — Deletar artigo (ADMINISTRADOR)

## Autenticação JWT
- Envie o token JWT no header:
  - `Authorization: Bearer <token>`
- O token é gerado no login e deve ser usado para acessar endpoints protegidos.

## Banco de Dados
- MySQL
- Tabela `usuarios` para usuários
- Tabela `artigos` para artigos
- Configuração em `src/main/resources/application.properties`

## Como rodar
1. Configure o banco de dados MySQL e crie o schema `blog`.
2. Defina as variáveis de ambiente `DB_USER` e `DB_SENHA`.
3. Execute o projeto com `mvn spring-boot:run`.

## Dependências
- Spring Boot 3.5+
- Spring Security
- Spring Data JPA
- jjwt 0.11.5
- MySQL Connector

## Testes
- Testes básicos em `src/test/java/com/gabriel/blog_backend/BlogBackendApplicationTests.java`

## Observações
- O campo `role` do usuário define o acesso.
- Senhas são salvas com hash BCrypt.
- O backend está pronto para ser consumido por frontends web/mobile.

---

# AI.yaml

```yaml
name: BlogBackendAPI
language: Java
framework: Spring Boot
version: 3.5.4
entrypoint: com.gabriel.blog_backend.BlogBackendApplication
entities:
  - UsuarioEntity
  - ArtigoEntity
security:
  authentication: JWT
  password_hash: BCrypt
roles:
  - ADMINISTRADOR
  - ANONIMO
endpoints:
  - path: /auth/register
    method: POST
    public: true
    description: Cadastro de usuário
  - path: /auth/login
    method: POST
    public: true
    description: Login de usuário
  - path: /artigo/todos_artigos
    method: GET
    public: true
    description: Listar artigos
  - path: /artigo/post_artigo
    method: POST
    role: ADMINISTRADOR
    description: Criar artigo
  - path: /artigo/editar_artigo/{id}
    method: PUT
    role: ADMINISTRADOR
    description: Editar artigo
  - path: /artigo/deletar_artigo/{id}
    method: DELETE
    role: ADMINISTRADOR
    description: Deletar artigo
```

---

# AI.xml

```xml
<ai>
  <name>BlogBackendAPI</name>
  <language>Java</language>
  <framework>Spring Boot</framework>
  <version>3.5.4</version>
  <entrypoint>com.gabriel.blog_backend.BlogBackendApplication</entrypoint>
  <entities>
    <entity>UsuarioEntity</entity>
    <entity>ArtigoEntity</entity>
  </entities>
  <security>
    <authentication>JWT</authentication>
    <password_hash>BCrypt</password_hash>
  </security>
  <roles>
    <role>ADMINISTRADOR</role>
    <role>ANONIMO</role>
  </roles>
  <endpoints>
    <endpoint>
      <path>/auth/register</path>
      <method>POST</method>
      <public>true</public>
      <description>Cadastro de usuário</description>
    </endpoint>
    <endpoint>
      <path>/auth/login</path>
      <method>POST</method>
      <public>true</public>
      <description>Login de usuário</description>
    </endpoint>
    <endpoint>
      <path>/artigo/todos_artigos</path>
      <method>GET</method>
      <public>true</public>
      <description>Listar artigos</description>
    </endpoint>
    <endpoint>
      <path>/artigo/post_artigo</path>
      <method>POST</method>
      <role>ADMINISTRADOR</role>
      <description>Criar artigo</description>
    </endpoint>
    <endpoint>
      <path>/artigo/editar_artigo/{id}</path>
      <method>PUT</method>
      <role>ADMINISTRADOR</role>
      <description>Editar artigo</description>
    </endpoint>
    <endpoint>
      <path>/artigo/deletar_artigo/{id}</path>
      <method>DELETE</method>
      <role>ADMINISTRADOR</role>
      <description>Deletar artigo</description>
    </endpoint>
  </endpoints>
</ai>
```


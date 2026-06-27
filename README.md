# 💼 Gestão de Vagas - Sistema de Recrutamento

[![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-green?style=flat-square&logo=spring-boot)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Latest-blue?style=flat-square&logo=postgresql)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-Enabled-blue?style=flat-square&logo=docker)](https://www.docker.com/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-red?style=flat-square&logo=apache-maven)](https://maven.apache.org/)

## 📋 Sobre o Projeto

**Gestão de Vagas** é uma aplicação backend desenvolvida em **Java com Spring Boot** para gerenciar candidatos em processos seletivos. O sistema fornece uma API REST robusta para cadastro, validação e gerenciamento de candidatos.

## 🎯 Funcionalidades Implementadas

### ✅ Módulo Candidatos
- ✔️ Cadastro de candidatos com validação robusta
- ✔️ Validação de dados (Email, Username, Senha)
- ✔️ Armazenamento seguro em PostgreSQL
- ✔️ Tratamento de exceções com mensagens personalizadas
- ✔️ Timestamp automático de criação
- ✔️ Use Cases para lógica de negócio

### ✅ Módulo Empresas
- ✔️ Cadastro de empresas recrutadoras
- ✔️ Gerenciamento de perfil da empresa
- ✔️ Autenticação de empresas

### ✅ Módulo Vagas
- ✔️ Criar e gerenciar vagas de emprego
- ✔️ Associação entre vagas e empresas
- ✔️ Descrição detalhada de vagas
- ✔️ Histórico de criação

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão | Uso |
|-----------|--------|-----|
| **Java** | 17 | Linguagem principal |
| **Spring Boot** | 4.0.6 | Framework web |
| **Spring Security** | Latest | Autenticação e autorização |
| **JWT** | Latest | Tokens de autenticação | 
| **Spring Data JPA** | Latest | Persistência de dados |
| **Spring Validation** | Latest | Validação de dados |
| **PostgreSQL** | Latest | Banco de dados |
| **Lombok** | 1.18.46 | Redução de boilerplate |
| **Docker** | Latest | Containerização |
| **Maven** | 3.8+ | Gerenciador de dependências |

## 📁 Estrutura do Projeto

```
gestao_vagas/
│
├── src/
│   ├── main/
│   │   ├── java/br/com/natansilva/gestao_vagas/
│   │   │   ├── GestaoVagasApplication.java          # Classe principal da aplicação
│   │   │   │
│   │   │   ├── exceptions/
│   │   │   │   ├── ExceptionHandlerController.java  # Handler global de exceções
│   │   │   │   ├── ErrorMessageDTO.java             # DTO de erro
│   │   │   │   └── UserFoundException.java          # Exceção customizada
│   │   │   │
│   │   │   └── modules/
│   │   │       │
│   │   │       ├── candidate/
│   │   │       │   ├── entities/
│   │   │       │   │   └── CandidateEntity.java     # Entidade do candidato
│   │   │       │   ├── repositories/
│   │   │       │   │   └── CandidateRepository.java # Repositório JPA
│   │   │       │   ├── controllers/
│   │   │       │   │   └── CandidateController.java # Controller REST
│   │   │       │   └── useCases/
│   │   │       │       └── CreateCandidateUseCase.java # Lógica de negócio
│   │   │       │
│   │   │       └── company/
│   │   │           ├── entities/
│   │   │           │   ├── CompanyEntity.java       # Entidade da empresa
│   │   │           │   └── JobEntity.java           # Entidade de vagas
│   │   │           ├── repositories/
│   │   │           │   ├── CompanyRepository.java   # Repositório de empresas
│   │   │           │   └── JobRepository.java       # Repositório de vagas
│   │   │           ├── controllers/
│   │   │           │   ├── CompanyController.java   # Controller de empresas
│   │   │           │   └── JobController.java       # Controller de vagas
│   │   │           └── useCases/
│   │   │               ├── CreateCompanyUseCase.java # Criar empresa
│   │   │               └── CreateJobUseCase.java    # Criar vaga
│   │   │
│   │   └── resources/
│   │       └── application.properties               # Configurações da aplicação
│   │
│   └── test/
│       └── java/br/com/natansilva/gestao_vagas/
│           └── GestaoVagasApplicationTests.java    # Testes unitários
│
├── docker-compose.yml                              # Configuração Docker
├── pom.xml                                        # Dependências Maven
└── README.md                                      # Este arquivo
```

## 🚀 Como Executar

### Pré-requisitos

- ☕ Java 17 ou superior
- 🐘 PostgreSQL (ou use Docker)
- 📦 Maven 3.8+

### 1️⃣ Clone o Repositório

```bash
git clone https://github.com/INatanSilva/Gestao-de-Vagas---Java-Spring-Boot.git
cd gestao_vagas
```

### 2️⃣ Inicie o PostgreSQL com Docker

```bash
docker-compose up -d
```

Isso iniciará um container PostgreSQL com as seguintes configurações:
- **User**: `admin`
- **Password**: `admin`
- **Database**: `gestao_vagas`
- **Port**: `5433`

### 3️⃣ Execute a Aplicação

**Com Maven:**
```bash
./mvnw spring-boot:run
```

**Ou compile e execute:**
```bash
./mvnw clean install
java -jar target/gestao_vagas-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível em: `http://localhost:8080`

## 📡 API Endpoints

### 👥 Módulo Candidatos

#### 📝 Cadastrar Candidato

**Endpoint:**
```
POST /candidate/
```

**Request Body:**
```json
{
  "name": "João Silva",
  "username": "joao.silva",
  "email": "joao@example.com",
  "password": "senha123",
  "description": "Desenvolvedor Full Stack",
  "curriculum": "https://example.com/cv.pdf"
}
```

**Response (201 Created):**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "name": "João Silva",
  "username": "joao.silva",
  "email": "joao@example.com",
  "password": "senha123",
  "description": "Desenvolvedor Full Stack",
  "curriculum": "https://example.com/cv.pdf",
  "createdAt": "2024-06-07T21:19:14.123456"
}
```

### 🏢 Módulo Empresas

#### 📝 Cadastrar Empresa

**Endpoint:**
```
POST /company/
```

**Request Body:**
```json
{
  "name": "Tech Solutions Brasil",
  "description": "Empresa de desenvolvimento de software",
  "email": "contato@techsolutions.com.br",
  "password": "senha_segura_123",
  "website": "https://techsolutions.com.br"
}
```

**Response (201 Created):**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440001",
  "name": "Tech Solutions Brasil",
  "description": "Empresa de desenvolvimento de software",
  "email": "contato@techsolutions.com.br",
  "website": "https://techsolutions.com.br",
  "createdAt": "2024-06-07T21:19:14.123456"
}
```

### 💼 Módulo Vagas

#### 📝 Criar Vaga

**Endpoint:**
```
POST /job/
```

**Request Body:**
```json
{
  "title": "Desenvolvedor Senior Java",
  "description": "Buscamos desenvolvedor Java com 5+ anos de experiência",
  "companyId": "550e8400-e29b-41d4-a716-446655440001"
}
```

**Response (201 Created):**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440002",
  "title": "Desenvolvedor Senior Java",
  "description": "Buscamos desenvolvedor Java com 5+ anos de experiência",
  "companyId": "550e8400-e29b-41d4-a716-446655440001",
  "createdAt": "2024-06-07T21:19:14.123456"
}
```

### ✅ Regras de Validação

| Campo | Regra | Mensagem |
|-------|-------|----------|
| **name** | Obrigatório | - |
| **username** | 3+ caracteres, apenas letras, números, `.`, `_`, `-` | "Username deve conter pelo menos 3 caracteres..." |
| **email** | Formato de email válido | "Email deve ser válido" |
| **password** | 6-100 caracteres | "A senha deve conter entre 6 e 100 caracteres" |
| **description** | Opcional | - |
| **curriculum** | Opcional | - |

### ⚠️ Tratamento de Erros

A aplicação retorna erros estruturados com status HTTP apropriado:

**Erro de Validação (400):**
```json
{
  "field": "email",
  "message": "Email deve ser válido"
}
```

## 🏗️ Arquitetura

### Padrão Clean Architecture com Use Cases

A aplicação segue o padrão de **Clean Architecture** com **Use Cases** para melhor separação de responsabilidades:

```
┌─────────────────────────────────────────────────────────┐
│                    HTTP Request                         │
└──────────────────────┬──────────────────────────────────┘
                       ↓
        ┌──────────────────────────────┐
        │   Controller (REST API)      │
        │ - Valida entrada             │
        │ - Chama Use Case             │
        └──────────┬───────────────────┘
                   ↓
        ┌──────────────────────────────┐
        │   Use Case (Business Logic)  │
        │ - Regras de negócio          │
        │ - Orquestração               │
        │ - Validações                 │
        └──────────┬───────────────────┘
                   ↓
        ┌──────────────────────────────┐
        │   Repository (Data Access)   │
        │ - Queries                    │
        │ - Persistência               │
        └──────────┬───────────────────┘
                   ↓
        ┌──────────────────────────────┐
        │  Database (PostgreSQL)       │
        └──────────────────────────────┘
```

### Componentes da Arquitetura

1. **Controllers** - Recebem requisições HTTP e delegam para Use Cases
2. **Use Cases** - Contêm a lógica de negócio da aplicação
3. **Entities** - Representam tabelas no banco de dados
4. **Repositories** - Acessam dados usando Spring Data JPA
5. **Exception Handler** - Trata erros globalmente de forma consistente
6. **DTOs** - Transferem dados entre camadas

## 🔐 Fluxo de Autenticação

```text
Cliente
  |
  v
POST /auth/companies
  |
  v
AuthCompanyController
  |
  v
AuthCompanyUseCase
  |  - valida credenciais
  |  - gera JWT com expiração de 2 horas
  v
Resposta: Bearer token JWT
  |
  v
Requisições protegidas
  |
  v
SecurityFilter
  |  - valida header Authorization
  |  - permite ou bloqueia o acesso
  v
BasicAuthenticationFilter
  v
Endpoint protegido
```

### Módulos por Funcionalidade

O projeto está organizado em **módulos independentes**:

- **`modules/candidate/`** - Tudo relacionado a candidatos
- **`modules/company/`** - Tudo relacionado a empresas e vagas

Cada módulo contém suas próprias:
- Entities (modelos de dados)
- Repositories (acesso a dados)
- Controllers (endpoints REST)
- Use Cases (lógica de negócio)

## 📦 Dependências Principais

```xml
<!-- Spring Boot Web -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-webmvc</artifactId>
</dependency>

<!-- JPA e Hibernate -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- Validação -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<!-- PostgreSQL -->
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <version>42.7.3</version>
</dependency>

<!-- Lombok -->
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <version>1.18.46</version>
</dependency>
```

## 🔄 Histórico de Commits

```
367a847 - Repository para conectar dados com o banco (JpaRepository)
39ce0ab - Entidade Candidate com @Entity e anotações do Spring
66122f7 - Banco de dados integrado com Docker Compose
b868165 - Mensagens de validação formatadas
3dcc356 - Validações nos campos (Pattern, Email, Length)
3f70cff - POST endpoint e Entity Candidate com @Data
9988096 - Initial commit
```

## 🔐 Configuração do Banco de Dados

**Arquivo: `application.properties`**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/gestao_vagas
spring.datasource.username=admin
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 🧪 Testando a API

### Com cURL:

```bash
curl -X POST http://localhost:8080/candidate/ \
  -H "Content-Type: application/json" \
  -d '{
    "name": "João Silva",
    "username": "joao.silva",
    "email": "joao@example.com",
    "password": "senha123",
    "description": "Desenvolvedor",
    "curriculum": "CV"
  }'
```

### Com Postman:
1. Importe a coleção ou crie uma nova requisição
2. Método: `POST`
3. URL: `http://localhost:8080/candidate/`
4. Body: JSON conforme exemplo acima

## 📝 Próximas Funcionalidades

- 🔒 Autenticação e autorização avançada (JWT)
- 📨 Notificações por email
- 🔍 Busca e filtros de candidatos
- 🔍 Busca e filtros de vagas
- 📊 Dashboard de estatísticas
- 🔄 CRUD completo para candidatos
- 🔄 CRUD completo para vagas
- 📋 Sistema de candidaturas
- ⭐ Sistema de avaliação de candidatos
- 📱 App mobile

## 🤝 Contribuindo

Contribuições são bem-vindas! Por favor:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

## 👨‍💻 Autor

**Natan Silva**
- 🐙 GitHub: [@INatanSilva](https://github.com/INatansilva)
- 💼 LinkedIn: [@NatanSilva](https://www.linkedin.com/in/natan-silva-925705291/)

## 📞 Suporte

Se tiver dúvidas ou sugestões, abra uma [issue](https://github.com/INatanSilva/Gestao-de-Vagas---Java-Spring-Boot/issues).

---

<div align="center">
  
  ⭐ Se este projeto foi útil, considere dar uma estrela! ⭐
  
</div>

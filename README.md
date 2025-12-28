# 🚀 Workshop MongoDB + Spring Boot

Um projeto educacional que demonstra a construção de uma **API RESTful** robusta e bem arquitetada, integrando **Spring Boot** com **MongoDB** para persistência de dados em um banco não-relacional.

---

## 📚 Sobre o Projeto

Este projeto foi desenvolvido como parte do aprendizado em um curso de excelência ministrado pelo **Professor Nélio Alves** na Udemy, focando em boas práticas de desenvolvimento, arquitetura limpa e padrões de design aplicados a aplicações Spring Boot modernas.

### Objetivos de Aprendizado

- ✅ Configuração e integração de **Spring Boot** com **MongoDB**
- ✅ Implementação de padrões de camadas: **Controller → Service → Repository**
- ✅ Tratamento robusto de exceções com **ControllerAdvice**
- ✅ Transferência de dados segura com **DTOs** (Data Transfer Objects)
- ✅ Injeção de dependência e inversão de controle com Spring
- ✅ Construção de APIs RESTful seguindo princípios de design

---

## 🏗️ Arquitetura do Projeto

O projeto segue uma **arquitetura em camadas** bem definida, garantindo separação clara de responsabilidades:

```
com.cssbreno.workshopmongo
├── domain/              # Entidades do domínio (User)
├── dto/                 # Data Transfer Objects (UserDTO)
├── repository/          # Interfaces de acesso a dados (Spring Data MongoDB)
├── services/            # Lógica de negócio
│   └── exception/       # Exceções customizadas
├── resources/           # Controladores REST (Endpoints)
│   └── exception/       # Tratamento global de exceções
└── config/              # Configurações da aplicação (Inicialização de dados)
```

---

## 🔌 Endpoints da API

### Listar Todos os Usuários

```http
GET /users
```

**Resposta (200 OK):**
```json
[
  {
    "id": "507f1f77bcf86cd799439011",
    "name": "Joel Miller",
    "email": "joel@theguardians.com"
  },
  {
    "id": "507f1f77bcf86cd799439012",
    "name": "Ellie Williams",
    "email": "ellie@theinfected.com"
  }
]
```

### Buscar Usuário por ID

```http
GET /users/{id}
```

**Resposta (200 OK):**
```json
{
  "id": "507f1f77bcf86cd799439011",
  "name": "Joel Miller",
  "email": "joel@theguardians.com"
}
```

**Resposta (404 Not Found):**
```json
{
  "timestamp": 1699564800000,
  "status": 404,
  "error": "Not Found",
  "message": "Usuário não encontrado",
  "path": "/users/invalid-id"
}
```

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão | Propósito |
|-----------|--------|----------|
| **Java** | 25 | Linguagem de programação |
| **Spring Boot** | 4.0.1 | Framework web e IoC |
| **Spring Data MongoDB** | Latest | ORM para MongoDB |
| **MongoDB** | Local | Banco de dados NoSQL |
| **Lombok** | Latest | Redução de boilerplate code |
| **Maven** | 3.9.12 | Gerenciamento de dependências |

---

## 📦 Estrutura de Dependências

### Principais Dependências

```xml
<!-- Spring Boot Starters -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-webmvc</artifactId>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>

<!-- Lombok para redução de código boilerplate -->
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <scope>provided</scope>
</dependency>
```

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

- **Java 25** ou superior instalado
- **MongoDB** rodando localmente ou em container Docker
- **Maven 3.9.12** (incluído via Maven Wrapper)

### 1. Clonar o Repositório

```bash
git clone https://github.com/cssbreno/curso-spring-mongdb.git
cd curso-spring-mongdb
```

### 2. Configurar MongoDB

Certifique-se de que o MongoDB está rodando na porta padrão `27017`:

```bash
# Com Docker (recomendado)
docker run -d -p 27017:27017 --name mongodb mongo:latest

# Ou instale localmente e inicie o serviço
mongod
```

### 3. Executar a Aplicação

```bash
# Linux/Mac
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

A aplicação iniciará em `http://localhost:8080`

### 4. Testar os Endpoints

Use o arquivo de requisições Bruno incluído no projeto ou qualquer ferramenta como Postman/Insomnia:

```bash
# Listar usuários
curl http://localhost:8080/users

# Buscar usuário específico
curl http://localhost:8080/users/{id}
```

---

## 🔍 Detalhes de Implementação

### 1. **Entidade User** ([`domain/User.java`](src/main/java/com/cssbreno/workshopmongo/domain/User.java))

Document MongoDB mapeado com anotações Spring Data e Lombok, incluindo implementação segura de `equals()` e `hashCode()` baseada no identificador único.

### 2. **Data Transfer Object** ([`dto/UserDTO.java`](src/main/java/com/cssbreno/workshopmongo/dto/UserDTO.java))

Transfere apenas dados necessários para o cliente, desacoplando a representação da entidade. Implementa construtor que facilita conversão de `User` para `UserDTO`.

### 3. **Camada de Serviço** ([`services/UserService.java`](src/main/java/com/cssbreno/workshopmongo/services/UserService.java))

Centraliza a lógica de negócio, fazendo validação de requisitos e delegando acesso a dados ao repository. Lança exceções customizadas para cenários de erro.

### 4. **Tratamento Global de Exceções** ([`resources/exception/ResourceExceptionHandler.java`](src/main/java/com/cssbreno/workshopmongo/resources/exception/ResourceExceptionHandler.java))

Intercepta exceções em nível global com `@ControllerAdvice`, convertendo-as em respostas HTTP padronizadas com o objeto `StandardError`, garantindo consistência nas respostas de erro.

### 5. **Controlador REST** ([`resources/UserResource.java`](src/main/java/com/cssbreno/workshopmongo/resources/UserResource.java))

Expõe endpoints HTTP, convertendo respostas de negócio para DTOs e delegando lógica ao serviço. Retorna `ResponseEntity` para controle fino sobre status HTTP.

### 6. **Inicialização de Dados** ([`config/Instantiation.java`](src/main/java/com/cssbreno/workshopmongo/config/Instantiation.java))

Implementa `CommandLineRunner` para popular o banco com dados de exemplo ao iniciar a aplicação, facilitando testes imediatos.

---

## 🎯 Princípios SOLID Aplicados

| Princípio | Aplicação |
|-----------|-----------|
| **S**ingle Responsibility | Cada classe tem uma única razão para mudar (Service, Repository, Controller) |
| **O**pen/Closed | Aberto para extensão (novos serviços) sem modificar código existente |
| **L**iskov Substitution | `UserRepository` é substituível por qualquer implementação `MongoRepository` |
| **I**nterface Segregation | Interfaces específicas e coesas (`UserRepository` expõe apenas operações necessárias) |
| **D**ependency Inversion | Depende de abstrações (`UserRepository` interface) não de implementações concretas |

---

## 📊 Padrões de Design Utilizados

### 🏭 **Repository Pattern**
Abstrai acesso a dados, permitindo trocar implementação sem afetar camadas superiores.

### 🔀 **Data Transfer Object (DTO)**
Desacopla representação de dados enviada ao cliente da entidade de domínio.

### ⚙️ **Dependency Injection**
Spring gerencia ciclo de vida e injeção de dependências automaticamente via `@Autowired`.

### 🛡️ **Exception Translation**
Converte exceções técnicas em respostas HTTP semanticamente corretas com `@ExceptionHandler`.

---

## 🔐 Boas Práticas Implementadas

✅ **Nomes Descritivos**: Variáveis e métodos com nomes claros e pronunciáveis
✅ **Single Responsibility**: Cada classe com uma única responsabilidade
✅ **Fail Fast**: Validação imediata de dados de entrada
✅ **DTOs**: Separação entre domínio e apresentação
✅ **Tratamento Robusto de Erros**: Exceções customizadas e resposta padronizada
✅ **Composição sobre Herança**: Uso de injeção de dependência ao invés de hierarquias
✅ **Sem Magic Numbers**: Valores hardcoded evitados através de constantes
✅ **Código Limpo**: Funções pequenas, focadas, bem documentadas

---

## 📝 Configuração (application.properties)

```properties
spring.application.name=workshopmongo
spring.output.ansi.enabled=ALWAYS
spring.mongodb.uri=mongodb://localhost:27017/workshop_mongo
```

**Variáveis de Ambiente Recomendadas para Produção:**

```bash
export SPRING_MONGODB_URI=mongodb+srv://user:password@cluster.mongodb.net/workshop_mongo
```

---

## 🧪 Testes

O projeto inclui estrutura base para testes unitários e de integração:

```bash
# Executar testes
./mvnw test
```

---

## 📖 Referência do Curso

Este projeto foi desenvolvido seguindo o magistral curso do **Professor Nélio Alves** disponível na Udemy:

> **"Java + Banco de Dados MongoDB"**

O curso é referência na comunidade por sua abordagem didática, foco em padrões de design e boas práticas consolidadas na indústria.

---

## 🚀 Próximas Melhorias Sugeridas

- [ ] Implementar validação de entrada com `@Valid` e `@Validated`
- [ ] Adicionar testes unitários com JUnit 5 e Mockito
- [ ] Implementar autenticação e autorização com Spring Security
- [ ] Adicionar operações CREATE, UPDATE, DELETE (POST, PUT, DELETE)
- [ ] Implementar paginação e filtros avançados
- [ ] Adicionar logs estruturados com SLF4J/Logback
- [ ] Documentar API com Swagger/SpringDoc OpenAPI
- [ ] Implementar cache com Redis
- [ ] Deploy em container Docker
- [ ] CI/CD com GitHub Actions

---

## 📄 Licença

Este projeto é fornecido para fins educacionais. Consulte a seção de licença do curso para mais informações.

---


## 🙏 Agradecimentos

Agradecimentos especiais ao **Professor Nélio Alves** pelo excelente conteúdo educacional que inspirou este projeto e ao ecossistema Spring pela qualidade e documentação excepcional.

---

**Desenvolvido com ❤️ e ☕ durante estudos de Spring Boot + MongoDB**

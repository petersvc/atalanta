Api Atalanta

Este é um projeto desenvolvido para as disciplinas de Gestão de Projetos de Software, Comércio Eletrônico e Programação de Dispositivos Móveis.
Essa api tem o objetivo de fornecer e processar dados/requisições para o aplicativo para android Iquadras.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Docker
- Maven
- Swagger (para documentação da API)

## Estrutura do Projeto

A estrutura do projeto segue os padrões do Spring Boot:

- **entity**: Contém as entidades JPA para os veículos de carga e de passeio.
- **dto**: Define os DTOs (Data Transfer Objects) utilizados nas operações da API.
- **repository**: Repositórios JPA para acesso aos dados.
- **service**: Lógica de negócio e manipulação dos dados.
- **controller**: Controladores REST para exposição da API.
- **exceptions**: Exceções personalizadas.
- **infra**: Configuração da aplicação.
- **test**: Testes automatizados.

## Utilizando a API via browser
**É possível utilizar a api, via swagger-ui, acessível em: **[API](https://desafio-rpe.onrender.com/swagger-ui/index.html)**.**
Verifique a seção `Como usar a API` para mais informações.

## Configuração do Ambiente de Execução

### Docker
Para executar a aplicação em um ambiente Docker, siga os passos abaixo:

1. Certifique-se de ter as seguintes dependências instaladas em sua máquina:
    - Docker
    - docker-compose.
2. Clone o repositório para sua máquina local.
3. Navegue até o diretório raiz do projeto.
4. Execute o comando `docker-compose up` ou `docker compose up`  para iniciar os containers do PostgreSQL e da aplicação.
5. Acesse a documentação da API em `http://localhost:54321/swagger-ui/index.html`.

### Sem Docker (Nativo)
Para executar a aplicação sem Docker, siga os passos abaixo:

1. Certifique-se de ter as seguintes dependências instaladas em sua máquina:
    - Java 21.
    - Maven 3.8+.
    - PostgreSQL 12+:
      - Crie um banco de dados chamado `atalanta`.
2. Clone o repositório para sua máquina local.
3. Navegue até o diretório raiz do projeto.
4. Para executar a aplicação, você pode escolher entre as seguintes opções:
    - Em modo de desenvolvimento:
        - Execute em um terminal o seguinte comando:
          - `DATABASE_URL=jdbc:postgresql://localhost:5432/rpe DATABASE_USERNAME=postgres DATABASE_PASSWORD=postgres mvn spring-boot:run`
    - Executando uma build já compilada:
        - Para compilar o projeto execute:`DATABASE_URL=jdbc:postgresql://localhost:5432/rpe DATABASE_USERNAME=postgres DATABASE_PASSWORD=postgres mvn clean package -DskipTests`.
        - Para iniciar a aplicação execute:`DATABASE_URL=jdbc:postgresql://localhost:5432/rpe DATABASE_USERNAME=postgres DATABASE_PASSWORD=postgres java -jar ./target/*.jar`.
5. Acesse a documentação da API em `http://localhost:8080/swagger-ui/index.html`.

Alternativamente, caso não deseje utilizar variáveis de ambiente,
você pode modificar diretamente no arquivo `application.yml`, os valores das seguintes propriedades:
- `datasource`:
  - `url`: URL de conexão com o banco de dados.
  - `username`: Usuário do banco de dados.
  - `password`: Senha do banco de dados.

E então executar a aplicação sem definir as variáveis de ambiente no momento da execução,
bastanto apenas executar o comando `mvn spring-boot:run` ou após
executar o comando `mvn clean package -DskipTests`, executar `java -jar ./target/*.jar`.

## Como usar a API
É possível utilizar a API através do swagger ou de um cliente REST como o Postman ou Insomnia.

Os endpoints disponíveis estão listados na documentação da API, acessível em `http://localhost:54321/swagger-ui/index.html`, `http://localhost:8080/swagger-ui/index.html` ou ainda
`https://desafio-rpe.onrender.com/swagger-ui/index.html`.

É possível observar os detalhes de cada endpoint, como os parâmetros necessários através do swagger-ui.

É preciso levar em consideração que o spring security está habilitado, então é necessário autenticar-se para acessar os endpoints.

Apenas o endereço do swagger-ui está disponível sem autenticação.
Para autenticar-se e obter o token JWT, é necessário enviar uma requisição POST para o endpoint `/auth/registrar` com o seguinte corpo, por exemplo:
```json
{
  "login": "peter",
  "senha": "12345",
  "perfil": "ADMIN"
}
```
Isso irá criar um usuário com login `peter`, senha `12345` e perfil `ADMIN`.

Após isso é possível autenticar-se enviando uma requisição POST para o endpoint `/auth/login` com o seguinte corpo:
```json
{
  "login": "peter",
  "senha": "12345"
}
```

Existem dois perfis disponíveis: `ADMIN` e `USUARIO`.

`ADMIN` tem permissão para acessar todos os endpoints.

Enquanto `USUARIO` tem permissão apenas para acessar os endpoints de listagem e busca.

O token JWT retornado deve ser utilizado no cabeçalho `Authorization` das requisições para os demais endpoints, no formato `Bearer`.
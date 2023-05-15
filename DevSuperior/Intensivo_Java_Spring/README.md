# Intensivão Java Spring

Nesse intensivão de uma semana do [devSuperior](https://github.com/devsuperior/) foi aprendido a estruturar uma api rest utilizando o framework spring no java, estruturando o projeto conforme o padrão de camadas, de maneira que seja fácil sua escalabilidade e sendo possível ver como é estruturado um projeto grande.

Nesse projeto foi possível entender como criar uma API utilizando o spring boot 3, como configurar e utilizar IDE para a programação com o java, foi apresentado um início de utilização de docker e deploy no Railway.

## Estrutura de classes

[<img width="700px" src="./assets/Diagrama_de_classe.png" />](./assets/Diagrama_de_classe.png 'Diagrama de classes')

## Estrutura de construção

[<img width="700px" src="./assets/Padr%C3%A3o_de_camadas.png" />](./assets/Padr%C3%A3o_de_camadas.png 'Estrutura')

## Tecnologias utilizadas

- Java 17
- Spring Boot
- JPA / Hibernate
- Maven
- H2 / PostgreSQL

## Aprendizados relevantes

Dentre várias coisas que foram aprendidas durante essa semana, abaixo se encontra observações nas quais foram novidades para mim.

### Observações sobre o Spring

O uso do decorator **@Entity** faz com que a classe que está abaixo seja ligada a uma tabela no banco de dados.

O decorator **@Table(name = "tb_game")** dá um nome pra tabela a qual a entitade vai se relacionar.

Foi necessário a criação da classe **BelongingPK** por estar no modelo de classes, não sendo possível a inclusão de mais de uma _primary key_ por objeto, fazendo da classe **BelongingPK** como uma classe auxiliar, sendo assim, para gerar o hashcode da **belongingPK**, foi necessário a inclusão dos 2 objetos.

O uso do system.properties é dado para quando for utilizar deploy em sites como a Heroku.

_**Interfaces**_ ficam na pasta **projections**, e são necessárias para definir o elemento retornado pelo query nativo do **SQL**.

### Observações relacionadas ao Java

Quando os parâmetros recebidos pelo constructor não tem o mesmo nome que ele vai receber na classe, não precisa de usar o this, por não haver ambiguidade.

### Uso do POST ou PUT

O uso dos 2 métodos, se definem em diferenciar se haverá uma **OPERAÇÃO IDEMPOTENTE**, sendo que se utiliza **PUT** quando a operação for salva uma ou várias vezes e retornar o mesmo resultado, como a de salvar um endereço.
se cada vez que chamar uma operação, ela retornar um resultado diferente, deve-se utilizar o método **POST**, por isso que foi utilizado ele na operação de atualizar a lista.

## Como executar

Pré-requisitos: Java 17

Pasta do projeto: [apigamelist](https://github.com/BrunoMedeiros14/CoursesAndChallenges/tree/main/DevSuperior/Intensiv%C3%A3o_Java_Spring/apigamelist/)
Seed para o SQL: [seed Sql](./seed_pg_sql.sql)

```bash
# após clonar este repositório, executar o projeto com o comando:
./mvnw spring-boot:run
```

No arquivo [postman endpoints](./Postman_endpoints.json) contem o json para abrir no postman com todos os endpoints gerado por este projeto.

### Variáveis de ambiente para deploy

```bash
APP_PROFILE
DB_URL (Formato -> jdbc:postgresql://host:porta/nomedabase)
DB_USERNAME
DB_PASSWORD
CORS_ORIGINS
```

### Query utilizado para a atualização da lista

```bash
SELECT TB_BELONGING .\*, TB_GAME.TITLE FROM TB_BELONGING
INNER JOIN TB_GAME ON TB_GAME.ID = TB_BELONGING.GAME_ID
WHERE LIST_ID=2
ORDER BY POSITION
```

## Desenvolvido por

[<img width="100px" src="https://avatars.githubusercontent.com/u/100999610" />](https://github.com/BrunoMedeiros14 'Perfil no GitHub (BrunoMedeiros)')

**[Retornar para página anterior](../README.md)**

<p align="center">By <strong><a href="https://github.com/BrunoMedeiros14">Bruno Medeiros</a></strong>.</p>

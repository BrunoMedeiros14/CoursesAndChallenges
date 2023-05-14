# Intensivão Java Spring

Nesse intensivão de uma semana foi aprendido a estruturar uma api rest utilizando o framework spring no java, estruturando o projeto conforme o padrão de camadas, de maneira que seja fácil sua escalabilidade e sendo possível ver como é estruturado um projeto grande.

## Estrutura de classes

![Diagrama de classes](./assets/Diagrama_de_classe.png)

## Estrutura de construção

![Estrutura](./assets/Padr%C3%A3o_de_camadas.png)

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

<!--

```
APP_PROFILE
DB_URL (Formato -> jdbc:postgresql://host:porta/nomedabase)
DB_USERNAME
DB_PASSWORD
CORS_ORIGINS
```

query bolado:

SELECT TB_BELONGING .\*, TB_GAME.TITLE FROM TB_BELONGING
INNER JOIN TB_GAME ON TB_GAME.ID = TB_BELONGING.GAME_ID
WHERE LIST_ID=2
ORDER BY POSITION
-->

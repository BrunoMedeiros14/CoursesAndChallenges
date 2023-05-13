@Entity // configura classe para que seja relativa a uma tabela de banco sql
@Table(name = "tb_game") //define nome da tabela relativa à classe

No GameMinDTO não precisa de usar o this no parâmetro por não haver ambiguidade.

Rever aula a partir de 1:30:00 https://www.youtube.com/watch?v=QDNaLBoMGeY

Foi necessário a criação da classe BelongingPK por estar no modelo de classes, não sendo possível a inclusão de mais de uma primary key por objeto, fazendo da classe BelongingPK como uma classe auxiliar, sendo assim, para gerar o hashcode da belongingPK, foi necessário a inclusão dos 2 objetos.
Interfaces ficam na pasta projections, e são necessárias para definir o elemento retornado pelo query nativo do sql.

O uso do system.properties é dado para quando for utilizar deploy em sites como a Heroku.

```
APP_PROFILE
DB_URL (Formato -> jdbc:postgresql://host:porta/nomedabase)
DB_USERNAME
DB_PASSWORD
CORS_ORIGINS
```

operação (idempotente)
usa-se o PUT quando a operação for salva uma ou várias vezes e retornar o mesmo resultado, como a de salvar um endereço.
se cada vez que chamar uma operação, ela retornar um resultado diferente, deve-se utilizar o método POST, por isso que foi utilizado ele na operação de atualizar a lista.

query bolado:

SELECT TB_BELONGING .*, TB_GAME.TITLE FROM TB_BELONGING
INNER JOIN TB_GAME ON TB_GAME.ID = TB_BELONGING.GAME_ID
WHERE LIST_ID=2
ORDER BY POSITION
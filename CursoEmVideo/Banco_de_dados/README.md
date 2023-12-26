# Banco de dados

Curso que terá sua abordagem no **banco de dados relacional** de forma que será explicado a linguagem **SQL** (Structure Query Language) que é uma linguagem universal para os bancos de dados.

No banco de dados temos databases > tables > values.

Para a criação de databases, usamos o `CREATE DATABASE nome` posteriormente usando o `CREATE TABLE tbl_name(...values) DEFAULT CHARSET = utf8`.

Para usar o **database** deve-se utilizar o comando `USE DATABASE`.

O uso do comando `DESCRIBE` é dado para realizar a descrição da tabela informada. E o comando `STATUS` para demonstrar qual o banco de dados que está aberto.

Para a criação de um banco de dados no padrão da línguagem brasileira, onde tem vários acentos, deve-se utilizar `constraints` para definir o charset utf-8 no banco de dados, conforme o código abaixo:

```sql
CREATE DATABASE cadastro
default character set utf8
default collate utf8_general_ci;
```

Na definição de um banco de dados, pode-se utilizar várias `constraints`, como o **NOT NULL** para definir que um valor não pode ser nulo, o **date** para definir que o valor deve ser uma data, ao definir varchar(**x**), precisa de colocar o valor máximo aceito por dado na tabela no lugar de **x**, pode-se declarar **enum**, e **default** para quando o valor não for preenchido, e na declaração de decimal(**x,y**), no lugar de **x** é marcado quantas casas totais teram o valor e no lugar de **y** é marcado quantas dessas casas ficaram após a vírgula.

Na alteração de tabela é utilizado o comando `ALTER TABLE` é possivel alterar tabela, acompanhando o comando `ADD COLUMN` ou `DROP COLUMN`, no caso de querer adicionar coluna após alguma em específico, basta usar o comando `AFTER` e o nome da coluna ou usando o comando `FIRST`. Para realizar modificação nas colunas se usa o comando `MODIFY COLUMN`, sendo que para alterar o nome da coluna, é necessário usar o comando `CHANGE`.

Para alterar o nome da tabela o comando necessário é o `RENAME TO`.

Utiliza-se o comando `UPDATE` para atualizar dados em uma tabela, juntamente com o comando `SET` que define o novo valor e sua respectiva coluna e o comando `WHERE` que define o local de comparação para realizar a substituição de dados, para uma segurança é utilizado o comando `LIMIT` com o quantitativo de colunas que podem ser alteradas.

E o comando `DELETE` junto ao comando from para apagar algum dado da tabela especifica. Enquanto o `TRUNCATE` serve para apagar todos os dados de uma tabela.

Utiliza-se o comando `SELECT` para fazer uma query buscando dados em tabelas, podendo ordenar por ordem alfabética em coluna determinada com o `ORDER BY` e também mostrar somente os dados das colunas que forem solicitados e também dados condicionais com o comando `WHERE`, sendo que dentro deste comando pode-se utilizar o comando `BETWEEN` e o in quando forem valores específicos, e não um range. Uma forma de procurar se um dado contém algum valor dentro dele, pode=se usar o `LIKE` incluíndo `%` onde o porcento se refere a qualquer coisa realizando pesquisa com case insensitive e também ignorando acentuação, na utilização de `_` busca dados com a necessidade de ter um caractere existente onde está localizado o item `_`. O uso do `DISTINCT` ignora os dados repetidos. o `COUNT` mostra a quantidade de items vai ser retornada com os parâmetros passados no `SELECT` e também pode-se utilizar o `MAX`, `MIN`, `AVG` e `SUM`. E para fornecer um maior dinamismo é utilizado o `GROUP BY` junto com os comandos citados anteriormente ou o comando `COUNT` para que seja gerada uma tabela nova onde será apresentado os valores agrupados, sendo possível usar o comando `HAVING` para indicar regra para o campo selecionado no `GROUP BY`.

Todos os retornos de um `SELECT` são um resultSet.

O comando `AS` é utilizado para dar apelidos a uma tabela para que o **query** fica de um tamanho mais reduzido.

Para mostrar mais de uma tabela em uma `QUERY` é utilizado o comando `JOIN` que por sua vez quando não acompanhado de outro comando é considerado um `INNER JOIN` qual mostra apenas os dados que tem ligação entre as tabelas. Sempre que for utilizar este comando deve-se utilizar o comando `ON` que refere a comparação da chave estrangeira com o id.

No uso do `OUTER JOIN` deve indicar qual o conteúdo que deve ser mostrado mesmo sem ter relacionamento com outra tabela, indica-se a tabela com o comando `LEFT` ou `RIGHT`.

Em realacionamento many-to-many se utiliza o comando `JOIN` aninhado para ligar mais de duas tabelas em conjunto.

---

## Tipos de comandos

Os comandos `SQL` são divididos em:

**DDL** – Data Definition Language
**DQL** – Data Query Language
**DML** – Data Manipulation Language
**DCL** – Data Control Language
**TCL** – Transaction Control Language

Sendo o `ddl`, os comandos que realizam definição na estrutura do banco de dados, como os que criam tabelas e database;

O `dql`, os comandos que fazem pesquisa no banco de dados.

O `dml`, os comandos que manipulam dados;

## Relacionamento

Para representar um realacionamento de forma visual fazumos um `DER`(Diagrama Entidade Relacionamento) que dentro desse item existe a cardinalidade que pode ser **1** ou **n** sendo que na cardinalidade é sempre representado a maior quantidade possível para um relacionamento onde havendo **n** deve-se utiliza-lo em vez de 0 ou 1.

- Ordem de chaves:
  - **one-to-one**: se for necessário separar em tabelas diferentes a chave estrangeira deve ficar na tabela da entidade dominante.
  - **one-to-many**: a chave estrangeira deve ficar na tabela da entidade com cardinalidade 1.
  - **many-to-many**: cria uma entidade de ligação e faz um relacionamento one-to-many para cada entidade.

Para gerar uma chave estrangeira deve-se utilizar o comando `ALTER TABLE` junto ao comando `ADD FOREIGN KEY` com o nome da chave estrangeira entre parênteses e depois `REFERENCES` e o nome da tabela junto ao id que se refere.

_**Bizural**_: Para facilitar a criação de relacionamento e definir a cardinalidade, basta inserir alguns valores ficticios e gerar uma possível relação fictícia conforme a imagem abaixo:

[<img width="700px" src="./assets/image.png" />](./assets/image.png 'Estrutura')

## Resumo

Este curso realizado gerou a possibilidade de aprender várias coisas sobre o SQL em si, e também sobre sua construção, de forma que ao utilizar os comandos pode-se saber oque é cada coisa e qual é o seu nome. Mesmo sendo um curso básico foi passado o conhecimento de forma que foi possível o aprendizado de coisas que já haviam sido vistar por mim em outros cursos.

---

## Desenvolvido por

[<img width="100px" src="https://avatars.githubusercontent.com/u/100999610" alt="My Profile Image"/>](https://github.com/BrunoMedeiros14 'Perfil no GitHub (BrunoMedeiros)')

**[Retornar para página anterior](../README.md)**
<strong> | <a href="#top">Volte para o topo 🔝</a> </strong>

<p align="center">By <strong><a href="https://github.com/BrunoMedeiros14">Bruno Medeiros</a></strong>.</p>

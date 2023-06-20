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

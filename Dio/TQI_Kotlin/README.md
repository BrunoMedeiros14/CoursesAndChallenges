# BootCamp TQI Kotlin

Nesse bootcamp foi apresentado a introdução ao **Docker** e como é o seu funcionamento, a sintaxe básica do **Java** e como utilizar sendo utilizada uma pilha de exercícios para fixar a matéria ensinada.

---

## Docker

Foi ensinado quando e como utilizar um container docker e vários comandos utilizados normalmente.

### Comandos efetivos para Docker

- pull - Baixar imagem
- ps/ls - listar docker
  - a = all
- run - executa imagem

  - i - executa docker no modo interativo
  - t - associa o seu terminal ao do container
  - d - roda o container em background
  - name - define nome do container
  - p - redireciona porta
  - e - define variáveis de ambiente
  - v - define pasta a ser compartilhada entre máquina e conteiner

    > Do tipo bind:
    >
    > - São pastas normais que são conectadas com o Docker diretóriodopc:/localNoDocker
    >
    > Do tipo named:
    >
    > - Volumes nomeados (docker volume create vol-name) volume:/local
    >
    > Do tipo volume:
    >
    > - É o mesmo que o named, só que com nome aleatório

  - m - limita memória disponibilizada para o container (128M)
  - cpus - limita núcleo utilizado pelo container (0.2 -> está usando 20% do processador)
  - network - define rede do container

- rm - remove o container
- rmi - remove imagem existente
- images - lista imagens baixadas
- exec - executa comando em container em execução
- cp - copia arquivo/pasta entre container e sistema operacional base (nomedocontainer:/caminho localdoSORaiz)
- inspect - traz informação detalhada do docker
- stop - para imagem em execução
- prune - remove tudo que não está sendo utilizado
- stats - mostra consumo de memória/cpu
- update - atualiza dados do container
- logs - mostra os logs do container
- info - mostra informações do container
- top - mostra processos sendo executado pelo container
- network - trabalha com redes virtuais para isolar o docker
  - inspect nome_da_rede - mostra informações da rede
  - create nome_da_rede - cria uma rede

> **Ctrl+p + Ctrl+q** - sai do container sem dar stop nele
> _O COMANDO STOP NÃO APAGA OS ARQUIVOS DO CONTEINERS, SOMENTE REMOVENDO-O_

### Desafio docker

O desafio proposto para o final do módulo de Docker foi de criar um docker compose capaz de executar uma aplicação HTML em um Container Apache.

Sendo assim, dentro da pasta **Desafio Docker** contém um docker compose junto de uma pasta contendo um arquivo html de uma página com `Hello Horld`.

- [Docker Compose](./Desafio%20Docker/docker-compose.yml)
- [Html do Hello World](./Desafio%20Docker/src/index.html)

Para executar o docker compose, basta ter o docker e docker compose intalado no computador e executar o comando abaixo no diretório do docker arquivo **docker-compose.yml**.

```bash
docker compose up
```

Preview:

[<img width="400px" src="./Desafio%20Docker/Preview.png" />](./Desafio%20Docker/Preview.png 'Print da página criada no Apache')

---

## Java

O uso do static faz com que o atributo seja executado uma única vez.

Pode-se utilizar o spread operator em método no Java e configurar um código para executar sempre que o objeto é criado:

```java
class Exemplo{
  {System.out.printf("Exemplo criado.");} // será executado sempre que a classe for instanciada
  public static void (String... string){} // uso do spread
}
```

Fato observado é que para usar string sem precisar de concatenar, só usar o printf:

```java
System.out.printf("\nTexto %.2f\n", variável);
```

### Estrutura dos métodos

```bash
?visibilidade ?tipo ?modificador retorno nome (?parâmetros?) ?exceções corpo
```

|  #  | Função                       |
| :-: | :--------------------------- |
|  V  | public, protected ou private |
|  M  | concreto ou abstrato         |
|  V  | static ou final              |
|  R  | tipo de dado ou "void"       |
|  N  | nome                         |
|  P  | parâmetros que pode receber  |
|  E  | exceções que pode lançar     |
|  C  | Corpo do código              |

### Sobrecarga de método

Quando se utiliza o método com mesmo nome, mas muda sua assinatura (mudando os **parâmetros**) cria uma sobrecarga de método, basicamente, criando 2 métodos que são invocados pelo mesmo nome, mas com parâmetros diferentes.

- **[exemplo](./learn-java/src/edu/brunodemedeiros/exercises/Sobrecarga.java)**

Obs: Para causar sobrecarga tem que mudar os tipos primitivos dos parâmetros (alterando assim sua assinatura).

### Listas

Para a interface **List** se utiliza **ArrayList** ou **LinkedList**.

- A interface **List** é composta por uma grande manuseabilidade, aceitando até elementos repetidos.

E para a interface **Set** se utiliza **HashSet** que é o mais rápido, porém desordenado, o **LinkedHashSet** que é o segundo mais rápido e mantém a ordem que foi feito e o **TreeSet** que é o mais lento mas ordena todos os itens na ordem natural.

- Lembrando que a interface **Set** não guarda o index dos itens, e não aceita elementos repetidos.

- A interface **Map** tem a mesma finalidade que a interface **Set**, no entanto o **Map** é voltado para armazenar _Objetos_, sendo necessário uma key para todos os objetos armazenados.

### Programação funcional

A programação funcional no java é inclementada a partir do método **.stream()**, levando não alterando a lista original na qual ela está trabalhando.

- Dessa forma, sempre que o objetivo for causar um efeito colateral na _Lista_, deve-se utilizar os métodos pertencentes a ela, não sendo possível com o stream.

### Desafio Java

No desafio final do módulo de java, para fixar o conhecimento de toda a matéria aprendida durante o curso e também desenvolver o conceito de **POO**, foi proposto a criação de um programa que com a abstração do domínio de um bootcamp, fosse criado seus atributos e métodos.

> O arquivo para a execução deste desafio se encontra na pasta [learn-java/src](https://github.com/BrunoMedeiros14/CoursesAndChallenges/tree/main/Dio/TQI_Kotlin/learn-java/src/), sendo o arquivo [ObjectProgramming](./learn-java/src/ObjectProgramming.java) aquele que basicamente roda a aplicação e os pacotes dentro da pasta [exercises/oop](https://github.com/BrunoMedeiros14/CoursesAndChallenges/tree/main/Dio/TQI_Kotlin/learn-java/src/exercises/oop/) as classes gerada para a conclusão do desafio.

Foi utilizado as bases da Programação Orientada a Objeto como a `abstração`, para a criação da classe _Content_ onde haviam várias semelhanças entre as classes **Course** e **Mentoring** e utilizando o `encapsulamento` nessas classes para a utilização adequada de seus atributos, e a `herança` para herdar os métodos de _Content_ para **Course** e **Mentoring** e o `polimorfismo` para realizar um upcast dessas duas classes para _Content_, sendo possível armazena-las em uma mesmo lista, como demonstrado na classe Dev e na classe Bootcamp.

- [link do desafio](https://github.com/cami-la/desafio-poo-dio)

---

## Kotlin

vararg é como se estivesse utilizando o spread operator.
var é mutavel e val não é mutável
Usando String? faz a string poder ser nula. Normalmente utilizado com o elvis operator **?:** que se o elemento for nulo, retorna um valor que está na frente.

Função do **.apply** é como se fosse um constructor externo.

Usando o .let em frente ao Objeto definimos um escopo para executar algo no qual o objeto atrás do let é mencionado com o **it**.

Sendo que a diferença pro .run é que ao não precisa de referenciar o objeto principal com o it.

Utiliza-se o infix pra criar mini funções na qual vai retornar o elemento com um elemento posterior como entrada.
O método **operator** funciona similar, mas deve-se ser aprofundado o estudo nele.

Também tem as maravilhosas high-order functions.

**Extension function** inclúi métodos na classe.

Até o objeto null pode ser extendido com a **extension function**, exemplo dado usando a sobrescrita do método tostring.

Todas as _exceptions_ derivam da **Throwable**.

### Desafio Kotlin

No desafio final do módulo de Kotlin, para fixar o conhecimento de toda a matéria aprendida durante o curso e também desenvolver o conceito de **POO**, foi proposto a criação de um programa conforme a proposta abaixo.

> **A [DIO](https://web.dio.me) possui `Formacoes` incríveis que têm como objetivo oferecer um conjunto de `ConteudosEducacionais` voltados para uma stack tecnológica específica, preparando profissionais de TI para o mercado de trabalho. `Formacoes` possuem algumas características importantes, como `nome`, `nivel` e seus respectivos `conteudosEducacionais`. Além disso, tais experiências educacionais têm um comportamento relevante ao nosso domínio, definido pela capacidade de `matricular` um ou mais `Alunos`.**

E o arquivo para a execução deste desafio se encontra na pasta [kotlin-challenge/src/main/kotlin](https://github.com/BrunoMedeiros14/CoursesAndChallenges/tree/main/Dio/TQI_Kotlin/kotlin-challenge/src/main/kotlin), sendo o arquivo [Main.kt](./kotlin-challenge/src/main/kotlin/Main.kt) aquele que basicamente roda a aplicação e os pacotes relacionado a esta.

Para a elaboração da solução, foi criado um diagrama de classes conforme a proposta:
[<img width="700px" src="./kotlin-challenge/assets/DiagramaDeClasses.png" />](./kotlin-challenge/assets/DiagramaDeClasses.png 'Diagrama de classes')

De forma que além de praticar o kotlin, também foi possível praticar o uso de diagrama de classes.

- [link do desafio](https://github.com/digitalinnovationone/aprenda-kotlin-com-exemplos-lab 'repositório do desafio')

---

## Sql

No banco de dados relacional todos os dados são único, se for necessário repetir, deve-se criar outra tabela para inserir os dados repetidos.

### Comandos básicos

- CREATE TABLE: criar tabela
- INSERT INTO: inserir dados tabela
- SELECT: visualiza elementos na tabela
- UPDATE .. SET: atualiza valor na tabela
- WHERE: cláusula condicional
- DELETE: deleta valor no banco de dados
- ORDER BY: ordena dados
  - DESC -> ordena em ordem decrescente
- GROUP BY: agrupa dados conforme coluna indicada, usado com **COUNT** pra mostrar quantos elementos tem cada informação única
- ALTER TABLE: altera dados de uma tabela
  - ADD: define dados
- DROP TABLE: apaga tabela
- DROP DATABASE: apaga database
- AS: cria um apelido para tabela em query grande
- JOIN: seleciona query com outra tabela através de fk_id, podendo usar mais de um **JOIN** por vez
  - ON: define a coluna que é para comparar a fk
- INNER JOIN: o **JOIN** por padrão é representado como este, pois ele oculta todos os valores que estiverem nulos
- OUTER JOIN: tendo que definir **RIGHT** ou **LEFT**, esse método define o lado que pode conter valores não nulos (sem relacionamento) em um query usando o JOIN.

Exemplos:

```sql
INNER JOIN: SELECT * FROM pessoas JOIN cursos pessoas.fk_cursos = cursos.id_cursos
```

### Uso em terminal

No terminal, sempre precisa de colocar o ";" no final do comando, se não fica pulando a linha infinitamente sem fazer o comando.

**show databases**: mostra os banco de dados disponíveis

**use '_database_'**: seleciona o db para trabalhar
show tables: mostra as tabelas disponíveis

---

## JPA / Hibernate

O JDBC (Java Database Connectivity) é um conjunto de classes que geram uma API para realizar uma conexão com qualquer banco de dados relacional. De maneira que ele não tem os objetos suficientes para realizar a conexão de maneira completa, precisando de instalar driver adicional no qual vai realizar uma interpletação dos comandos no Java para o banco de dados.

No entanto, o uso do JDBC gera uma dificuldade na comunicação com o banco de dados, sendo de uma maneira muito engessada e verbosa, precisando de usar mais comandos em SQL que no Java nativo.

Para resolver esse problema, teve o surgimento em várias linguagens de programação framework ORM (Object Relational Mapper) no qual serviria de uma API para o banco de dados de maneira mais dinâmica, transformando um objeto/ classe diretamente em um item do banco de dados, tornando mais fácil a utilização do banco de dados. Com isso teve a chegada do **Hibernate** que posteriormente viria a fazer parte do **Jpa** no Java, gerando facilidades como a de retornar diretamente um objeto de uma pesquisa no banco de dados, ao invés de um **ResultSet**.

Para resolver a possível utilização do Jpa, deve-se criar um arquivo **persistence.xml** na pasta META-INF em **resources** para que esse arquivo possa mapear as propriedades da conexão com o servidor, sendo que cada uma conexão é configurada dentro de um arquivo persistence-unit.

Os decorators presente nas classes que se transformam em ORM através do JPA, são os mesmos que são utilizado normalmente pelo spring, pois estes são derivados de biblioteca do JPA em si.

É recomendado para que toda operação feita através do JPA seja feita com o modo **Transaction** ativado para uma maior segurança da conexão com o banco de dados, e também deve-se comitar após a operação feita no banco.

Inicia e termina um modo transacional para que se algum dado feite dentro do código der erro, toda a transação vai ser cancelada, evitando de fazer uma transação de dados incompleta.

A utilização do hibernate colabora com a insenção de necessidade de sempre que mudar de banco de dados precisar de fazer uma migration.

Com a utilização do framework **Spring** não é necessário fazer o mapeamento do banco de dados no **persistence.xml**, podendo utilizar somente a configuração do spring.

---

## JUnit

Esse é uma das principais bibliotecas para realizar testes do Java.

Para a realização de testes no Java, sempre precisa de manter os arquivos de testes dentro da pasta **test** como boas práticas, mantendo sempre os testes separado do projeto base na pasta **main**.

Todos os métodos que vão realizar testes unitários devem utilizar o decorator **@Test** e retornam valores vazios, sendo que o nome do método deve descrever o teste que este realizará.

Dentro do corpo dos métodos, pode-se utilizar métodos derivados da classe **Assertions**, como o **.assertEquals** e o **.assertTrue** e até **.assertArrayEquals** que pode comparar Arrays.

Normalmente, para não precisar de escrever _Assertions_ em todos os testes, é realizada a importação **estática** desse método, sendo possível omitir o nome da classe.

Usando o decorator **@BeforeAll** e **@AfterAll**, pode-se configurar tarefas para preparar e limpar rastros dos testes realizados. Tendo também o **@AfterEach** e **@BeforeEach** que executa o método indicado antes e após cada método da classe.

Também tem possivilidade de ver se uma excessão foi lançada e também escolher qual a ordem de testes a serem utilizadas.

---

## Gradle e gradlew

O gradlew é o gradle compactado como o maven wrapper, sendo possível mover o arquivo para outras pastas de trabalho sem precisar de sua instalação, garantindo que todas as compilações com ele sejam idênticas.

Tendo como um grande diferencial por ser escrito em formato semelhante ao kotlin, sendo mais fácil de manusear-lo que o maven.

As tasks são importadas através de plugin, como o exemplo da task run que está dentro do plugin application. Sendo que se ele for utilizado, deve-se definir qual é a classe principal do projeto que vai ser executada por ele, podendo definir também o applicationName e executableDir.

Também é possível trabalhar com múltiplos módulos no gradle implementando dentro de cada submódulo na suas dependencias.

--console=plain ou -q (tira o log do gradle que fica mostrando a porcentagem)

Usando o doLast ou doFirst pode-se modificar as tasks existentes no gradle.

Usando o **dependsOn** (também pode ser um array) roda uma task configurada antes de rodar a task atual e usando o **finalizedBy**, roda a task solicitada após terminar a execução atual.

Com o mustRunAfter a task atual sempre sera executada após a task indicada.

Com task type, pode utilizar tipos como **Delete**, **Copy**, **Zip** para cumprir tarefas com uma task.

---

## Padrões de Projetos na Prática

Os padrões de projetos, como relatado no livro de Design Pattern (criado pelo Gang of Four) descreve métodos, dos quais, pode-se fazer um codigo com soluções consolidads para problemas recorrentes no desenvolvimento/manutenção de software POO.

Na aula foi explicado que há patterns divididos nos seguintes tópicos:

- Padrões Criacionais: Abstract Factory, Builder, Factory Method, Prototype, Singleton.

- Padrões Comportamentais: Chain of Responsibility, Iterator, Observer, Strategy, Template Method.

- Padrões Estruturais: Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy.

Sendo que o **singleton** tem base em criar uma única instância de classe de maneira estática, gerando uma forma de recuperá-la.

O **strategy**, simplifica a variação de um algorítimo pra um problema, como o relatado no curso que foi gerada várias classes que contém **override** de métodos voltados para um fim específico.

E o **facade** traz uma interface que reduz a complexidade nas integrações com subsistema.

### Desafio de patterns

Neste desafio de código foi proposto a utilização de design patterns em algum projeto, podendo utilizar projetos já feito na plataforma.

Dessa maneiro eu aponto o API feito no decorrer do curso de **criação de API Rest com Kotlin** que se encontra na pasta deste repositório [credit-applicatoin-system](https://github.com/BrunoMedeiros14/CoursesAndChallenges/tree/main/Dio/TQI_Kotlin/credit-application-system/) que ao utilizar o Spring Boot para sua criação consequentemente foi utilizado o _**Strategy**_ para injetar no spring o Serviçe uasndo a decoration **@Autowired** e utilizando o _**Singleton**_ para a construção do **Service**. Sendo assim, estamos acoplando um Service (Singleton) no Spring através de um Strategy.

Por fim é utilizado o pattern _**Facade**_ no controller, para que de forma simples e coesa seja possível a criação de um API Rest.

---

## Documentando e testando API - Kotlin

Foi ensinado a criar testes unitários e também a criar documentação através do **springdoc**.

### Desafio de testes

Neste desafio de código foi proposto a inserção de uma documentação no projeto [credit-applicatoin-system](https://github.com/BrunoMedeiros14/CoursesAndChallenges/tree/main/Dio/TQI_Kotlin/credit-application-system/ 'projeto credit-applicatoin-system'), junto da insersão de testes unitários para um código com maior eficiência. Junto da proposta, teve várias aulas explicando como que funciona os testes unitários e explicando também como integrar a documentação com Swagger, na qual foi inclementada no projeto.

O projeto final, foi baseado no repositório [credit-application-system](https://github.com/cami-la/credit-application-system 'Repositório base'), desenvolvido pela [cami-la](https://github.com/cami-la 'Desenvolvedora'). No qual, se utilizou o Spring com a linguagem Kotlin e gerenciador de projeto Gradle.

O meu projeto finalizado se encontra [aqui](https://github.com/BrunoMedeiros14/CoursesAndChallenges/tree/main/Dio/TQI_Kotlin/credit-application-system/ 'projeto credit-applicatoin-system'), e sua documentação [aqui](./credit-application-system/README.md 'Documentação Credit-application-system').

---

## Desenvolvido por

[<img width="100px" src="https://avatars.githubusercontent.com/u/100999610" />](https://github.com/BrunoMedeiros14 'Perfil no GitHub (BrunoMedeiros)')

**[Retornar para página anterior](../README.md)**
<strong> | <a href="#top">Volte para o topo 🔝</a> </strong>

<p align="center">By <strong><a href="https://github.com/BrunoMedeiros14">Bruno Medeiros</a></strong>.</p>

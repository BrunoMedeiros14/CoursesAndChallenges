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

    docker compose up

Preview:

[<img width="400px" src="./Desafio%20Docker/Preview.png" />](./Desafio%20Docker/Preview.png 'Print da página criada no Apache')

---

## Java

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

---

**[Retornar para página anterior](../README.md)**
<strong> | <a href="#top">Volte para o topo 🔝</a> </strong>

<p align="center">By <strong><a href="https://github.com/BrunoMedeiros14">Bruno Medeiros</a></strong>.</p>

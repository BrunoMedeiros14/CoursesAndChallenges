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

**[Retornar para página anterior](../README.md)**
<strong> | <a href="#top">Volte para o topo 🔝</a> </strong>

By **[Bruno Medeiros](https://github.com/BrunoMedeiros14)**.

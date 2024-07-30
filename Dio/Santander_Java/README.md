# BootCamp Santander Java

## Java

### Desafio Conta Bancária

O desafio [DIO - Trilha Java Básico](https://github.com/digitalinnovationone/trilha-java-basico/blob/main/desafios/sintaxe/README.md) propõe a criação de um projeto para terminal que lê os dados de criação para uma conta bancária, que solicita a inserção de dados via terminal e logo após apresenta a conta criada.

> O arquivo para a execução deste desafio se encontra na pasta [desafio-basico/src](https://github.com/BrunoMedeiros14/CoursesAndChallenges/tree/main/Dio/Santander_Java/desafio-basico/src/), sendo o arquivo [ContaTerminal](./desafio-basico/src/ContaTerminal.java) aquele que basicamente roda a aplicação.

Como bônus, foi inserido no desafio proposto a inclusão do tratamento de dados inserido no arquivo, para que não seja possível inserir dados de tipos indevidos, como a inserção de uma string no lugar de um double.

---

### Desafio Controle de Fluxo

O desafio de [Controle de Fluxo](https://github.com/digitalinnovationone/trilha-java-basico/tree/main/desafios/controle-fluxo) propõe a criação de um projeto que contém uma validação que após inserir dois inteiros retorna a diferença entre esses números ou lança uma exceção personalizada se o segundo número inserido for maior que o primeiro.

> O arquivo para a execução deste desafio se encontra na pasta [controle-fluxo/src](https://github.com/BrunoMedeiros14/CoursesAndChallenges/tree/main/Dio/Santander_Java/controle-fluxo/src/), sendo o arquivo [Contador](./controle-fluxo/src/Contador.java) aquele que basicamente roda a aplicação.

---

### Desafio POO

Nesse desafio foi proposta uma diagramação em UML do que seria a classe Iphone com interfaces para implementar o **Reprodutor Musicial**, **Aparelho Telefônico** e o **Navegador de Internet**.

```mermaid
classDiagram
      ReprodutorMusical <|-- Iphone
      Telefone <|-- Iphone
      NavegadorInternet <|-- Iphone

      class Iphone {
          - model: String
          - anoFabricacao: Int
          - Color: String
      }

      class ReprodutorMusical {
          <<interface>>
          +tocar(): void
          +pausar(): void
          +selecionarMusica(): void
      }

      class Telefone {
          <<interface>>
          + ligar(): void
          + atender(): void
          + iniciarCorreioVoz(): void
      }

      class NavegadorInternet {
          <<interface>>
          + exibirPagina(): void
          + adicionarNovaAba(): void
          + atualizarPagina(): void
      }
```

> Com base no diagrama, foi criado um exemplo de código em java de como seria sua implementação na pasta [desafio-poo](https://github.com/BrunoMedeiros14/CoursesAndChallenges/tree/main/Dio/TQI_Kotlin/desafio-poo/src/), onde o arquivo principal é o [Iphone.java](./desafio-poo/src/Iphone.java).

---

### Desafio Banco Digital

O desafio de [Criação de Banco Digital](https://github.com/falvojr/lab-banco-digital-oo) propõe a criação de um projeto que contém um protótipo de criação de banco digital, utilizando os princípios da orientação a objeto.

A proposta do desafio foi implementar melhorias no código proposto com base no conhecimente adiquirido até o atual momento dos pilares da orientação a objeto e também a implementação do lombok no código.

> O arquivo para a execução deste desafio se encontra na pasta [desafio-banco/src](https://github.com/BrunoMedeiros14/CoursesAndChallenges/tree/main/Dio/Santander_Java/desafio-banco/src/), sendo utilizado o maven com suas configurações concentrada no arquivo [pom.xml](./desafio-banco/pom.xml).

---

## Desenvolvido por

[<img width="100px" src="https://avatars.githubusercontent.com/u/100999610" alt="My Profile Image"/>](https://github.com/BrunoMedeiros14 'Perfil no GitHub (BrunoMedeiros)')

**[Retornar para página anterior](../README.md)**
<strong> | <a href="#top">Volte para o topo 🔝</a> </strong>

<p align="center">By <strong><a href="https://github.com/BrunoMedeiros14">Bruno Medeiros</a></strong>.</p>

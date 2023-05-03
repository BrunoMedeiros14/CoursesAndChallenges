package exercises.challenges;
// Para ler e escrever dados em Java, aqui na DIO padronizamos da seguinte forma: 

// - new Scanner(System.in): cria um leitor de Entradas, com métodos úteis com prefixo "next";
// - System.out.println:.imprime um texto de Saída (Output) e pulando uma linha.

import java.util.Scanner;

public class BookstoreBuy {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Livro livro1 = new Livro(scanner.nextLine(), scanner.nextDouble(), scanner.nextInt());
    scanner.nextLine();
    Livro livro2 = new Livro(scanner.nextLine(), scanner.nextDouble(), scanner.nextInt());

    Double total = livro1.getTotalPrice() + livro2.getTotalPrice();
    Integer amount = livro1.amount + livro2.amount;

    System.out.printf("Valor total da compra: %.2f\n", total);
    System.out.printf("Numero de livros comprados: %s\n", amount);
    System.out.printf("Obrigado por comprar na nossa livraria!\n");

    scanner.close();
  }

  static class Livro {
    String name;
    private Double price;
    Integer amount;

    Livro(String nome, double preco, int quantidade) {
      this.name = nome;
      this.price = preco;
      this.amount = quantidade;
    }

    public Double getTotalPrice() {
      return this.price * this.amount;
    }
  }
}
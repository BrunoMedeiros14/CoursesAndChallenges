package exercises.challenges;
// Para ler e escrever dados em Java, aqui na DIO padronizamos da seguinte forma: 

// - new Scanner(System.in): cria um leitor de Entradas, com métodos úteis com prefixo "next";
// - System.out.println:.imprime um texto de Saída (Output) e pulando uma linha.

import java.util.Scanner;

public class TrafficLight {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numero = scanner.nextInt();

    // Crie as condições necessárias para imprimir cada uma das possíveis
    // saídas.
    if (numero == 1)
      System.out.println("Pare! O sinal está vermelho.");
    else if (numero == 2)
      System.out.println("Atenção! O sinal está amarelo.");
    else if (numero == 3)
      System.out.println("Siga em frente! O sinal está verde.");
    else
      System.out.println("Valor inválido! Digite 1, 2 ou 3 para indicar a cor do semáforo.");

    scanner.close();
  }
}
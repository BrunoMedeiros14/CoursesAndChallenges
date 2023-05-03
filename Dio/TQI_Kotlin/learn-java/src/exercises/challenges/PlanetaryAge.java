package exercises.challenges;
// Para ler e escrever dados em Java, aqui na DIO padronizamos da seguinte forma: 

// - new Scanner(System.in): cria um leitor de Entradas, com métodos úteis com prefixo "next";
// - System.out.println:.imprime um texto de Saída (Output) e pulando uma linha.

import java.util.Scanner;

public class PlanetaryAge {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(27 * 1.61);
    double idadeTerrestre = scanner.nextDouble();
    String planeta = scanner.next();

    if (planeta.equals("Marte"))
      idadeTerrestre *= 0.531915;
    else if (planeta.equals("Venus"))
      idadeTerrestre *= 1.612962963;
    else if (planeta.equals("Jupiter"))
      idadeTerrestre *= 0.084317;
    else {
      System.out.println("Planeta invalido.");
      scanner.close();
      return;
    }

    System.out.printf("Idade equivalente em %s: %.2f anos", planeta, idadeTerrestre);
    scanner.close();
  }
}
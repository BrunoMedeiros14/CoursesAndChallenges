package exercises.challenges;
// Para ler e escrever dados em Java, aqui na DIO padronizamos da seguinte forma: 

// - new Scanner(System.in): cria um leitor de Entradas, com métodos úteis com prefixo "next";
// - System.out.println:.imprime um texto de Saída (Output) e pulando uma linha.

import java.util.Scanner;

public class ToIreland {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Leitura do salário e dos benefícios
    double salarioBruto = input.nextDouble();
    double beneficios = input.nextDouble();

    double imposto = 0;

    if (salarioBruto <= 1100)
      salarioBruto *= 0.95;
    else if (salarioBruto <= 2500)
      salarioBruto *= 0.9;
    else
      salarioBruto *= 0.85;

    double salarioLiquido = salarioBruto - imposto + beneficios;

    System.out.printf("%.2f\n", salarioLiquido);
    input.close();
  }
}
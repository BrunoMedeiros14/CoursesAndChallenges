package exercises.syntax;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Loops {

  public static void main(String[] args) {
  }

  /**
   * Solicita o nome e idade até que o usuário digite 0, encerrando o método.
   */
  public void nameAndAge() {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    while (true) {
      System.out.println("Qual é o seu nome?");
      String name = scanner.next();

      if (name.equals("0"))
        break;

      System.out.println("Insira sua idade " + name + ":");
      int age = scanner.nextInt();

      System.out.println("Olá " + name + " que tem " + age + " anos.");
    }

    System.out.println("Finalizando aplicativo.");
    scanner.close();
  }

  /**
   * Solicita que o usuário digite uma nota de 0 a 10,
   * repetido a solicitação até o o usuário digite um valor válido.
   */
  public void note() {
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    System.out.println("Digite a nota final:");
    float note = scanner.nextFloat();

    while (note <= 0.0 || note >= 10.0) {
      System.out.println("Digite um valor entre 0 e 10:");
      note = scanner.nextFloat();

    }

    System.out.println("Finalizando aplicativo.");
    scanner.close();

  }

  /**
   * Solicita que o usuário digite 5 valores e printa o maior valor e a média
   * deles.
   */
  public void getHighestAndAverage() {
    Scanner scan = new Scanner(System.in).useLocale(Locale.US);
    int highesNote = 0;
    int total = 0;

    for (int i = 1; i <= 5; i++) {

      System.out.println("Qual é o " + i + "° valor?");
      int note = scan.nextInt();

      if (note > highesNote)
        highesNote = note;

      total += note;

    }

    System.out.println("O maior valor foi " + highesNote + " e a média é " + total / 5 + ".");

    scan.close();
  }

  /**
   * solicita a quantidade de números que o usuário quer digitar, e de acordo
   * com a entrada, solicita a quantidade de números, retornando quantos
   * números ímpares e quantos números pares foram digitados.
   */
  public void OddOrEven() {
    Scanner scan = new Scanner(System.in);

    System.out.println("Quantos números vão ser inseridos?");
    int limit = scan.nextInt();

    int count = 0, odd = 0, even = 0;

    do {
      count++;

      System.out.println("Qual é o " + count + " valor?");
      int number = scan.nextInt() % 2;

      if (number == 0)
        even++;
      else
        odd++;

    } while (count < limit);

    System.out.println(
        "No total, foram digitados " +
            odd + " números ímpares e " + even + " números pares.");

    scan.close();

  }

  /**
   * Imprime uma tabuada de acordo com o número solicitado pelo usuário.
   */
  public void multiplicationTable() {

    Scanner scan = new Scanner(System.in);

    System.out.println("Digite um número de 1 a 10 para gerar sua tabuada.");
    int number = scan.nextInt();

    System.out.println("Tabuada de " + number + ":");

    for (int i = 1; i <= 10; i++) {
      System.out.println(number + " X " + i + " = " + number * i);
    }

    scan.close();

  }

  /**
   * Determina o valor do fatorial do número fornecido pelo usuário.
   */
  public void factorial() {
    Scanner scan = new Scanner(System.in);

    System.out.println("Digite o número para saber seu fatorial:");
    int number = 10;// scan.nextInt();

    int total = number;

    for (int i = number - 1; i > 0; i--) {
      System.out.println(i);

      total *= i;

    }
    System.out.println("final total" + total);

    scan.close();
  }

  /**
   * Inverte um array gerado;
   */
  public void inverse() {
    int[] array = { 1, 2, 3, 4, 5, 6 };

    for (int i = array.length - 1; i >= 0; i--) {
      System.out.println(array[i]);
    }
  }

  /**
   * Lê um vetor de 6 caracteres, e diz quantas
   * consoantes foram lidas. Imprima as consoantes.
   */
  public void consonantCounter() {

    Scanner scan = new Scanner(System.in);
    String[] array = new String[6];
    int total = 0;

    String[] array2 = { "a", "b", "c", "d", "e", "f" };

    for (int i = 0; i < 6; i++) {
      System.out.println("Digite a " + (i + 1) + " string.");
      String value = scan.next();
      // String value = array2[i];

      switch (value) {
        case "a":
        case "e":
        case "i":
        case "o":
        case "u":
          break;
        default:
          array[i] = value;
          total++;
          break;
      }
    }

    System.out.print("Foram digitadas " + total + " consoantes, sendo elas");

    for (String string : array2) {
      if (!string.equals(null))
        System.out.print(" " + string);
    }

    System.out.println(".");

    scan.close();
  }

  /**
   * Gera 20 valores aleatórios, armazena em um vetor, mostra os números e seus
   * sucessores.
   */
  public void randomNumbers() {
    Random rand = new Random();

    int[] numbers = new int[20];

    for (int i = 0; i < 20; i++) {
      int value = rand.nextInt(100);

      numbers[i] = value;

      System.out.println(value + " + 1 = " + (value + 1) + ".");

    }

  }

  /**
   * Array Multidimensional: Gere e imprime uma matriz M 4x4 com valores
   * aleatórios entre 0-9. Após isso determine o menor número da matriz e a
   * sua posição(linha, coluna).
   */
  public void array2d() {
    Random rand = new Random();

    int[][] numbers = new int[4][4];
    int min = 0, positionX = 0, positionY = 0;
    int max = 0;

    for (int i = 0; i < numbers.length; i++) {

      for (int j = 0; j < numbers[i].length; j++) {

        numbers[i][j] = rand.nextInt(9);

        if (numbers[i][j] > max)
          max = numbers[i][j];

        System.out.print(numbers[i][j] + " ");

      }
      System.out.println("");
    }

    min = max;

    for (int i = 0; i < numbers.length; i++) {

      for (int j = 0; j < numbers[i].length; j++) {

        if (numbers[i][j] < min) {
          min = numbers[i][j];
          positionX = i + 1;
          positionY = j + 1;
        }
      }
    }

    System.out.println("O menor valor gerado é " + min + ".");
    System.out.println("E sua posição X é " + positionX + ".");
    System.out.println("E sua posição Y é " + positionY + ".");

  }

}

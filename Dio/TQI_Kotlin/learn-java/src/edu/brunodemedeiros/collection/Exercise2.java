package edu.brunodemedeiros.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
1. "Telefonou para a vítima?"
2. "Esteve no local do crime?"
3. "Mora perto da vítima?"
4. "Devia para a vítima?"
5. "Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4 como
"Cúmplice" e 5 como "Assassina". Caso contrário, ele será classificado como "Inocente".
*/
public class Exercise2 {
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    List<Boolean> questions = new ArrayList<>();

    System.out.println("Responda as seguintes perguntas com S ou N:");
    System.out.print("Telefonou para a vítima? ");
    questions.add(getResponse());

    System.out.print("Esteve no local do crime? ");
    questions.add(getResponse());

    System.out.print("Mora perto da vítima? ");
    questions.add(getResponse());

    System.out.print("Devia para a vítima? ");
    questions.add(getResponse());

    System.out.print("Já trabalhou com a vítima? ");
    questions.add(getResponse());

    System.out.println();

    int count = Collections.frequency(questions, true);
    switch (count) {
      case (2):
        System.out.println("Considerado suspeito.");
        break;
      case (3):
      case (4):
        System.out.println("Considerado cúmplice.");
        break;
      case (5):
        System.out.println("Considerado assassino.");
        break;
      default:
        System.out.println("Considerado inocente.");
    }
    ;
    scan.close();
  }

  static Boolean getResponse() {
    String response = scan.next();
    while (true) {
      if (response.equalsIgnoreCase("s"))
        return true;
      if (response.equalsIgnoreCase("n"))
        return false;
      System.out.println("Responda S ou N:");
      response = scan.next();
    }

  }
}

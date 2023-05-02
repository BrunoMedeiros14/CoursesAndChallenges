package edu.brunodemedeiros.collection.map;

import java.util.*;

/*
Faça um programa que simule um lançamento de dados. Lance o dado 100 vezes e armazene.
Depois, mostre quantas vezes cada valor foi conseguido.
 */
public class Exercise2 {
  public static void main(String[] args) {
    Map<Integer, Integer> lancamentos = new HashMap<>();
    Random getRandomValue = new Random();

    for (int i = 0; i < 100; i++) {
      int value = getRandomValue.nextInt(6) + 1;

      if (lancamentos.containsKey(value))
        lancamentos.put(value, (lancamentos.get(value) + 1));
      else
        lancamentos.put(value, 1);
    }

    for (Map.Entry<Integer, Integer> entry : lancamentos.entrySet()) {
      System.out.printf("O número %d caiu %d vezes.\n", entry.getKey(),
          entry.getValue());
    }
  }
}

package edu.brunodemedeiros.collection.map;

import java.util.*;

/*
Dada a população estimada de alguns estados do nordeste brasileiro, faça:
 Estado = PE - população = 9.616.621
 Estado = AL - população = 3.351.543
 Estado = CE - população  =9.187.103
 Estado = RN - população = 3.534.265
 */
public class Exercise1 {
  public static void main(String[] args) {
    Map<String, Integer> population = new LinkedHashMap<>();
    population.put("PE", 9616621);
    population.put("AL", 3351543);
    population.put("CE", 9187103);
    population.put("RN", 3534265);

    System.out.println(population);

    System.out.println("Substituir população RN para 3.534.165.");
    population.put("RN", 3534165);

    System.out.println("Conferindo se PB está na lista, e adicionando se não tiver.");
    if (!population.keySet().contains("PB"))
      population.put("PB", 4039277);

    System.out.printf("População de PE: %s \n", population.get("PE"));

    for (Map.Entry<String, Integer> state : population.entrySet()) {
      System.out.printf("Em %s tem %s cidadãos.\n", state.getKey(), state.getValue());
    }

    Map<String, Integer> orderPopulation = new TreeMap<>(population);
    System.out.println("a população em ordem alfabética:");
    System.out.println(orderPopulation);

  }
}
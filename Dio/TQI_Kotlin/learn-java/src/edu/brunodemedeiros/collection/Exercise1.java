package edu.brunodemedeiros.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Faça um programa que receba a temperatura média os 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média [semestral das temperaturas] e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/
public class Exercise1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    List<Month> temperatures = new ArrayList<>() {
      {
        add(new Month("Janeiro"));
        add(new Month("Fevereiro"));
        add(new Month("Março"));
        add(new Month("Abril"));
        add(new Month("Maio"));
        add(new Month("Junho"));
      }
    };
    List<Double> higherTemperatures = new ArrayList<>();
    List<String> higherMonths = new ArrayList<>();

    Double temperature;
    Double total = 0d;

    for (Month month : temperatures) {
      System.out.println("Qual é a temperatura de " + month.getMonth() + "?");
      temperature = scan.nextDouble();

      month.setTemperature(temperature);

      total += temperature;
    }

    for (Month month : temperatures) {
      if (month.getTemperature() >= total / 6) {
        higherTemperatures.add(month.getTemperature());
        higherMonths.add(month.getMonth());
      }
    }

    System.out.println("As temperaturas acima da média são:");
    System.out.println(higherTemperatures);

    System.out.println("E os meses que ocorreu, são respectivamente:");
    System.out.println(higherMonths);

    scan.close();
  }

}

class Month {
  private String month;
  private Double temperature;

  public Month(String month) {
    this.month = month;
  }

  public String getMonth() {
    return month;
  }

  public Double getTemperature() {
    return temperature;
  }

  public void setTemperature(Double temperature) {
    this.temperature = temperature;
  }

  @Override
  public String toString() {
    return temperature + " - " + month;
  }

}
package edu.brunodemedeiros.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ListAndArray {

  public void catsExercises() {
    List<Cat> cats = new ArrayList<>() {
      {
        add(new Cat("Bob", "cian", 2));
        add(new Cat("It", "red", 4));
        add(new Cat("Bob", "black", 3));
      }
    };

    System.out.println("Imprimindo gatos.");
    System.out.println(cats);

    System.out.println();
    System.out.println("Ordenando gatos por nome.");
    Collections.sort(cats);
    System.out.println(cats);

    System.out.println();
    System.out.println("Ordenando gatos por idade.");
    Collections.sort(cats, new CompareAge());
    System.out.println(cats);

    System.out.println();
    System.out.println("Ordenando gatos por cor.");
    Collections.sort(cats, new CompareColor());
    System.out.println(cats);

    System.out.println();
    System.out.println("===\tOrdenando gatos por nome, cor e idade.\t===");
    Collections.sort(cats, new CompareNameColorAge());
    System.out.println(cats);
  }

  public static void scoreList() {
    List<Double> scores = new ArrayList<>();
    scores.add(7.23);
    scores.add(2.43);
    scores.add(3.4);
    scores.add(4.11);
    scores.add(6.33);
    scores.add(2.22);
    scores.add(3.53);
    scores.add(6.323);
    scores.add(4.24);

    Double total = 0d;

    for (Double score : scores) {
      total += score;
    }

    System.out.println(total);
    System.out.println(scores);

    List<Double> scores2 = new LinkedList<>(scores);

    System.out.println(scores2.get(0));
    System.out.println(scores);
    System.out.println(scores2);

  }

}

class Cat implements Comparable<Cat> {
  private String color;
  private String name;
  private int age;

  public Cat(String name, String color, int age) {
    this.color = color;
    this.name = name;
    this.age = age;
  }

  public String getColor() {
    return color;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public int compareTo(Cat cat) {
    return this.getName().compareToIgnoreCase(cat.getName());
  }

  @Override
  public String toString() {
    return "{name: "
        + name +
        ", color: "
        + color +
        ", age: "
        + age +
        "}";
  }

}

class CompareAge implements Comparator<Cat> {
  @Override
  public int compare(Cat cat1, Cat cat2) {
    return Integer.compare(cat1.getAge(), cat2.getAge());
  }
}

class CompareColor implements Comparator<Cat> {
  @Override
  public int compare(Cat cat1, Cat cat2) {
    return cat1.getColor().compareToIgnoreCase(cat2.getColor());
  }
}

class CompareNameColorAge implements Comparator<Cat> {
  @Override
  public int compare(Cat cat1, Cat cat2) {
    int name = cat1.getName().compareToIgnoreCase(cat2.getName());
    if (name != 0)
      return name;

    int color = cat1.getColor().compareToIgnoreCase(cat2.getColor());
    if (color != 0)
      return color;

    return Integer.compare(cat1.getAge(), cat2.getAge());
  }

}
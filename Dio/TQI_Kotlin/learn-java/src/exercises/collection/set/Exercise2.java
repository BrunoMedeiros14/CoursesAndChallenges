package exercises.collection.set;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
[x] a) Ordem de inserção;
[x] b) Ordem natural(nome);

[x] c) IDE;
[x] d) Ano de criação e nome;
[x] e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
*/
public class Exercise2 {
  public static void main(String[] args) {
    Set<FavoriteLanguage> languages = new LinkedHashSet<>() {
      {
        add(new FavoriteLanguage("Java", "Intellij", 1990));
        add(new FavoriteLanguage("Python", "VsCode", 2005));
        add(new FavoriteLanguage("Javascript", "VsCode", 2000));
      }
    };

    for (FavoriteLanguage language : languages) {
      System.out.println(language);
    }

    System.out.println("\nLista em ordem natural.");
    Set<FavoriteLanguage> naturalLanguages = new TreeSet<>(languages);
    for (FavoriteLanguage language : naturalLanguages) {
      System.out.println(language);
    }

    System.out.println("\nLista em ordem de IDE.");
    Set<FavoriteLanguage> ideLanguages = new TreeSet<>(new IdeComparator());
    ideLanguages.addAll(languages);
    for (FavoriteLanguage language : ideLanguages) {
      System.out.println(language);
    }

    System.out.println("\nLista em ordem do ano e de nome.");
    Set<FavoriteLanguage> yearAndNameLanguages = new TreeSet<>(new YearAndNameComparator());
    yearAndNameLanguages.addAll(languages);
    for (FavoriteLanguage language : yearAndNameLanguages) {
      System.out.println(language);
    }

    System.out.println("\nLista em ordem de nome, ano e IDE.");
    Set<FavoriteLanguage> nameYearAndIdeLanguages = new TreeSet<>(new NameYearAndIdeComparator());
    nameYearAndIdeLanguages.addAll(languages);
    for (FavoriteLanguage language : nameYearAndIdeLanguages) {
      System.out.println(language);
    }

  }
}

class FavoriteLanguage implements Comparable<FavoriteLanguage> {
  private String name;
  private String ide;
  private int year;

  public FavoriteLanguage(String name, String ide, int year) {
    this.name = name;
    this.ide = ide;
    this.year = year;
  }

  public String getName() {
    return name;
  }

  public String getIde() {
    return ide;
  }

  public int getYear() {
    return year;
  }

  @Override
  public String toString() {
    return "{ nome: " + name + ", IDE: " + ide + ", ano: " + year + "}";
  }

  @Override
  public int compareTo(FavoriteLanguage language) {

    return this.getName().compareTo(language.getName());
  }

}

class IdeComparator implements Comparator<FavoriteLanguage> {
  @Override
  public int compare(FavoriteLanguage language1, FavoriteLanguage language2) {
    return language1.getIde().compareTo(language2.getIde());
  }
}

class YearAndNameComparator implements Comparator<FavoriteLanguage> {
  @Override
  public int compare(FavoriteLanguage language1, FavoriteLanguage language2) {
    int year = Integer.compare(language1.getYear(), language2.getYear());
    if (year != 0)
      return year;
    return language1.getName().compareTo(language2.getName());
  }
}

class NameYearAndIdeComparator implements Comparator<FavoriteLanguage> {
  @Override
  public int compare(FavoriteLanguage language1, FavoriteLanguage language2) {
    int name = language1.getName().compareTo(language2.getName());
    if (name != 0)
      return name;
    int year = Integer.compare(language1.getYear(), language2.getYear());
    if (year != 0)
      return year;
    return language1.getIde().compareTo(language2.getIde());
  }
}

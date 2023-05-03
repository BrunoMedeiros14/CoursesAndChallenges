package exercises.collection.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
Crie uma conjunto contendo as cores do arco-íris e:
[x] a) Exiba todas as cores o arco-íris uma abaixo da outra;
[x] b) A quantidade de cores que o arco-íris tem;
[x] c) Exiba as cores em ordem alfabética;
[x] d) Exiba as cores na ordem inversa da que foi informada;
[x] e) Exiba todas as cores que começam com a letra ”v”;
[x] f) Remova todas as cores que não começam com a letra “v”;
[x] g) Limpe o conjunto;
[x] h) Confira se o conjunto está vazio;
 */
public class Exercise1 {
  public static void main(String[] args) {
    Set<String> rainbow = new LinkedHashSet<>();
    rainbow.add("Vermelho");
    rainbow.add("Laranja");
    rainbow.add("Amarelo");
    rainbow.add("Verde");
    rainbow.add("Azul");
    rainbow.add("Índigo");
    rainbow.add("Violeta");

    for (String color : rainbow)
      System.out.printf("%s ", color);
    System.out.printf("\nTem %s cores.\n===\n", rainbow.size());

    Set<String> naturalRaindow = new TreeSet<>(rainbow);

    System.out.printf("Listaem ordem alfabética:\n- %s\n", naturalRaindow);

    List<String> orderlyRaindow = new ArrayList<>(rainbow);
    Collections.reverse(orderlyRaindow);

    System.out.printf("Lista invertida:\n- %s\n", orderlyRaindow);

    Iterator<String> iterator = rainbow.iterator();

    while (iterator.hasNext()) {
      String actualColor = iterator.next();
      if (actualColor.charAt(0) == 'V')
        System.out.printf("%s ", actualColor);
      else {
        iterator.remove();
      }
    }

    System.out.printf("\nLista com cores removidas:\n- %s\n", rainbow);

    System.out.println("Limpando conjunto...");
    rainbow.clear();

    System.out.println(rainbow);

  }
}

package edu.brunodemedeiros.exercises;

public class Sobrecarga {
  public static void main(String[] args) {
    System.out.println("Calculando a área de um quadrado " + area(3.4));
    System.out.println("Calculando a área de um retângulo " + area(3.4, 4.3));
    System.out.println("Calculando a área de um trapézio " + area(3.4, 4.3, 5));
  }

  /**
   * Insira um valor para calcular a área de um quadrado.
   * 
   * @param lado
   * @return Área de um quadrado
   */
  public static double area(double lado) {
    return lado * lado;
  }

  /**
   * Insira dois valores para calcular a área de um retângulo
   * 
   * @param base
   * @param altura
   * @return Área de um retângulo
   */
  public static double area(double base, double altura) {
    return base * altura;
  }

  /**
   * Insira 3 valores para retornar a área de um trapézio
   * 
   * @param baseMenor
   * @param baseMaior
   * @param altura
   * @return retorna a área de um trapézio
   */
  public static double area(double baseMenor, double baseMaior, double altura) {
    return (baseMenor + baseMaior) * altura;
  }

}

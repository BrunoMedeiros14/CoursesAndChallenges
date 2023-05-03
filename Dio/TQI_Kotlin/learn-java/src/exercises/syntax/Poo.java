package exercises.syntax;

/**
 * Classe Carro.
 */
class Poo {
  public static void main(String[] args) {
    Car car = new Car("black", "Gol");

    System.out.println(car);

  }
}

class Car {
  String color;
  private String model;

  int tankCapacity;

  Car(String model) {
    this.model = model;
  }

  Car(String color, String model) {
    this.color = color;
    this.model = model;
  }

  public String getModel() {
    return this.model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setTankCapacity(int tankCapacity) {
    this.tankCapacity = tankCapacity;
  }

  public double getFullTankPrice(double tankPrice) {
    double totalPrice = tankPrice * tankCapacity;
    return totalPrice;
  }

  @Override
  public String toString() {
    return "O carro é do modelo " + this.model +
        ", na cor " + this.color +
        " e tem o tanque com capacidade de " + this.tankCapacity +
        " litros";
  }
}
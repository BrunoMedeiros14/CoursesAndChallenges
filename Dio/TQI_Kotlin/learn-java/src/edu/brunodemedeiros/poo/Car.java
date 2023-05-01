package edu.brunodemedeiros.poo;

/**
 * Classe Carro.
 */
class Car {
  String color;
  String model;

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
}
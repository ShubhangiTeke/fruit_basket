package com.app.fruits;

import java.util.Scanner;

abstract class Fruit {
    private String name;
    private String color;
    private double weight;
    private boolean isFresh;

    public Fruit(String name, String color, double weight, boolean isFresh) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.isFresh = isFresh;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isFresh() {
        return isFresh;
    }

    public void setFresh(boolean fresh) {
        isFresh = fresh;
    }

    public abstract String taste();

    @Override
    public String toString() {
        return "Name : " + name + "\nColor : " + color + "\nWeight : " + weight;
    }
}

class Apple extends Fruit {

    public Apple(String name, double weight, String color) {
        super(name, color, weight, true);
    }

    @Override
    public String taste() {
        return "Sweet and Sour";
    }
}

class Mango extends Fruit {

    public Mango(String name, double weight, String color) {
        super(name, color, weight, true);
    }

    @Override
    public String taste() {
        return "Sweet";
    }
}

class Orange extends Fruit {

    public Orange(String name, double weight, String color) {
        super(name, color, weight, true);
    }

    @Override
    public String taste() {
        return "Sour";
    }
}

public class Fruitbasket {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Basket Size : ");
        int size = sc.nextInt();

        Fruit[] basket = new Fruit[size];
        int counter = 0;
        int choice;

        do {

            System.out.println("\n0. Exit");
            System.out.println("1. Add Mango");
            System.out.println("2. Add Orange");
            System.out.println("3. Add Apple");
            System.out.println("4. Display Names");
            System.out.println("5. Display Fresh Fruits");
            System.out.println("6. Display Taste of Stale Fruits");
            System.out.println("7. Mark Fruit Stale");
            System.out.println("8. Mark All Sour Fruits Stale");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:
                if (counter == size) {
                    System.out.println("Basket Full");
                } else {
                    System.out.print("Enter Name Weight Color : ");
                    basket[counter++] = new Mango(sc.next(), sc.nextDouble(), sc.next());
                }
                break;

            case 2:
                if (counter == size) {
                    System.out.println("Basket Full");
                } else {
                    System.out.print("Enter Name Weight Color : ");
                    basket[counter++] = new Orange(sc.next(), sc.nextDouble(), sc.next());
                }
                break;

            case 3:
                if (counter == size) {
                    System.out.println("Basket Full");
                } else {
                    System.out.print("Enter Name Weight Color : ");
                    basket[counter++] = new Apple(sc.next(), sc.nextDouble(), sc.next());
                }
                break;

            case 4:
                for (Fruit f : basket) {
                    if (f != null)
                        System.out.println(f.getName());
                }
                break;

            case 5:
                for (Fruit f : basket) {
                    if (f != null && f.isFresh()) {
                        System.out.println(f);
                        System.out.println("Taste : " + f.taste());
                    }
                }
                break;

            case 6:
                for (Fruit f : basket) {
                    if (f != null && !f.isFresh()) {
                        System.out.println(f.taste());
                    }
                }
                break;

            case 7:
                System.out.print("Enter Index : ");
                int index = sc.nextInt();

                if (index >= 0 && index < counter) {
                    basket[index].setFresh(false);
                    System.out.println("Fruit Marked Stale");
                } else {
                    System.out.println("Invalid Index");
                }
                break;

            case 8:
                for (Fruit f : basket) {
                    if (f != null && f.taste().equalsIgnoreCase("Sour")) {
                        f.setFresh(false);
                    }
                }
                System.out.println("All Sour Fruits Marked Stale");
                break;

            case 0:
                System.out.println("Thank You");
                break;

            default:
                System.out.println("Invalid Choice");
            }

        } while (choice != 0);

        sc.close();
    }
}
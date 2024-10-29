package demo.src.test.java.lab2;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String name = scanner.nextLine();
    int age = Integer.parseInt(scanner.nextLine());

    greetUser(name, age);
  }

  public static String greetUser(String name, int age) {
    return String.format("Hello, %s! You are %d years old.", name, age);
  }
}
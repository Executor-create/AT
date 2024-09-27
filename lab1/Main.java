package lab1;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String name = scanner.nextLine();
    int age = Integer.parseInt(scanner.nextLine());

    System.out.printf("Hello, %s! You are %d years old.%n", name, age);
  }
}
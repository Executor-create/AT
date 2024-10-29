package demo.src.test.java.lab3;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the size of the first array: ");
    int size1 = sc.nextInt();
    int[] arr1 = new int[size1];
    System.out.println("Enter elements of the first array: ");
    for (int i = 0; i < size1; i++) {
      arr1[i] = sc.nextInt();
    }

    System.out.print("Enter the size of the second array: ");
    int size2 = sc.nextInt();
    int[] arr2 = new int[size2];
    System.out.println("Enter elements of the second array: ");
    for (int i = 0; i < size2; i++) {
      arr2[i] = sc.nextInt();
    }

    Set<Integer> intersection = findIntersection(arr1, arr2);
    System.out.println("Intersection: " + intersection);

    HashMap<Integer, String> map = new HashMap<>();
    for (int num : intersection) {
      map.put(num, "Value" + num);
    }
    performHashMapOperations(map);

    simulateNumberFormatException(sc);
  }

  public static Set<Integer> findIntersection(int[] arr1, int[] arr2) {
    Set<Integer> set = new HashSet<>();
    Set<Integer> intersection = new HashSet<>();

    for (int num : arr1)
      set.add(num);
    for (int num : arr2) {
      if (set.contains(num))
        intersection.add(num);
    }
    return intersection;
  }

  public static void performHashMapOperations(HashMap<Integer, String> map) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Add a key (integer) to the map: ");
    int keyToAdd = sc.nextInt();
    System.out.print("Add a value (string) to the map: ");
    String valueToAdd = sc.next();
    map.put(keyToAdd, valueToAdd);

    System.out.print("Enter a key to remove from the map: ");
    int keyToRemove = sc.nextInt();
    map.remove(keyToRemove);

    System.out.print("Check if a key exists in the map: ");
    int keyToCheck = sc.nextInt();
    System.out.println("Key " + keyToCheck + (map.containsKey(keyToCheck) ? " exists." : " does not exist."));

    System.out.print("Enter a key to find its value: ");
    int keyToFind = sc.nextInt();
    System.out.println("Value: " + map.getOrDefault(keyToFind, "No value found."));

    System.out.println("All keys and values in the map:");
    for (Map.Entry<Integer, String> entry : map.entrySet()) {
      System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
    }
  }

  public static void simulateNumberFormatException(Scanner sc) {
    try {
      System.out.print("Enter a string to convert to an integer: ");
      int number = Integer.parseInt(sc.next());
      System.out.println("The number is: " + number);
    } catch (NumberFormatException e) {
      System.out.println("Error: Invalid number format. Please enter a valid integer.");
    }
  }
}

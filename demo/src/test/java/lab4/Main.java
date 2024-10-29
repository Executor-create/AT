package demo.src.test.java.lab4;

import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;

class WorkerThread extends Thread {
  private final CountDownLatch latch;
  private final String name;

  public WorkerThread(CountDownLatch latch, String name) {
    this.latch = latch;
    this.name = name;
  }

  @Override
  public void run() {
    try {
      System.out.println(name + " is working...");
      Thread.sleep((int) (Math.random() * 1000));
      System.out.println(name + " has finished.");
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    } finally {
      latch.countDown();
    }
  }
}

class CustomClass {
  public int add(int a, int b) {
    return a + b;
  }
}

interface MyInterface {
  void performAction();
}

class ActionClass implements MyInterface {
  public void performAction() {
    System.out.println("Action performed!");
  }
}

public class Main {
  public static void main(String[] args) {
    int numberOfThreads = 3;
    CountDownLatch latch = new CountDownLatch(numberOfThreads);

    for (int i = 1; i <= numberOfThreads; i++) {
      new WorkerThread(latch, "Worker " + i).start();
    }

    try {
      latch.await();
      System.out.println("All workers have finished!");
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    try {
      CustomClass customObject = new CustomClass();
      Method addMethod = customObject.getClass().getMethod("add", int.class, int.class);
      Object result = addMethod.invoke(customObject, 5, 10);
      System.out.println("Result of add(5, 10): " + result);
    } catch (Exception e) {
      e.printStackTrace();
    }

    invokeInterfaceMethod(new ActionClass());
  }

  public static <T extends MyInterface> void invokeInterfaceMethod(T obj) {
    try {
      obj.performAction();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

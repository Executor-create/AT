package demo.src.test.java.task8;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Main {
  @Test(dataProvider = "greetUserData")
  public void testGreetUser(String name, int age, String expected) {
    String result = Main.greetUser(name, age);
    Assert.assertEquals(result, expected);
  }

  @Test(dataProvider = "greetUserData")
  public void testGreetUserWithDifferentParameters(String name, int age, String expected) {
    String result = Main.greetUser(name, age);
    Assert.assertEquals(result, expected);
  }

  @Test(dataProvider = "greetUserData")
  public void testGreetUserWithAnotherSetOfParameters(String name, int age, String expected) {
    String result = Main.greetUser(name, age);
    Assert.assertEquals(result, expected);
  }

  @DataProvider(name = "greetUserData")
  public Object[][] provideData() {
    return new Object[][] {
        { "Alice", 30, "Hello, Alice! You are 30 years old." },
        { "Bob", 25, "Hello, Bob! You are 25 years old." },
        { "Charlie", 20, "Hello, Charlie! You are 20 years old." }
    };
  }
}

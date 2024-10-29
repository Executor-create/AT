package task11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Task11 {
  WebDriver driver;

  @Test
  void uiTest() {
    System.setProperty("webdriver.chrome.driver",
        "/home/executor/projects/AT/demo/driver/chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://demoqa.com/register");
    System.out.println(driver.getCurrentUrl());
  }

  // @BeforeTest
  // void setup() {
  // ChromeDriverManager.getInstance().setup();
  // driver = new ChromeDriver();
  // }
}

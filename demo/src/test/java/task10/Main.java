package demo.src.test.java.task10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Main {
  private WebDriver driver;

  @BeforeClass
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @Test
  public void testBookStoreElements() {
    driver.get("https://demoqa.com/profile");

    WebElement userName = driver.findElement(By.id("userName"));
    WebElement userEmail = driver.findElement(By.id("userEmail"));
    WebElement logoutButton = driver.findElement(By.id("submit"));

    userName.sendKeys("Test User");
    userEmail.sendKeys("testuser@example.com");
    logoutButton.click();

    Assert.assertTrue(userName.isDisplayed(), "User Name field is not displayed");
    Assert.assertTrue(userEmail.isDisplayed(), "User Email field is not displayed");
    Assert.assertTrue(logoutButton.isDisplayed(), "Logout button is not displayed");
  }

  @AfterClass
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}

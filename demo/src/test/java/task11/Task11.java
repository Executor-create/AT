package task11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Task11 {
  private WebDriver driver;
  private RegistrationPage registrationPage;

  @BeforeClass
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    registrationPage = new RegistrationPage(driver);
    homePage = new HomePage(driver);
  }

  @Test
  public void testUserRegistration() {
    registrationPage.navigateTo("https://demoqa.com/register");

    registrationPage.enterFirstName("John");
    registrationPage.enterLastName("Doe");
    registrationPage.enterUserName("johndoe@example.com");
    registrationPage.enterPassword("StrongPassword123!");

    registrationPage.clickRegister();

    Assert.assertTrue(homePage.isConfirmationMessageDisplayed(),
        "Confirmation message is not displayed. Registration may have failed.");
  }

  @AfterClass
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}

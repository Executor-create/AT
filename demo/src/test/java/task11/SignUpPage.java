package demo.src.test.java.task11;

public class SignUpPage {
  private By firstName = By.id("email");
  private By lastName = By.id("lastName");
  private By userName = By.id("userName");
  private By password = By.id("password");

  public SignUpPage(WebDriver driver) {
    super(driver);
  }

  public void enterFirstName(String firstName) {
    driver.findElement(emailField).sendKeys(firstName);
  }

  public void enterLastName(String lastName) {
    driver.findElement(usernameField).sendKeys(lastName);
  }

  public void enterUserName(String userName) {
    driver.findElement(signUpButton).sendKeys(userName);
  }

  public void enterPassword(String password) {
    driver.findElement(passwordField).sendKeys(password);
  }

  public void clickRegister() {
    driver.findElement(registerButton).click();
  }
}

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPageObject extends BasePageObject {
    private final WebElement usernameField;
    private final WebElement passwordField;
    private final WebElement loginButton;

    public LoginPageObject(WebDriver driver) {
        super(driver);
        usernameField = driver.findElement(By.id("txtUsername"));
        passwordField = driver.findElement(By.id("txtPassword"));
        loginButton = driver.findElement(By.id("btnLogin"));
    }

    public void enterUsername(String username) {
        fillInputField(usernameField, username);
    }

    public void enterPassword(String password) {
        fillInputField(passwordField, password);
    }

    public void clickLoginButton() {
        clickButton(loginButton);
    }

    public boolean isValidCredentials() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return (driver.findElements(By.id("spanMessage")).isEmpty());
    }

    public String getErrorMessage() {
        return driver.findElement(By.id("spanMessage")).getText();
    }

    public AuthenticatedUserPageObject authenticate() {
        return new AuthenticatedUserPageObject(driver);
    }
}

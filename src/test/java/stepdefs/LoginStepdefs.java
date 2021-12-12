package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.AuthenticatedUserPageObject;
import pageobjects.LoginPageObject;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class LoginStepdefs {
    public WebDriver driver;
    public LoginPageObject pageObject;

    @Before("@Login")
    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I am filling credentials at the login page")
    public void iAmFillingCredentialsAtTheLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        pageObject = new LoginPageObject(driver);
    }

    @Given("I entered {string} in the username field")
    public void iEnteredInTheUsernameField(String username) {
        pageObject.enterUsername(username);
    }

    @And("I entered {string} in the password field")
    public void iEnteredInThePasswordField(String password) {
        pageObject.enterPassword(password);
    }

    @When("I click on the \"Login\" button")
    public void iClickOnTheButton() {
        pageObject.clickLoginButton();
    }

    @And("my credentials is valid")
    public void myCredentialsIsValid() {
        assertTrue(pageObject.isValidCredentials());
    }

    @Then("I will be successfully authenticated")
    public void iWillBeSuccessfullyAuthenticated() {
        assertTrue(pageObject.authenticate() instanceof AuthenticatedUserPageObject);
    }

    @And("my username or password is invalid")
    public void myUsernameOrAndPasswordIsInvalid() {
        assertFalse(pageObject.isValidCredentials());
    }

    @Then("I will be see error message {string}")
    public void iWillBeSeeErrorMessage(String errorMessage) {
        assertEquals(pageObject.getErrorMessage(), errorMessage);
    }

    @Given("I left username field empty")
    public void iLeftUsernameFieldEmpty() {
        pageObject.enterUsername("");
    }

    @Given("I left password field empty")
    public void iLeftPasswordFieldEmpty() {
        pageObject.enterPassword("");
    }

    @And("username field is not empty")
    public void usernameFieldIsNotEmpty() {
        pageObject.enterUsername("SomeUsername");
    }

    @After("@Login")
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment("Screenshot",
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
        pageObject.quit();
    }
}

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
import pageobjects.AddUserPageObject;
import pageobjects.LoginPageObject;
import pageobjects.UsersPageObject;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AddUserStepdefs {
    public WebDriver driver;
    private AddUserPageObject pageObject;
    private int idOffset;

    @Before(value = "@AddUser", order = 0)
    public void initWebDriver() {
        idOffset = Integer.valueOf(System.getProperty("idOffset"));
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @Before(value = "@AddUser", order = 1)
    public void authenticateUserAndGoToCreateUserPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        LoginPageObject loginPage = new LoginPageObject(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/admin/saveSystemUser");
        pageObject = new AddUserPageObject(driver);
    }

    @Given("I am filling user data at the \"Create user\" page")
    public void iAmFillingUserDataAtTheCreateUserPage() {
    }

    @And("I filled all fields")
    public void iCorrectlyFilledAllFields(List<Map<String, String>> table) {
        Map<String, String> userData = table.get(0);
        pageObject.selectUserRole(userData.get("User Role"));
        pageObject.enterEmployeeName(userData.get("Employee Name"));
        pageObject.enterUsername(userData.get("Username") + idOffset);
        pageObject.selectStatus(userData.get("Status"));
        pageObject.enterPassword(userData.get("Password"));
        pageObject.enterConfirmPassword(userData.get("Confirm Password"));
    }

    @And("field data is valid")
    public void fieldDataIsValid() {
        assertTrue(pageObject.isValidData());
    }

    @When("I click on \"Save\" button")
    public void iClickOnSaveButton() {
        pageObject.clickSaveButton();
    }

    @Then("user successfully creates")
    public void userSuccessfullyCreates() {
        assertTrue(pageObject.isValidData());
        assertTrue(pageObject.saveUser() instanceof UsersPageObject);
    }

    @And("field data is invalid")
    public void fieldDataIsInvalid() {
        assertTrue(!pageObject.isValidData());
    }

    @Then("I will see error message")
    public void iWillSeeErrorMessage() {
        assertTrue(pageObject.isThereErrorMessage());
    }

    @After("@AddUser")
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment("Screenshot",
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
        pageObject.quit();
    }
}

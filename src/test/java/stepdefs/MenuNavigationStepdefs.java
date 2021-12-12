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

import static org.junit.Assert.assertEquals;

public class MenuNavigationStepdefs {
    public WebDriver driver;
    private AuthenticatedUserPageObject pageObject;

    @Before(value = "@MenuNavigation", order = 0)
    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @Before(value = "@MenuNavigation", order = 1)
    public void authenticateUser() {
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        LoginPageObject loginPage = new LoginPageObject(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        pageObject = loginPage.authenticate();
    }

    @Before(value = "@MenuNavigation and @AtAdminPage", order = 2)
    public void navigateToAdminPage() {
        pageObject = pageObject.getMenu().goToAdminPage();
    }

    @Given("I am at the {string} page")
    public void iAmAtThePage(String pageName) {
        assertEquals(pageObject.getPageName(), pageName);
    }

    @When("I click on the {string} button at the first/third menu level")
    public void iClickOnTheButtonAtTheFirstOrThirdMenuLevel(String buttonName) {
        pageObject = pageObject.getMenu().goToPageByMenuButtonName(buttonName);
    }

    @Then("I will be redirected to {string} page")
    public void iWillBeRedirectedToPage(String pageName) {
        assertEquals(pageObject.getPageName(), pageName);
    }

    @And("I hover mouse over {string} menu button")
    public void iHoverMouseOverMenuButton(String buttonName) {
        pageObject.getMenu().hoverMouseOverButtonByName(buttonName);
    }

    @After("@MenuNavigation")
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment("Screenshot",
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
        pageObject.quit();
    }
}

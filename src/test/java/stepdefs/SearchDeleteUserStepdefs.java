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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LoginPageObject;
import pageobjects.UsersPageObject;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.Assert.*;

public class SearchDeleteUserStepdefs {
    public WebDriver driver;
    private UsersPageObject pageObject;
    private String username;
    private int idOffset;

    @Before(value = "@SearchByUsername or @DeleteUser", order = 0)
    public void initWebDriver() {
        idOffset = Integer.valueOf(System.getProperty("idOffset"));
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @Before(value = "@SearchByUsername or @DeleteUser", order = 1)
    public void authenticateUserAndGoToCreateUserPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        LoginPageObject loginPage = new LoginPageObject(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
        pageObject = new UsersPageObject(driver);
    }

    @Given("I am at the users page")
    public void iAmAtTheUsersPage() {
        assertEquals("Users", pageObject.getPageName());
    }

    @And("I entered {string} in the username search field")
    public void iEnteredInTheUsernameSearchField(String username) {
        pageObject.enterSearchUsername(username + idOffset);
        this.username = username + idOffset;
    }

    @When("I click \"Search\" button")
    public void iClickButton() {
        pageObject = pageObject.clickSearchButton();
    }

    @Then("I will see one result with specified username")
    public void iWillSeeOneResultWithSpecifiedUsername() {
        List<WebElement> users = pageObject.getUsersTable();
        assertEquals(1, users.size());
        assertEquals(this.username, pageObject.getUsernameFromTableRow(users.get(0)));
    }

    @Then("I will see no results")
    public void iWillSeeNoResults() {
        List<WebElement> users = pageObject.getUsersTable();
        assertEquals(0, users.size());
    }

    @And("I want to select user row with {string} username")
    public void iWantToSelectUserRowWithUsername(String username) {
        this.username = username + idOffset;
    }

    @And("this user exists in table")
    public void thisUserExistsInTable() {
        pageObject.findRowByUsername(this.username);
    }

    @When("I click on the checkbox")
    public void iClickOnTheCheckbox() {
        pageObject.selectUserByUsername(this.username);
    }

    @Then("row with this user will be selected")
    public void rowWithThisUserWillBeSelected() {
        assertTrue(pageObject.isRowSelected(pageObject.findRowByUsername(this.username)));
    }

    @And("I want to delete user with {string} username")
    public void iWantToDeleteUserWithUsername(String username) {
        this.username = username + idOffset;
    }

    @And("this user exists at current table")
    public void thisUserExistsAtCurrentTable() {
        thisUserExistsInTable();
    }

    @And("I selected row with this user")
    public void iSelectedRowWithThisUser() {
        iClickOnTheCheckbox();
    }

    @When("I click on delete button")
    public void iClickOnDeleteButton() {
        pageObject.clickDeleteButton();
    }

    @And("I confirmed deleting")
    public void iConfirmedDeleting() {
        pageObject = pageObject.deleteUser();
    }

    @Then("user successfully removes from table and system")
    public void userSuccessfullyRemovesFromTableAndSystem() {
        assertThrows(IllegalArgumentException.class, () -> pageObject.findRowByUsername(this.username));
    }

    @After("@SearchByUsername or @DeleteUser")
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment("Screenshot",
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
        pageObject.quit();
    }
}

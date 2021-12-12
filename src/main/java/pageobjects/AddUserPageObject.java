package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AddUserPageObject extends AuthenticatedUserPageObject {
    private final WebElement userRoleField;
    private final WebElement employeeNameField;
    private final WebElement usernameField;
    private final WebElement statusField;
    private final WebElement passwordField;
    private final WebElement confirmPasswordField;
    private final WebElement saveButton;

    public AddUserPageObject(WebDriver driver) {
        super(driver);
        userRoleField = driver.findElement(By.id("systemUser_userType"));
        employeeNameField = driver.findElement(By.id("systemUser_employeeName_empName"));
        usernameField = driver.findElement(By.id("systemUser_userName"));
        statusField = driver.findElement(By.id("systemUser_status"));
        passwordField = driver.findElement(By.id("systemUser_password"));
        confirmPasswordField = driver.findElement(By.id("systemUser_confirmPassword"));
        saveButton = driver.findElement(By.id("btnSave"));
    }

    public void selectUserRole(String userRole) {
        switch (userRole) {
            case "admin":
                new Select(userRoleField).selectByValue("1");
                break;
            case "ESS":
                new Select(userRoleField).selectByValue("2");
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void enterEmployeeName(String employeeName) {
        fillInputField(employeeNameField, employeeName);
    }

    public void enterUsername(String username) {
        fillInputField(usernameField, username);
    }

    public void selectStatus(String status) {
        switch (status) {
            case "Enabled":
                new Select(statusField).selectByValue("1");
                break;
            case "Disabled":
                new Select(statusField).selectByValue("0");
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void enterPassword(String password) {
        fillInputField(passwordField, password);
    }

    public void enterConfirmPassword(String password) {
        fillInputField(confirmPasswordField, password);
    }

    public boolean isValidData() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return (driver.findElements(By.xpath("//input[contains(@class,'validation-error')]")).isEmpty());
    }

    public void clickSaveButton() {
        clickButton(saveButton);
    }


    public UsersPageObject saveUser() {
        return new UsersPageObject(driver);
    }

    public boolean isThereErrorMessage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return (!driver.findElements(By.xpath("//input[contains(@class,'validation-error')]")).isEmpty());
    }
}

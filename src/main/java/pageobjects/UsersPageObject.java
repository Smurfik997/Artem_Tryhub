package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UsersPageObject extends AuthenticatedUserPageObject {
    private final WebElement addUserButton;
    private final WebElement deleteUserButton;
    private final WebElement deleteUserConfirmButton;
    private final WebElement searchUsernameField;
    private final WebElement searchButton;
    private final WebElement resetButton;
    private final WebElement resultTable;

    public UsersPageObject(WebDriver driver) {
        super(driver);
        pageName = "Users";
        addUserButton = driver.findElement(By.id("btnAdd"));
        deleteUserButton = driver.findElement(By.id("btnDelete"));
        deleteUserConfirmButton = driver.findElement(By.id("dialogDeleteBtn"));
        searchUsernameField = driver.findElement(By.id("searchSystemUser_userName"));
        searchButton = driver.findElement(By.id("searchBtn"));
        resetButton = driver.findElement(By.id("resetBtn"));
        resultTable = driver.findElement(By.id("resultTable")).findElement(By.tagName("tbody"));
    }

    public void enterSearchUsername(String username) {
        fillInputField(searchUsernameField, username);
    }

    public AddUserPageObject goToAddUserPage() {
        clickButton(addUserButton);
        return new AddUserPageObject(driver);
    }

    public UsersPageObject clickSearchButton() {
        clickButton(searchButton);
        return new UsersPageObject(driver);
    }

    public List<WebElement> getUsersTable() {
        List<WebElement> table = resultTable.findElements(By.tagName("tr"));
        if (!table.isEmpty() && table.get(0).getText().equals("No Records Found")) {
            return new ArrayList<>();
        } else {
            return table;
        }
    }

    public String getUsernameFromTableRow(WebElement tableRow) {
        return tableRow.findElements(By.tagName("td")).get(1).getText();
    }

    public UsersPageObject clickResetButton() {
        clickButton(resetButton);
        return new UsersPageObject(driver);
    }

    public WebElement findRowByUsername(String username) {
        List<WebElement> users = resultTable.findElements(
                By.xpath("//tr[td[a[contains(text(),'" + username + "')]]]")
        );

        if (users.size() == 1) {
            return users.get(0);
        } else {
            throw new IllegalArgumentException("Invalid username");
        }
    }

    public void selectUserByUsername(String username) {
        findRowByUsername(username).findElement(By.tagName("input")).click();
    }

    public boolean isRowSelected(WebElement row) {
        return row.findElement(By.tagName("input")).isSelected();
    }

    public void clickDeleteButton() {
        clickButton(deleteUserButton);
    }

    public UsersPageObject deleteUser() {
        clickButton(deleteUserConfirmButton);
        return new UsersPageObject(driver);
    }
}

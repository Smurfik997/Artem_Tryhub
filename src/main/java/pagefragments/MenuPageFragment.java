package pagefragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobjects.AdminPageObject;
import pageobjects.AuthenticatedUserPageObject;
import pageobjects.UsersPageObject;

public class MenuPageFragment {
    private final WebDriver driver;
    private final WebElement mainMenu;

    public MenuPageFragment(WebDriver driver) {
        this.driver = driver;
        this.mainMenu = driver.findElement(By.id("mainMenu"));
    }

    public WebElement getButtonByText(String buttonText) {
        return mainMenu.findElement(By.linkText(buttonText));
    }

    public AuthenticatedUserPageObject goToPageByMenuButtonName(String buttonName) {
        switch (buttonName) {
            case "Admin":
                return goToAdminPage();
            case "Users":
                return goToUsersPage();
            default:
                throw new IllegalArgumentException("Invalid menu button name");
        }
    }

    public void hoverMouseOverButtonByName(String buttonName) {
        new Actions(driver).moveToElement(getButtonByText(buttonName)).perform();
    }

    // first menu level
    public WebElement getAdminButton() {
        return mainMenu.findElement(By.id("menu_admin_viewAdminModule"));
    }
    public AuthenticatedUserPageObject goToAdminPage() {
        getAdminButton().click();
        return new AdminPageObject(driver);
    }

    // second menu level
    public WebElement getUserManagementButton() {
        return mainMenu.findElement(By.id("menu_admin_UserManagement"));
    }

    // third menu level
    public WebElement getUsersButton() {
        return mainMenu.findElement(By.id("menu_admin_viewSystemUsers"));
    }

    public UsersPageObject goToUsersPage() {
        getUsersButton().click();
        return new UsersPageObject(driver);
    }
}

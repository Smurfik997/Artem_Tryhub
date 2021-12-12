package pageobjects;

import org.openqa.selenium.WebDriver;

public class AdminPageObject extends AuthenticatedUserPageObject {
    public AdminPageObject(WebDriver driver) {
        super(driver);
        pageName = "Admin";
    }
}

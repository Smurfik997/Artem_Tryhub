package pageobjects;

import org.openqa.selenium.WebDriver;
import pagefragments.MenuPageFragment;

public class AuthenticatedUserPageObject extends BasePageObject {
    private final MenuPageFragment menu;
    protected String pageName;

    public AuthenticatedUserPageObject(WebDriver driver) {
        super(driver);
        menu = new MenuPageFragment(driver);
        pageName = "Authenticated user";
    }

    public MenuPageFragment getMenu() {
        return menu;
    }

    public String getPageName() {
        return pageName;
    }
}

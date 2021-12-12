package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageObject {
    protected final WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    };

    public void clickButton(WebElement button) {
        button.click();
    }

    public void fillInputField(WebElement input, String text) {
        input.sendKeys(text);
    }

    public String getInputFieldText(WebElement input) {
        return input.getAttribute("value");
    }

    public boolean isEmptyField(WebElement field) {
        return getInputFieldText(field).isEmpty();
    }

    public void quit() {
        driver.quit();
    }
}

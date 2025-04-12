package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Initialize PageFactory elements in child classes
        PageFactory.initElements(driver, this);
    }

    // Common reusable methods
    public void enterText(org.openqa.selenium.WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(org.openqa.selenium.WebElement element) {
        element.click();
    }

    public abstract String getPageTitle();
}
package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "welcome")
    private WebElement welcomeMessage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeText() {
        return welcomeMessage.getText();
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }
}

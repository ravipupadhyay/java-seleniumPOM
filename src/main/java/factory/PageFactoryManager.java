package factory;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class PageFactoryManager {

    public static LoginPage getLoginPage(WebDriver driver) {
        return new LoginPage(driver);
    }

    public static HomePage getHomePage(WebDriver driver) {
        return new HomePage(driver);
    }
}
package tests;

import base.BaseTest;
import factory.PageFactoryManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExcelReader;
import utils.LoggerUtil;
import utils.RetryAnalyzer;

import java.util.List;

public class LoginTest extends BaseTest {

    // 1) DataProvider using Excel
    @DataProvider(name = "loginDataExcel")
    public Object[][] getLoginDataFromExcel() {
        String filePath = "src\\main\\resources\\testdata.xlsx";
        String sheetName = "LoginData";
        List<String[]> excelData = ExcelReader.getExcelData(filePath, sheetName);

        // Convert List<String[]> to a 2D Object array
        Object[][] dataArray = new Object[excelData.size()][excelData.get(0).length];
        for (int i = 0; i < excelData.size(); i++) {
            dataArray[i] = excelData.get(i);
        }
        return dataArray;
    }

    // 2) DataProvider using config.properties
    @DataProvider(name = "loginDataConfig")
    public Object[][] getLoginDataFromConfig() {
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        return new Object[][] {
                { username, password }
        };
    }

    @Test(dataProvider = "loginDataExcel", retryAnalyzer = RetryAnalyzer.class)
    public void testLoginWithExcel(String username, String password) {
        LoggerUtil.info("Starting Login Test with Excel Data: " + username + " / " + password);

        LoginPage loginPage = PageFactoryManager.getLoginPage(driver);
        HomePage homePage = loginPage.login(username, password);

        String welcomeText = homePage.getWelcomeText();
        LoggerUtil.info("Asserting welcome text...");
        Assert.assertTrue(welcomeText.contains(username), "Welcome text does not contain username!");
    }

    @Test(dataProvider = "loginDataConfig", retryAnalyzer = RetryAnalyzer.class)
    public void testLoginWithConfig(String username, String password) {
        LoggerUtil.info("Starting Login Test with Config: " + username + " / " + password);

        LoginPage loginPage = PageFactoryManager.getLoginPage(driver);
        HomePage homePage = loginPage.login(username, password);

        String welcomeText = homePage.getWelcomeText();
        LoggerUtil.info("Asserting welcome text...");
        Assert.assertTrue(welcomeText.contains(username), "Welcome text does not contain username!");
    }
}

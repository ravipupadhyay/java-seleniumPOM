package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ConfigReader;
import utils.ExtentManager;
import utils.LoggerUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;

@Listeners // Not strictly required if specifying in testng.xml
public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void beforeSuite() {
        // Initialize Extent Report once per suite
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void setUp() {
        LoggerUtil.info("Setting up WebDriver");
        String browser = ConfigReader.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } 
        // else if - can handle more browsers

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        String url = ConfigReader.getProperty("url");
        driver.get(url);

        // Start an Extent Test for each @Test method
        test = extent.createTest(getClass().getSimpleName());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            LoggerUtil.info("Tearing down WebDriver");
            driver.quit();
        }
    }

    @AfterSuite
    public void afterSuite() {
        // Generate the Extent report
        if (extent != null) {
            extent.flush();
        }
    }
}

package listeners;


import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.LoggerUtil;
import utils.ScreenshotUtil;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        LoggerUtil.info("Test Started: " + result.getName());
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LoggerUtil.info("Test Passed: " + result.getName());
        test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LoggerUtil.error("Test Failed: " + result.getName());
        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());

        // Capture Screenshot
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
        test.addScreenCaptureFromPath(screenshotPath);

        LoggerUtil.error("Screenshot saved at: " + screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LoggerUtil.warn("Test Skipped: " + result.getName());
        test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onStart(ITestContext context) {
        LoggerUtil.info("=== Test Suite Started: " + context.getName() + " ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        LoggerUtil.info("=== Test Suite Finished: " + context.getName() + " ===");
        // Flush the report to write all logs to ExtentReport
        if (extent != null) {
            extent.flush();
        }
    }
}
package utils;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public void onTestFailure(ITestResult result) {

        String testname = result.getMethod().getMethodName();

        // Get driver from the test class instance
        Object currentClass = result.getInstance();
        BaseTest baseTest = ((BaseTest) currentClass);
        WebDriver driver = baseTest.driver;
        String screenshotPath = ScreenshotUtils.takeScreenshot(driver, testname);
        ExtentTest test = getBaseTest(result).test;

        test.log(Status.FAIL, "test failure : " + result.getThrowable());
        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            test.log(Status.WARNING, "Screenshot could not be attached");
        }

    }


    public void onTestSuccess(ITestResult result) {
        ExtentTest test = getBaseTest(result).test;
        test.log(Status.PASS, "Test Passed");
    }


    public void onTestSkipped(ITestResult result) {
        ExtentTest test = getBaseTest(result).test;
        test.log(Status.SKIP, "Test Skipped");
    }

    private BaseTest getBaseTest(ITestResult iTestResult) {
        Object currentClass = iTestResult.getInstance();
        return (BaseTest) currentClass;
    }
}
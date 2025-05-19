package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverManager;
import org.testng.annotations.*;
import utils.ExtentManager;

import java.time.Duration;

public class BaseTest {
      public WebDriver driver;
      protected static ExtentReports extent;
      public ExtentTest test;

      @BeforeSuite
      public void startReport(){
            extent = ExtentManager.getInstance();
      }

    @BeforeTest
    public void setUp() throws InterruptedException {

        driver = DriverManager.getDriver();
        ((JavascriptExecutor) driver).executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
        Thread.sleep(Duration.ofSeconds(5));

        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //closing window popup
        WebElement closeButton = driver.findElement(By.xpath("//span[@class='commonModal__close'][1]"));
        closeButton.click();
    }

    @AfterTest
    public void closeBrowser() {
       DriverManager.quitDriver();
    }

    @AfterSuite
    public void endReport(){
        extent.flush();
    }
}

package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementUtils {

    WebDriver driver;
    private WaitUtils waitUtils;

    public ElementUtils(WebDriver driver, int timeout) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver, timeout);
    }

    public void click(By locator) {
        //WebElement element = waitUtils.waitForClickability(locator);
        //element.click();
        waitUtils.waitForClickability(locator).click();
    }

    public void click(WebElement element) {
        waitUtils.waitForClickability(element).click();
    }

    public void type(By locator, String text) {
        WebElement element = waitUtils.waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void type(WebElement element, String text) {
        waitUtils.waitForVisibility(element).clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return waitUtils.waitForVisibility(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        try {
            return waitUtils.waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }
}

package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private WebDriver driver;
    private ElementUtils elementUtils;

    static LocalDate currentDate = LocalDate.now();
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy");
    static String formattedDate;


    public DateUtils(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver, 20); // you can make timeout configurable too
    }

    public void selectDate(int daysToAdd) {
        //Getting today's date and adding 7 days
        formattedDate = currentDate.plusDays(daysToAdd).format(dateTimeFormatter);
        //Build dynamic XPath using aria-label
        By dateToSelect = By.xpath(String.format("//div[@aria-label='%s']", formattedDate));
        elementUtils.click(dateToSelect);
    }

    public void selectDate(){
        formattedDate = currentDate.format(dateTimeFormatter);
        By dateToSelect = By.xpath(String.format("//div[@aria-label='%s']", formattedDate));
        //Click the date
        elementUtils.click(dateToSelect);
    }

    public void selectDate(String dateString) {
        LocalDate targetDate = LocalDate.parse(dateString, dateTimeFormatter);
        formattedDate = targetDate.format(dateTimeFormatter);
        By dateToSelect = By.xpath(String.format("//div[@aria-label='%s']", formattedDate));
        //Click the date
        elementUtils.click(dateToSelect);
    }
}

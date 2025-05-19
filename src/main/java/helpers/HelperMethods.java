package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementUtils;

import java.util.List;

public class HelperMethods {

    private WebDriver driver;
    private ElementUtils elementUtils;

    private static final By listOfCitiesXpath =  By.xpath("//p[@class='font14 appendBottom5 blackText']");

    public HelperMethods(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver, 20); // you can make timeout configurable too
    }

    public void selectCity(By inputLocator, String city) {

        elementUtils.click(inputLocator);

        List<WebElement> listOfCities = elementUtils.getElements(listOfCitiesXpath);

        for (WebElement fromCity : listOfCities) {
            if (fromCity.getText().contains(city)) {
                elementUtils.click(fromCity);
                break;
            }
        }
    }
}

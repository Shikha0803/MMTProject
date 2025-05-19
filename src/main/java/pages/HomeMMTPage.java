package pages;

import helpers.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.DateUtils;
import utils.ElementUtils;
import utils.WaitUtils;


public class HomeMMTPage{

    WebDriver driver;
    WaitUtils waitUtils;
    ElementUtils elementUtils;
    HelperMethods helperMethods;
    DateUtils dateUtils;

    private static final By flight = By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chFlights active'][1]");
    private static final By oneWay = By.xpath("//span[@class='tabsCircle appendRight5'][1]");
    private static final By fromCityClick = By.xpath("//input[@data-cy='fromCity'][1]");
    private static final By toCityClick = By.xpath("//input[@data-cy='toCity'][1]");
    private static final By search = By.xpath("//a[normalize-space()='Search']");
    private static final By nonStopCheckBox = By.xpath("//span[@class='commonCheckbox sizeSm primaryCheckbox']");


    public HomeMMTPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver, 20);
        this.elementUtils = new ElementUtils(driver, 20);
        this.helperMethods =new HelperMethods(driver);
        this.dateUtils = new DateUtils(driver);

    }

    //selecting flights
    public void selectOptionFlights() {
        elementUtils.click(flight);
    }

    public void selectOneWay() {
        //selecting one way
        elementUtils.click(oneWay);
    }

    public void selectFromCity(String enterFromCity) {
        //from city selection
        helperMethods.selectCity(fromCityClick,enterFromCity);

    }

    public void selectToCity(String enterToCity) {
        //to city selection
        helperMethods.selectCity(toCityClick,enterToCity);
    }

    /*public void selectDate(int date){
        dateUtils.selectDate(date);
    }*/

    public void searchButton() {
        //Click on search
        waitUtils.waitForVisibility(search);
        elementUtils.click(search);
        driver.manage().deleteAllCookies();
    }

    public void nonStopSelectCheckBox(){
        if(!elementUtils.getElement(nonStopCheckBox).isSelected()){
            elementUtils.click(nonStopCheckBox);
        }
    }

}

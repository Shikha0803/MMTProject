package MMTTestcases;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomeMMTPage;
import utils.DateUtils;

import java.time.Duration;

@Listeners(utils.TestListener.class)
public class FlightBookingTest extends BaseTest{

    @Test
    public void testOneWayFlightBooking() throws InterruptedException {
        try{
            test = extent.createTest("OneWay Flight Booking Test");

            HomeMMTPage homeMMTPage = new HomeMMTPage(driver);
            DateUtils dateUtils = new DateUtils(driver);

            homeMMTPage.selectOptionFlights();
            test.log(Status.PASS,"option selected");

            homeMMTPage.selectOneWay();

            homeMMTPage.selectFromCity("New Delhi");

            homeMMTPage.selectToCity("Mumbai");

            dateUtils.selectDate(7);
            Thread.sleep(Duration.ofMillis(5000));

            homeMMTPage.searchButton();
            Thread.sleep(Duration.ofMillis(5000));
            homeMMTPage.nonStopSelectCheckBox();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

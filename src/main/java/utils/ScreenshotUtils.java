package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver,String testname){

        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String path = "test-output/screenshots/" + testname + "_" + timestamp + ".png";

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(path);

        try{
            Files.createDirectories(dest.getParentFile().toPath());
            Files.copy(src.toPath(),dest.toPath());
        }catch (Exception e){
            e.printStackTrace();
        }
        return dest.getAbsolutePath();
    }
}

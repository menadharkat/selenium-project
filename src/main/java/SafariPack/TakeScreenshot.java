package SafariPack;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenshot extends SetupBrowsers {
    public static void main(String[] args) {
        SetupDriver1("mac", "https://www.ebay.com", "chrome");
        getScreenshot(driver1);
    }

    public static void getScreenshot(WebDriver driver){

        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        String name = df.format(date);



        //class variable = interface driver method parameter of file output
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(
                    "/Users/user/IdeaProjects/FirstSeleniumProject/src/Screenshot/new.png"+name+"png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
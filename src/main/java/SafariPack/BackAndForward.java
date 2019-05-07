package SafariPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BackAndForward {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver",
                "/Users/user/IdeaProjects/FirstSeleniumProject/src/main/resources/geckodriver");
        WebDriver driver2= new FirefoxDriver();
        driver2.manage().window().maximize();
        driver2.manage().deleteAllCookies();
        driver2.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
         //back and forward simulation
        driver2.get("http://www.google.com");
        //navigation where to move
        driver2.navigate().to("http://www.ebay.com");
        //back button
        driver2.navigate().back();
        Thread.sleep(2000);
        driver2.navigate().forward();
        Thread.sleep(2000);
        driver2.navigate().back();

        //refresh the page
        driver2.navigate().refresh();
    }
}

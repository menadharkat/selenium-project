package SafariPack;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
public class TestNJ {
    public static WebDriver driver1 = null;

    public static WebDriver SetupDriver1(String platform, String url, String browser) {
        if (platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "/Users/user/IdeaProjects/FirstSeleniumProject/src/main/resources/chromedriver");
        } else if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "/Users/user/IdeaProjects/FirstSeleniumProject/src/main/resources/chromedriver");
        }
        driver1 = new ChromeDriver();
        driver1.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver1.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver1.manage().window().maximize();
        driver1.get(url);

        return driver1;
    }
        @Test
        public void ebaySignin () {

            SetupDriver1("mac", "http://www.ebay.com", "chrome");

            driver1.findElement(By.xpath
                    ("//*[@id='gh-ac']")).sendKeys("guitar strings");
            driver1.findElement(By.xpath("//*[@id='gh-btn']")).click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            driver1.quit();//quit method


        }
        @Test
        public void SellRediraction(){
            SetupDriver1("mac", "http://www.ebay.com", "chrome");

            driver1.findElement(By.xpath("//*[@class='x-refine__item']")).click();

            driver1.quit();
        }

    }
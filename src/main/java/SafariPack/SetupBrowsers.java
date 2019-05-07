package SafariPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class SetupBrowsers {
    public static WebDriver driver1 = null;

    public static WebDriver SetupDriver1(String platform, String url,String browser) {
        if (platform.equalsIgnoreCase("mac")) {

            System.setProperty("webdriver.chrome.driver",
                    "/Users/user/IdeaProjects/FirstSeleniumProject/src/main/resources/chromedriver");
        } else {

            System.setProperty("webdriver.chrome.driver",
                    "/Users/user/IdeaProjects/FirstSeleniumProject/src/main/resources/chromedriver");

        }
        driver1 = new ChromeDriver();
        driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver1.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver1.manage().window().maximize();
        driver1.get(url);

        return driver1;


    }
    public static void main(String[] args) {


     //1.firefox
       // System.setProperty("webdriver.gecko.driver",
          //      "/Users/user/IdeaProjects/FirstSeleniumProject/src/main/resources/geckodriver");
        //WebDriver driver = new FirefoxDriver();//launch FireFox
        //driver.get("http://ebay.com");// enter URL
    // 2.Chrome
         SetupDriver1("mac","http://www.ebay.com","chrome");

        WebDriver driver1= new ChromeDriver();//launch Chrome
        driver1.get("http://ebay.com");//enter URL

     //as the the title is String
        String title= driver1.getTitle();
        System.out.println(title);//printing the title
     // verifying if the title is correct or not
     // validation point
        if(title.equals("Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay")){

            System.out.println("correct title");

        }else {
            System.out.println("incorrect title");
        }

     // print the URl
        System.out.println(driver1.getCurrentUrl());

        //driver1.quit();//quit method

    // get page source
        //System.out.println(driver1.getPageSource());



    // driver findElement(by Xpath)
        driver1.findElement(By.xpath
                ("//*[@id='gh-ac']")).sendKeys("guitar strings");

        driver1.findElement(By.xpath("//*[@id='gh-btn']")).click();
    try{

    Thread.sleep(10000);

}catch (InterruptedException e){

      e.printStackTrace();
    }


      driver1.quit();//quit method



    }


}

package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> DriverInstance = new ThreadLocal<WebDriver>();
    public static void ReleaseDriver(){
        WebDriver d = DriverManager.DriverInstance.get();
        if ( d != null){
            try{
                d.quit();
            }
            finally {
                DriverManager.DriverInstance.remove();
            }
        }
    }
    public static WebDriver GetDriver() {
        WebDriver driver = DriverManager.DriverInstance.get();
        if (driver != null)
            return driver;

        System.setProperty("webdriver.chrome.driver", "src/main/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        DriverManager.DriverInstance.set(driver);
        driver.get("https://www.ebay.com/");
        return driver;
    }
}
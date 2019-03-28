import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Locale;

public class BaseTest {
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("headless", "false");
        String headless = System.getProperty("headless");
        ChromeDriverManager.chromedriver();
        String operatingSystem = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        if(operatingSystem.contains("window")){
            System.setProperty("webdriver.chrome.driver","ChromeDriverForWindows/chromedriver.exe");
        }
        else if(operatingSystem.contains("linux")){
            System.setProperty("webdriver.chrome.driver","/Users/kkmishra/Documents/local_access/Amazon-cart/ChromeDriverForLinux/chromedriver");
        }
        else if(operatingSystem.contains("mac")){
            System.setProperty("webdriver.chrome.driver","/Users/kkmishra/Documents/local_access/Amazon-cart/ChromeDriverForMacOs/chromedriver");
        }
        if(driver == null) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("incognito");
            driver = new ChromeDriver(chromeOptions);
        } else{
            driver = new ChromeDriver();
        }
    }
    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}

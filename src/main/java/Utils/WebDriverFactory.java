package Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {
    private static WebDriver driver = null;
    
    public WebDriver createDriver() {
        return new ChromeDriver();
    }
    
    public WebDriver initializeDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
        	System.setProperty(" webdriver.chrome.driver",
        			"C:\\Users\\shrutisachan\\eclipse\\java-2022-12\\eclipse\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        	//ChromeOptions options=new ChromeOptions();
        	//options.addArguments("--headless");
        			driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("ie") || browserName.equalsIgnoreCase("internet explorer")) {
            System.setProperty("webdriver.ie.driver", "C:\\Users\\shrutisachan\\Downloads\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser name provided");
        }
        
        return driver;
    }

    public void globalWait(int globalWaitTime) {
        driver.manage().timeouts().implicitlyWait(globalWaitTime, TimeUnit.SECONDS);
    }
}

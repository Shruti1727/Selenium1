package Pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import Utils.ExtentManager;
import Utils.WebDriverFactory;

public class TestBase {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void beforeSuite() {
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void setUp() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.initializeDriver("chrome");
        webDriverFactory.globalWait(10);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            
            try {
                Thread.sleep(5000); // Wait for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }

    @AfterSuite
    public void afterSuite() {
        if (extent != null) {
            extent.flush();
        }
    }

    protected void log(Status status, String details) {
        if (test != null) {
            test.log(status, details);
        }
    }
    
    public void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
}

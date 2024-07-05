package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pages.LoginPage;
import Pages.TestBase;
import Utils.ReadXLSdata;
import Utils.configReader;

public class LoginTest extends TestBase {
    private static Logger logger = LogManager.getLogger(LoginTest.class);

    LoginPage loginPage;

    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata", priority = 4, enabled = true)
    public void testLogin(String value) {
        test = extent.createTest("Login Test with value: " + value);

        String url = configReader.getProperty("url");
        driver.get(url);
        log(Status.INFO, "Navigated to URL: " + url);
        logger.info("Navigated to URL: " + url);

        loginPage = new LoginPage(driver);
        loginPage.clickLogin();
        log(Status.INFO, "Clicked Login");
        logger.info("Clicked Login");

        loginPage.enterUsername(value);
        log(Status.INFO, "Entered Username: " + value);
        logger.info("Entered Username: " + value);

        loginPage.clickSubmit();
        log(Status.INFO, "Clicked Submit");
        logger.info("Clicked Submit");

        logger.info("Test completed for value: " + value);
    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
            test.log(Status.FAIL, "Test failed: " + result.getThrowable());
            test.addScreenCaptureFromPath("./Screenshots/" + result.getName() + ".png");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test skipped: " + result.getName());
        }
    }
}

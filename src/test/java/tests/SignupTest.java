package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pages.SignUpPage;
import Pages.TestBase;
import Utils.configReader;

public class SignupTest extends TestBase {
    private static final Logger logger = LogManager.getLogger(SignupTest.class);
    SignUpPage signUpPage;

    @Test(priority = 8, enabled = true)
    public void testSignUp() {
        test = extent.createTest("Sign Up Test");

        // Get URL from config.properties
        String url = configReader.getProperty("url");

        // Open sign-up page
        driver.get(url);
        logger.info("Launching browser");
        test.log(Status.INFO, "Launching browser");

        // Initialize SignUpPage
        signUpPage = new SignUpPage(driver);

        try {
            // Perform sign-up
            signUpPage.clickLogin();
            test.log(Status.PASS, "Click on the signup successful");
            logger.info("Click on the signup successful");
            
            signUpPage.clickCreateAccountLink();
            test.log(Status.PASS, "Click Create new account");
            logger.info("Click Create new account");
            
            signUpPage.setInputValue("9336388567");
            test.log(Status.PASS, "Enter the phone number to register");
            logger.info("Enter the phone number to register");
            
            signUpPage.clickContinueButton();
            test.log(Status.PASS, "Click on continue and signup is successful");
            logger.info("Sign up successful");
            

            // Assertion to check if the "Continue" button is clickable
            Assert.assertTrue(signUpPage.isContinueButtonClickable(), "Continue button is not clickable");

        } catch (Exception e) {
            logger.error("Error occurred while performing sign up: " + e.getMessage());
            test.log(Status.FAIL, "Error occurred while performing sign up: " + e.getMessage());
        }
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

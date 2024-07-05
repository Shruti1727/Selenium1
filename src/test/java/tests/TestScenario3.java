package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import Pages.TestBase;
import Pages.appliancesPage;
import Pages.navigateMyntraPage;
import Pages.notificationPage;
import Pages.shopsyPage;
import Pages.termsAndConditionsPage;
import Utils.configReader;

public class TestScenario3 extends TestBase {
	private static Logger logger = LogManager.getLogger(TestScenario3.class);

    shopsyPage clickShopsy;
    notificationPage clickDropdown;
    navigateMyntraPage clickMyntra;
    termsAndConditionsPage termsPage;
    appliancesPage offerZone;
    
    

    @Test(priority = 9, enabled = true, groups= {"Smoke Test"})
    public void testShopsy() {
        test = extent.createTest("Test Shopsy");

        try {
            // Get URL from config.properties
            String url = configReader.getProperty("url");
            driver.get(url);
            logger.info("Navigated to URL: " + url);
            test.log(Status.INFO, "Navigated to URL: " + url);

            clickShopsy = new shopsyPage(driver);


            // Navigate to Shopsy page
            String shopsyUrl = "https://seller.flipkart.com/shopsy";
            driver.get(shopsyUrl);
            logger.info("Navigated to Shopsy URL: " + shopsyUrl);
            test.log(Status.INFO, "Navigated to Shopsy URL: " + shopsyUrl);

            // Add an assertion to verify the page title or any element on the Shopsy page
            String expectedTitle = "Start Your Business on Shopsy With 0% Commission | Flipkart Seller Hub"; // Example title, replace with actual expected title
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");

            logger.info("Test Shopsy passed");
            test.log(Status.PASS, "Test Shopsy passed");

            
            driver.get("https://seller.flipkart.com/shopsy");
            
            test.pass("Test Shopsy passed");

        } catch (Exception e) {
            logger.error("Test Shopsy failed: " + e.getMessage());
            test.log(Status.FAIL, "Test Shopsy failed: " + e.getMessage());
            Assert.fail("Test Shopsy failed: " + e.getMessage());
        }
    }


    
    @Test(priority = 10, enabled = true)
    public void testNotification() {
        test = extent.createTest("Test Notification Page");
        try {
            // Get URL from config.properties
            String url = configReader.getProperty("url");

            driver.get(url);
            logger.info("Navigated to URL: " + url);
            test.log(Status.INFO, "Navigated to URL: " + url);

            clickDropdown = new notificationPage(driver);

            // Check if the notification dropdown is displayed
            Assert.assertTrue(clickDropdown.isDropdownDisplayed(), "Notification dropdown is not displayed");

            clickDropdown.clickDropdown();
            logger.info("Click on the dropdown where notifications are shown");
            test.log(Status.INFO, "Click on the dropdown where notifications are shown");
            
            clickDropdown.clickNotification();
            logger.info("All the notifications are shown");
            test.log(Status.INFO, "All the notifications are shown");
            
            test.pass("Test Notification passed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Test Notification failed: " + e.getMessage());
            Assert.fail("Test Notification failed: " + e.getMessage());
        }
    }



    @Test(priority = 11, enabled = true)
    public void testMyntraPage() {
        test = extent.createTest("Test Navigate to Myntra Page from Flipkart");
        try {
            // Get URL from config.properties
            String url = configReader.getProperty("url");
            driver.get(url);
            logger.info("Navigated to URL: " + url);
            test.log(Status.INFO, "Navigated to URL: " + url);


            // Initialize the navigateMyntraPage object
            clickMyntra = new navigateMyntraPage(driver);

            // Check if the Myntra page link is visible
            if (clickMyntra.isMyntraPageLinkVisible()) {
                clickMyntra.clickMyntraPage();
                
                logger.info("Click on the Myntra link");
                test.log(Status.INFO, "Navigated to Myntra Page");

                test.pass("Test Myntra Page passed");
            } else {
                // If the link is not visible, fail the test
                Assert.fail("Myntra page link is not visible");
            }
        } catch (Exception e) {
            test.log(Status.FAIL, "Test Myntra Page failed: " + e.getMessage());
            Assert.fail("Test Myntra Page failed: " + e.getMessage());
        }
    }

    @Test(priority = 12,  enabled = true)
    public void testTermsOfUseLink() {
        test = extent.createTest("Test Terms Of Use Link");
        try {
            // Get URL from config.properties
            String url = configReader.getProperty("url");

            driver.get(url);
            logger.info("Navigated to URL: " + url);
            test.log(Status.INFO, "Navigated to URL: " + url);

            termsPage = new termsAndConditionsPage(driver);

            // Check if the "Terms Of Use" link is visible
            Assert.assertTrue(termsPage.isTermsConditionsLinkVisible(), "Terms Of Use link is not visible");

            // Click on the "Terms Of Use" link
            termsPage.clickTermsCondn();
            logger.info("Click on the Terms And Conditions Page");
            test.log(Status.INFO, "Click on the Terms And Conditions Page");

            // Verify if the new page is opened or not, you can add more verifications here
            String expectedTitle = "Terms Store Online - Buy Terms Online at Best Price in India | Flipkart.com";
            Assert.assertEquals(driver.getTitle(), expectedTitle, "Terms Of Use page is not opened");
            test.pass("Test Terms Of Use Link passed");
        } catch (Exception e) {
            test.log(Status.FAIL, "Test Terms Of Use Link failed: " + e.getMessage());
            Assert.fail("Test Terms Of Use Link failed: " + e.getMessage());
        }
    }

    
        @Test(priority = 13,  enabled = true)
        public void testOfferZone() {
            test = extent.createTest("Test Offer Zone");
            try {
                // Get URL from config.properties
                String url = configReader.getProperty("url");

                driver.get(url);
                logger.info("Navigated to URL: " + url);
                test.log(Status.INFO, "Navigated to URL: " + url);

                // Initialize the appliancesPage object
                appliancesPage offerZone = new appliancesPage(driver);

                // Check if the appliances link is visible
                if (offerZone.isAppliancesLinkVisible()) {
                    // Click on the Appliances link
                    offerZone.clickAppliances();
                    logger.info("Clicked on Appliances link");
                    test.log(Status.INFO, "Clicked on Appliances link");

                    // Check if the offer zone page link is visible
                    if (offerZone.isOfferZonePageLinkVisible()) {
                        // Click on the offer zone page link
                        offerZone.offerZonePage();
                        logger.info("Clicked on Offer Zone Page link");
                        test.log(Status.INFO, "Clicked on Offer Zone Page link");

                        // Check if the offer product page link is visible
                        if (offerZone.isOfferProductPageLinkVisible()) {
                            // Click on the offer product page link
                            offerZone.offerProductPage();
                            logger.info("Clicked on Offer Product Page link");
                            test.log(Status.INFO, "Clicked on Offer Product Page link");

                            test.pass("Test Offer Zone passed");
                        } else {
                            // If the offer product page link is not visible, fail the test
                            Assert.fail("Offer Product Page link is not visible");
                        }
                    } else {
                        // If the offer zone page link is not visible, fail the test
                        Assert.fail("Offer Zone Page link is not visible");
                    }
                } else {
                    // If the appliances link is not visible, fail the test
                    Assert.fail("Appliances link is not visible");
                }
            } catch (Exception e) {
                test.log(Status.FAIL, "Test Offer Zone failed: " + e.getMessage());
                Assert.fail("Test Offer Zone failed: " + e.getMessage());
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


package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pages.AddtoCart;
import Pages.TestBase;
import Utils.ReadXLSdata;
import Utils.configReader;

public class AddtocartTest extends TestBase {
    private static Logger logger = LogManager.getLogger(AddtocartTest.class);  
    AddtoCart getProduct;

    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata", priority = 1, enabled = true)
    public void testSearch(String searchdata) {
        test = extent.createTest("Add to Cart Test");

        // Get URL from config.properties
        String url = configReader.getProperty("url");
        driver.get(url);
        log(Status.INFO, "Navigated to URL: " + url);
        logger.info("Navigated to URL: " + url);

        // Initialize AddtoCart page
        getProduct = new AddtoCart(driver);

        // Perform search
        getProduct.SearchBox(searchdata);
        log(Status.INFO, "Entered search data: " + searchdata);
        logger.info("Entered search data: " + searchdata);

        getProduct.searchBtn();
        log(Status.INFO, "Clicked on search button");
        logger.info("Clicked on search button");

        getProduct.getProductTitle();
        log(Status.INFO, "Fetched product title");
        logger.info("Fetched product title");

        getProduct.getAddToCartButton();
        log(Status.INFO, "Clicked on Add to Cart button");
        logger.info("Clicked on Add to Cart button");

        // Add an assertion to verify product added to cart
        Assert.assertTrue(getProduct.isProductAdded(), "Product was not added to the cart.");
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

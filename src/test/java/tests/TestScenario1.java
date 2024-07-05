//package tests;
//
//import java.io.IOException;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//import Pages.AddtoCart;
//import Pages.FlipkartSearchPage;
//import Pages.GroceryPage;
//import Pages.LoginPage;
//import Pages.SignUpPage;
//import Pages.TestBase;
//import Utils.ReadXLSdata;
//import Utils.configReader;
//
//public class TestScenario1 extends TestBase {
//	private static final Logger logger = LogManager.getLogger(TestScenario1.class);
//	
//
//    FlipkartSearchPage searchPage;
//    AddtoCart addToCartPage;
//    LoginPage loginPage;
//    SignUpPage signUpPage;
//    GroceryPage groceryPage;
//
//    // Extent Reports variables
//    private static ExtentReports extent;
//    private static ExtentTest test;
//
//    @BeforeSuite
//    public void setUpExtentReport() {
//        // Initialize ExtentReports
//        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//    }
//
//    @AfterSuite
//    public void tearDownExtentReport() {
//        // Flush the reports
//        extent.flush();
//    }
//
//    @AfterMethod
//    public void tearDown(ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            // If test fails, capture screenshot and attach to Extent report
//            try {
//                String screenshotPath = captureScreenshot(driver, result.getName());
//                test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata", priority = 1)
//    public void testSearch(String searchdata) {
//        // Create ExtentTest for the test method
//        test = extent.createTest("Test Search");
//
//        try {
//            // Get URL from config.properties
//            String url = configReader.getProperty("url");
//
//            // Open Flipkart website
//            driver.get(url);
//            logger.info("Launching browser");
//
//            // Initialize FlipkartSearchPage
//            searchPage = new FlipkartSearchPage(driver);
//
//            // Perform search
//            searchPage.flipkartSearchBox(searchdata);
//            searchPage.searchButton();
//
//            test.pass("Search performed successfully");
//            logger.info("Search product successfully");
//        } catch (Exception e) {
//            test.fail("Test failed: " + e.getMessage());
//            Assert.fail("Test failed: " + e.getMessage());
//        }
//    }
//
//    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata", priority = 2)
//    public void testAddToCart(String searchdata) {
//        // Create ExtentTest for the test method
//        test = extent.createTest("Test Add to Cart");
//
//        try {
//            // Get URL from config.properties
//            String url = configReader.getProperty("url");
//
//            // Open Flipkart website
//            driver.get(url);
//
//            // Initialize AddtoCartPage
//            addToCartPage = new AddtoCart(driver);
//
//            // Perform search and add to cart
//            addToCartPage.SearchBox(searchdata);
//            addToCartPage.searchBtn();
//            addToCartPage.getProductTitle();
//            addToCartPage.getAddToCartButton();
//
//            // Log test status
//            test.pass("Add to Cart performed successfully");
//        } catch (Exception e) {
//            test.fail("Test failed: " + e.getMessage());
//            Assert.fail("Test failed: " + e.getMessage());
//        }
//    }
//
//    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata", priority = 3, enabled = true)
//    public void testLogin(String value) {
//        // Create ExtentTest for the test method
//        test = extent.createTest("Test Login");
//
//        try {
//            // Get URL from config.properties
//            String url = configReader.getProperty("url");
//
//            // Open login page
//            driver.get(url);
//
//            // Initialize LoginPage
//            loginPage = new LoginPage(driver);
//
//            // Perform login
//            loginPage.clickLogin();
//            loginPage.enterUsername(value);
//            loginPage.clickSubmit();
//
//            // Log test status
//            test.pass("Login performed successfully");
//        } catch (Exception e) {
//            test.fail("Test failed: " + e.getMessage());
//            Assert.fail("Test failed: " + e.getMessage());
//        }
//    }
//
//    @Test(priority = 4)
//    public void testSignUp() {
//        // Create ExtentTest for the test method
//        test = extent.createTest("Test Sign Up");
//
//        try {
//            // Get URL from config.properties
//            String url = configReader.getProperty("url");
//
//            // Open sign-up page
//            driver.get(url);
//
//            // Initialize SignUpPage
//            signUpPage = new SignUpPage(driver);
//
//            // Perform sign-up
//            signUpPage.clickLogin();
//            signUpPage.clickCreateAccountLink();
//            signUpPage.setInputValue("9336388567");
//            signUpPage.clickContinueButton();
//
//            // Log test status
//            test.pass("Sign Up performed successfully");
//        } catch (Exception e) {
//            test.fail("Test failed: " + e.getMessage());
//            Assert.fail("Test failed: " + e.getMessage());
//        }
//    }
//
//    @Test(priority = 5)
//    public void testGroceryPage() {
//        // Create ExtentTest for the test method
//        test = extent.createTest("Test Grocery Page");
//
//        try {
//            // Get URL from config.properties
//            String url = configReader.getProperty("url");
//
//            // Open sign-up page
//            driver.get(url);
//
//            // Initialize SignUpPage
//            groceryPage = new GroceryPage(driver);
//
//            // Perform sign-up
//            groceryPage.clickGrocery();
//            groceryPage.clickCurrentLocation();
//            groceryPage.clickStaples();
//            groceryPage.addItem();
//            groceryPage.viewCartItem();
//
//            // Log test status
//            test.pass("Grocery Page test completed");
//        } catch (Exception e) {
//            //test.fail("Test failed: " + e.getMessage());
//            //Assert.fail("Test failed: " + e.getMessage());
//        }
//    }
//
//    // Method to capture screenshot
//    private String captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        String destination = "C:\\Users\\shrutisachan\\OneDrive - Nagarro\\Documents\\Automation\\exit-test\\ExitAssignment\\screenshots\\" + screenshotName + ".png";
//        org.openqa.selenium.io.FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new java.io.File(destination));
//        return destination;
//    }
//}

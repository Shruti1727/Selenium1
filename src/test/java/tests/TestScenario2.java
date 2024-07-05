//package tests;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.MediaEntityBuilder;
//
//import java.io.IOException;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//import Pages.TestBase;
//import Pages.appliancesPage;
//import Pages.mobilesPage;
//import Pages.sellerPage;
//import Pages.travelPage;
//import Pages.viewCartPage;
//import Utils.configReader;
//
//public class TestScenario2 extends TestBase {
//
//    viewCartPage viewCart;
//    mobilesPage getMobilePage;
//    travelPage getTravelPage;
//    appliancesPage getAppliancesPage;
//    sellerPage getSellerPage;
//
//    private static ExtentReports extent;
//    private static ExtentTest test;
//
//    @BeforeSuite
//    public void setUpExtentReport() {
//        // Initialize ExtentReports
//        extent = new ExtentReports();
//        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport2.html");
//        extent.attachReporter(htmlReporter);
//    }
//
//    @AfterSuite
//    public void tearDownExtentReport() {
//        // Flush ExtentReports
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
//    @BeforeMethod
//    public void createTest() {
//        test = extent.createTest("Test Scenario");
//    }
//
//    @Test
//    public void testViewCart() {
//        // Get URL from config.properties
//        String url = configReader.getProperty("url");
//
//        driver.get(url);
//
//        viewCart = new viewCartPage(driver);
//        viewCart.viewCartPage();
//
//        // Log test status
//        test.log(Status.PASS, "View Cart page test passed");
//    }
//
//    @Test(priority = 2)
//    public void testMobilePage() {
//        // Get URL from config.properties
//        String url = configReader.getProperty("url");
//
//        driver.get(url);
//
//        getMobilePage = new mobilesPage(driver);
//        getMobilePage.getMobilesImage();
//        getMobilePage.getProduct();
//        getMobilePage.clickViewDetails();
//
//        // Log test status
//        test.log(Status.PASS, "Mobile Page test passed");
//    }
//
//    @Test
//    public void testTravelPage() {
//        // Get URL from config.properties
//        String url = configReader.getProperty("url");
//
//        driver.get(url);
//
//        getTravelPage = new travelPage(driver);
//        getTravelPage.getTravelPage();
//        getTravelPage.enterText("Kanpur, KNU - Chakeri, India");
//        getTravelPage.setInputFieldValue("Mumbai, BOM - Chatrapati Shivaji Airport, India");
//        getTravelPage.clicksearchButton();
//
//        // Log test status
//        test.log(Status.PASS, "Travel Page test passed");
//    }
//
//    @Test
//    public void testAppliancesPage() {
//        // Get URL from config.properties
//        String url = configReader.getProperty("url");
//        driver.get(url);
//
//        getAppliancesPage = new appliancesPage(driver);
//        getAppliancesPage.clickAppliances();
//        getAppliancesPage.clickProducts();
//        getAppliancesPage.clickTv();
//        
//        // Log test status
//        test.log(Status.PASS, "Appliances Page test passed");
//    }
//
//    @Test
//    public void testSellerPage() {
//        // Get URL from config.properties
//        String url = configReader.getProperty("url");
//        driver.get(url);
//
//        getSellerPage = new sellerPage(driver);
//        getSellerPage.clickSeller();
//        getSellerPage.startSelling();
//
//        // Verify username field
//        WebElement usernameField = getSellerPage.getUsernameField();
//        Assert.assertTrue(usernameField.isDisplayed(), "Username field is not displayed");
//
//        // Verify email field
//        WebElement emailField = getSellerPage.getEmailField();
//        Assert.assertTrue(emailField.isDisplayed(), "Email field is not displayed");
//
//        // Log test status
//        test.log(Status.PASS, "Seller Page test passed");
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

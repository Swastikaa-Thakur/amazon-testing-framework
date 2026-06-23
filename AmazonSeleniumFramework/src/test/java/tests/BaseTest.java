package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserSetup;

/**
 * BaseTest.java
 *
 * All test classes will extend this class.
 *
 * What does "extend" mean here?
 * - It means every test class "inherits" the @BeforeMethod and @AfterMethod below.
 * - So you don't need to write openBrowser() and closeBrowser() in every test file.
 *
 * @BeforeMethod = runs BEFORE each test method (opens browser)
 * @AfterMethod  = runs AFTER each test method (closes browser)
 */
public class BaseTest {

    // All test classes can use this 'driver' directly
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserSetup.openBrowser();
        driver = BrowserSetup.driver; // Get the driver from BrowserSetup
        System.out.println("---- Test Started ----");
    }

    @AfterMethod
    public void tearDown() {
        BrowserSetup.closeBrowser();
        System.out.println("---- Test Ended ----");
    }
}

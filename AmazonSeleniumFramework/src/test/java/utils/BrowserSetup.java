package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * BrowserSetup.java
 *
 * This class handles opening and closing the Chrome browser.
 * Think of it as the "before" and "after" of every test.
 *
 * WebDriverManager automatically downloads the correct ChromeDriver
 * for your Chrome version — no manual driver setup needed!
 */
public class BrowserSetup {

    // This is a shared WebDriver object used by all tests
    public static WebDriver driver;

    /**
     * Call this method to open Chrome browser before your test starts.
     */
    public static void openBrowser() {
        // WebDriverManager downloads the right ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // ChromeOptions let you customize Chrome behavior
        ChromeOptions options = new ChromeOptions();

        // This line prevents "Chrome is being controlled by automated software" banner
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized"); // Open browser in full screen

        // Create a new Chrome browser window
        driver = new ChromeDriver(options);

        // Set a wait time: if element not found immediately, wait up to 5 seconds
        driver.manage().timeouts().implicitlyWait(
            java.time.Duration.ofSeconds(5)
        );

        System.out.println("✅ Browser opened successfully.");
    }

    /**
     * Call this method after your test is done to close the browser.
     */
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit(); // Closes all browser windows
            System.out.println("✅ Browser closed successfully.");
        }
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * HomePage.java
 *
 * This is a PAGE OBJECT for Amazon's Home Page.
 *
 * What is Page Object Model (POM)?
 * - Instead of writing locators (like XPaths) directly in test files,
 *   we keep them here in a separate "page" class.
 * - This makes tests easier to read and maintain.
 * - If Amazon changes a button, you only update it HERE, not in every test.
 *
 * @FindBy = finds a web element using a locator (id, name, xpath, etc.)
 * PageFactory.initElements() = connects the @FindBy fields to actual browser elements
 */
public class HomePage {

    WebDriver driver;

    // ---- Web Elements on Amazon Home Page ----

    // The search box where you type product name
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    // The search button (magnifying glass icon)
    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

    // "Sign In" link in the top nav
    @FindBy(id = "nav-link-accountList")
    WebElement signInLink;

    // Cart icon at the top right
    @FindBy(id = "nav-cart")
    WebElement cartIcon;

    // Amazon logo (clicking it goes back to home)
    @FindBy(id = "nav-logo-sprites")
    WebElement amazonLogo;


    // ---- Constructor ----

    /**
     * Constructor: called when you create a new HomePage object.
     * PageFactory.initElements connects all @FindBy fields to real browser elements.
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // This is the POM magic!
    }


    // ---- Actions on Home Page ----

    /**
     * Opens Amazon.in in the browser.
     */
    public void openAmazon() {
        driver.get("https://www.amazon.in");
        System.out.println("Opened Amazon.in");
    }

    /**
     * Types a product name in the search box and clicks search.
     * @param productName - e.g. "laptop", "mobile phone"
     */
    public void searchForProduct(String productName) {
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchButton.click();
        System.out.println("Searched for: " + productName);
    }

    /**
     * Clicks the Sign In button.
     */
    public void clickSignIn() {
        signInLink.click();
        System.out.println("Clicked Sign In");
    }

    /**
     * Clicks the Cart icon.
     */
    public void clickCart() {
        cartIcon.click();
        System.out.println("Clicked Cart icon");
    }

    /**
     * Returns the page title (the text shown in the browser tab).
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Returns the current URL of the browser.
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

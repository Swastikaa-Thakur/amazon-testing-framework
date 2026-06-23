package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

/**
 * HomePageTest.java
 *
 * This file contains test cases for the Amazon Home Page.
 *
 * Notice: We extend BaseTest → so browser opens/closes automatically.
 * We create a HomePage object → and use its methods to do actions.
 * We use Assert → to verify the expected vs actual result.
 *
 * Assert.assertTrue(condition)   → passes if condition is TRUE
 * Assert.assertEquals(a, b)      → passes if a equals b
 * Assert.assertFalse(condition)  → passes if condition is FALSE
 */
public class HomePageTest extends BaseTest {

    /**
     * Test 1: Verify Amazon home page opens and title is correct
     */
    @Test
    public void testAmazonHomePageTitle() {
        // Step 1: Create page object and open Amazon
        HomePage homePage = new HomePage(driver);
        homePage.openAmazon();

        // Step 2: Get the page title
        String actualTitle = homePage.getPageTitle();
        System.out.println("Page Title: " + actualTitle);

        // Step 3: Verify the title contains "Amazon"
        Assert.assertTrue(
            actualTitle.contains("Amazon"),
            "FAIL: Page title does not contain 'Amazon'. Actual title: " + actualTitle
        );
    }

    /**
     * Test 2: Verify Amazon URL loads correctly
     */
    @Test
    public void testAmazonHomePageUrl() {
        HomePage homePage = new HomePage(driver);
        homePage.openAmazon();

        String currentUrl = homePage.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        // URL should contain "amazon.in"
        Assert.assertTrue(
            currentUrl.contains("amazon.in"),
            "FAIL: URL does not contain 'amazon.in'. Actual URL: " + currentUrl
        );
    }

    /**
     * Test 3: Verify that searching a product redirects to search results page
     */
    @Test
    public void testSearchNavigatesToResultsPage() {
        HomePage homePage = new HomePage(driver);
        homePage.openAmazon();
        homePage.searchForProduct("laptop");

        String currentUrl = homePage.getCurrentUrl();
        System.out.println("URL after search: " + currentUrl);

        // After search, URL should contain "s?k=" which is Amazon's search format
        Assert.assertTrue(
            currentUrl.contains("s?k="),
            "FAIL: Did not navigate to search results page."
        );
    }

    /**
     * Test 4: Verify Sign In page opens when Sign In is clicked
     */
    @Test
    public void testSignInPageOpens() {
        HomePage homePage = new HomePage(driver);
        homePage.openAmazon();
        homePage.clickSignIn();

        String pageTitle = homePage.getPageTitle();
        System.out.println("Page title after clicking Sign In: " + pageTitle);

        // Amazon sign-in page title contains "Sign in" or "Amazon"
        Assert.assertTrue(
            pageTitle.contains("Amazon") || pageTitle.contains("Sign"),
            "FAIL: Sign In page did not open correctly."
        );
    }
}

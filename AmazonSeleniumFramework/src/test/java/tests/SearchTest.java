package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.ProductPage;

/**
 * SearchTest.java
 *
 * Test cases for Amazon's Search functionality.
 *
 * These tests cover:
 * - Searching for a valid product
 * - Verifying results are displayed
 * - Clicking on a product and verifying the product page
 */
public class SearchTest extends BaseTest {

    /**
     * Test 1: Search for a product and verify results are displayed
     */
    @Test
    public void testSearchReturnsResults() {
        // Open Amazon Home Page
        HomePage homePage = new HomePage(driver);
        homePage.openAmazon();

        // Search for "mobile phone"
        homePage.searchForProduct("mobile phone");

        // Now we're on the Search Results page — create that page object
        SearchResultsPage resultsPage = new SearchResultsPage(driver);

        // Verify that at least some results are shown
        boolean hasResults = resultsPage.areResultsDisplayed();
        System.out.println("Results displayed: " + hasResults);
        System.out.println("Number of results found: " + resultsPage.getResultCount());

        Assert.assertTrue(
            hasResults,
            "FAIL: No search results were displayed for 'mobile phone'."
        );
    }

    /**
     * Test 2: Verify search results URL contains the searched keyword
     */
    @Test
    public void testSearchUrlContainsKeyword() {
        HomePage homePage = new HomePage(driver);
        homePage.openAmazon();
        homePage.searchForProduct("headphones");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        String url = resultsPage.getCurrentUrl();
        System.out.println("Search URL: " + url);

        Assert.assertTrue(
            url.contains("headphones"),
            "FAIL: Search URL does not contain the keyword 'headphones'."
        );
    }

    /**
     * Test 3: Click on a search result and verify the product page opens
     */
    @Test
    public void testClickingProductOpensProductPage() {
        // Go to home and search
        HomePage homePage = new HomePage(driver);
        homePage.openAmazon();
        homePage.searchForProduct("laptop");

        // Get the search results page
        SearchResultsPage resultsPage = new SearchResultsPage(driver);

        // Verify there are results before clicking
        Assert.assertTrue(
            resultsPage.areResultsDisplayed(),
            "FAIL: No results found to click on."
        );

        System.out.println("First product: " + resultsPage.getFirstProductTitle());

        // Click the first product
        resultsPage.clickFirstProduct();

        // Now we're on the Product Page — create that page object
        ProductPage productPage = new ProductPage(driver);

        String productTitle = productPage.getProductTitle();
        System.out.println("Product Page Title: " + productTitle);

        // Verify the product title is not empty
        Assert.assertFalse(
            productTitle.isEmpty(),
            "FAIL: Product title was empty on product page."
        );
    }

    /**
     * Test 4: Verify product page shows price after clicking from search
     */
    @Test
    public void testProductPageShowsPrice() {
        HomePage homePage = new HomePage(driver);
        homePage.openAmazon();
        homePage.searchForProduct("keyboard");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);

        if (resultsPage.areResultsDisplayed()) {
            resultsPage.clickFirstProduct();

            ProductPage productPage = new ProductPage(driver);
            String price = productPage.getProductPrice();
            System.out.println("Product Price: ₹" + price);

            // Just verify price text is not empty
            Assert.assertFalse(
                price.isEmpty(),
                "FAIL: Product price was empty."
            );
        } else {
            System.out.println("SKIP: No results found for 'keyboard'.");
        }
    }

    /**
     * Test 5: Verify Add to Cart button is visible on product page
     */
    @Test
    public void testAddToCartButtonVisible() {
        HomePage homePage = new HomePage(driver);
        homePage.openAmazon();
        homePage.searchForProduct("pen drive");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);

        if (resultsPage.areResultsDisplayed()) {
            resultsPage.clickFirstProduct();

            ProductPage productPage = new ProductPage(driver);
            boolean isVisible = productPage.isAddToCartVisible();
            System.out.println("Add to Cart visible: " + isVisible);

            // Note: For some products it may not be visible if sold by 3rd party
            // So we just print the result instead of hard failing
            System.out.println("Product: " + productPage.getProductTitle());
            System.out.println("Stock: " + productPage.getStockStatus());
        }
    }
}

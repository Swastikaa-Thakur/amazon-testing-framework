package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * SearchResultsPage.java
 *
 * Page Object for the Search Results page on Amazon.
 * This page appears after you search for a product.
 */
public class SearchResultsPage {

    WebDriver driver;

    // ---- Web Elements on Search Results Page ----

    // All product titles shown in search results
    // Note: @FindBy with a list finds ALL matching elements
    @FindBy(css = "h2.a-size-mini span.a-text-normal")
    List<WebElement> productTitles;

    // The search keyword shown at the top ("Results for 'laptop'")
    @FindBy(css = "span.a-color-state.a-text-bold")
    WebElement searchKeywordLabel;

    // "Sort by" dropdown
    @FindBy(id = "s-result-sort-select")
    WebElement sortDropdown;

    // All "Add to Cart" buttons in results (may not always be visible)
    @FindBy(css = "button[name='submit.addToCart']")
    List<WebElement> addToCartButtons;

    // First product link in results
    @FindBy(css = "h2.a-size-mini a")
    List<WebElement> productLinks;


    // ---- Constructor ----

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // ---- Actions on Search Results Page ----

    /**
     * Returns true if at least one product result is shown.
     */
    public boolean areResultsDisplayed() {
        return productTitles.size() > 0;
    }

    /**
     * Returns the number of products shown in results.
     */
    public int getResultCount() {
        return productTitles.size();
    }

    /**
     * Returns the title of the first product in the results.
     */
    public String getFirstProductTitle() {
        if (productTitles.size() > 0) {
            return productTitles.get(0).getText();
        }
        return "No results found";
    }

    /**
     * Clicks on the first product in the search results.
     */
    public void clickFirstProduct() {
        if (productLinks.size() > 0) {
            productLinks.get(0).click();
            System.out.println("Clicked on first product");
        } else {
            System.out.println("No products found to click");
        }
    }

    /**
     * Returns the current page URL.
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Returns the page title.
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
}

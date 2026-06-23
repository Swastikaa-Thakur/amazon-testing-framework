package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * ProductPage.java
 *
 * Page Object for an individual Product Detail Page on Amazon.
 * This is the page that opens when you click on a product.
 */
public class ProductPage {

    WebDriver driver;

    // ---- Web Elements on Product Page ----

    // Product title / name
    @FindBy(id = "productTitle")
    WebElement productTitle;

    // Price of the product
    @FindBy(css = "span.a-price-whole")
    WebElement productPrice;

    // "Add to Cart" button
    @FindBy(id = "add-to-cart-button")
    WebElement addToCartButton;

    // "Buy Now" button
    @FindBy(id = "buy-now-button")
    WebElement buyNowButton;

    // Star rating (e.g., "4.3 out of 5 stars")
    @FindBy(css = "span.a-icon-alt")
    WebElement starRating;

    // Number of customer reviews
    @FindBy(id = "acrCustomerReviewText")
    WebElement reviewCount;

    // "In Stock" / "Currently unavailable" label
    @FindBy(id = "availability")
    WebElement stockStatus;


    // ---- Constructor ----

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // ---- Actions on Product Page ----

    /**
     * Returns the product name/title.
     */
    public String getProductTitle() {
        return productTitle.getText().trim();
    }

    /**
     * Returns the product price as text (e.g., "49,999").
     */
    public String getProductPrice() {
        try {
            return productPrice.getText().trim();
        } catch (Exception e) {
            return "Price not available";
        }
    }

    /**
     * Returns the star rating text (e.g., "4.3 out of 5 stars").
     */
    public String getStarRating() {
        try {
            return starRating.getText().trim();
        } catch (Exception e) {
            return "Rating not available";
        }
    }

    /**
     * Returns availability status (e.g., "In stock", "Currently unavailable").
     */
    public String getStockStatus() {
        try {
            return stockStatus.getText().trim();
        } catch (Exception e) {
            return "Status not available";
        }
    }

    /**
     * Returns true if "Add to Cart" button is visible on the page.
     */
    public boolean isAddToCartVisible() {
        try {
            return addToCartButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Clicks "Add to Cart" button.
     */
    public void clickAddToCart() {
        addToCartButton.click();
        System.out.println("Clicked Add to Cart");
    }

    /**
     * Returns current page title.
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
}

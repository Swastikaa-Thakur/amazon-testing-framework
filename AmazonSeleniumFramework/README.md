# Amazon.in Selenium Test Framework 🛒

A **beginner-friendly** Selenium + Java test automation framework for Amazon.in,  
built using **Page Object Model (POM)** pattern.

---

## 📁 Project Structure

```
AmazonSeleniumFramework/
│
├── pom.xml                          ← Maven config (downloads Selenium, TestNG automatically)
├── testng.xml                       ← Tells TestNG which tests to run
│
└── src/test/java/
    │
    ├── utils/
    │   └── BrowserSetup.java        ← Opens and closes Chrome browser
    │
    ├── pages/                       ← Page Object Model classes
    │   ├── HomePage.java            ← Amazon home page elements & actions
    │   ├── SearchResultsPage.java   ← Search results page elements & actions
    │   └── ProductPage.java         ← Individual product page elements & actions
    │
    └── tests/                       ← Actual test cases
        ├── BaseTest.java            ← Shared setup/teardown (extended by all tests)
        ├── HomePageTest.java        ← Tests for home page
        └── SearchTest.java          ← Tests for search functionality
```



## 📝 Test Cases Covered

### HomePageTest.java
| Test | What it checks |
|------|----------------|
| `testAmazonHomePageTitle` | Page title contains "Amazon" |
| `testAmazonHomePageUrl` | URL contains "amazon.in" |
| `testSearchNavigatesToResultsPage` | Search redirects to results page |
| `testSignInPageOpens` | Sign In button navigates correctly |

### SearchTest.java
| Test | What it checks |
|------|----------------|
| `testSearchReturnsResults` | Search shows product results |
| `testSearchUrlContainsKeyword` | Search URL has keyword |
| `testClickingProductOpensProductPage` | Product page loads on click |
| `testProductPageShowsPrice` | Product price is visible |
| `testAddToCartButtonVisible` | Add to Cart button exists |

---


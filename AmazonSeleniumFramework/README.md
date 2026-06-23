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

---

## 🧠 What is Page Object Model (POM)?

Instead of writing locators (like XPath, CSS selectors) directly in your test files,  
you create a **separate class for each page** of the website.

```
Without POM (bad):               With POM (good):
─────────────────                ─────────────────
TestFile.java:                   HomePage.java:
  driver.findElement(            @FindBy(id="twotabsearchtextbox")
    By.id("twotabsearchtextbox") WebElement searchBox;
  ).sendKeys("laptop");
                                 TestFile.java:
                                   homePage.searchForProduct("laptop");
```

**Benefits:**
- Test files stay clean and readable
- If Amazon changes a locator, you fix it in ONE place only
- Easy to add new tests without duplicating code

---

## ⚙️ Setup Requirements

| Tool | Version | Download |
|------|---------|----------|
| Java JDK | 11 or higher | https://adoptium.net |
| Maven | 3.6+ | https://maven.apache.org |
| Google Chrome | Latest | https://www.google.com/chrome |
| IntelliJ IDEA | Any | https://www.jetbrains.com/idea (Community is free) |

> ✅ **You do NOT need to download ChromeDriver manually.**  
> WebDriverManager (included in pom.xml) downloads it automatically.

---

## 🚀 How to Run Tests

### Option 1: Using IntelliJ IDEA (Recommended for beginners)

1. Open IntelliJ → `File` → `Open` → select the `AmazonSeleniumFramework` folder
2. Wait for Maven to download all dependencies (bottom bar shows progress)
3. Right-click on `testng.xml` → click **Run**
4. Or right-click any test class → click **Run**

### Option 2: Using Command Line (Maven)

```bash
# Go to the project folder
cd AmazonSeleniumFramework

# Run all tests
mvn test

# Run only one test class
mvn test -Dtest=HomePageTest
```

---

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

## 🔍 Key Concepts Used

### @FindBy
```java
@FindBy(id = "twotabsearchtextbox")
WebElement searchBox;
```
Finds elements using id, name, css, xpath, etc.

### PageFactory.initElements()
```java
PageFactory.initElements(driver, this);
```
Connects your `@FindBy` fields to actual browser elements. Always call this in the constructor.

### @BeforeMethod / @AfterMethod (TestNG)
```java
@BeforeMethod
public void setUp() { /* runs before each test */ }

@AfterMethod
public void tearDown() { /* runs after each test */ }
```

### Assert
```java
Assert.assertTrue(condition, "message if it fails");
Assert.assertEquals(actual, expected, "message if it fails");
```

---

## ❓ Common Issues & Fixes

| Problem | Fix |
|---------|-----|
| `ChromeDriver not found` | WebDriverManager handles this automatically — no action needed |
| `Element not found` | Amazon may have changed their page. Update the locator in the Page class |
| `Tests failing randomly` | Amazon sometimes shows CAPTCHAs or popups — run again |
| `Maven not recognized` | Add Maven to your system PATH, or use IntelliJ's built-in Maven |

---

## 📌 How to Add a New Test

1. Identify which page you're testing (Home / Search / Product)
2. Open the relevant **page class** (e.g., `HomePage.java`)
3. Add any new `@FindBy` elements if needed
4. Add a new method for the action
5. Go to the **test class** (e.g., `HomePageTest.java`)
6. Write a new `@Test` method using that action
7. Use `Assert` to verify expected vs actual

---

*Built for learning purposes. Great for freshers building their QA portfolio!* 🎯

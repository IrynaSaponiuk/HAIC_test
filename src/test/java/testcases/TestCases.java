package testcases;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.AllureJunit4;
import manager.PageFactoryManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagefactory.CartPage;
import pagefactory.MainPage;
import pagefactory.ProductPage;
import pagefactory.SearchPage;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class TestCases {

    private static final String URL = "https://exist.ua/uk/";

    private List<String> products = Arrays.asList("C124606",
            "Mann-Filter W9142",
            "WIX WL7168",
            "Bosch 0 986 452 044",
            "Fram PH2857A");

    WebDriver driver;
    MainPage mainPage;
    CartPage cartPage;
    ProductPage productPage;
    SearchPage searchPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Test
    public void checkIfElementsAreDisplayed() {
        mainPage = pageFactoryManager.getMainPage();
        mainPage.openMainPage(URL);
        searchPage = pageFactoryManager.getSearchPage();
        for (int i = 0; i < products.size(); i++) {
            searchPage.waitForVisibilityOfElement(Duration.ofSeconds(15), searchPage.getSearchBar()); //I used longer waits, because my internet connection was a bit slow :D
            searchPage.clickOnSearchBar();
            searchPage.waitForVisibilityOfElement(Duration.ofSeconds(15), searchPage.getAnotherSearchBar());
            searchPage.typeInSearchBar(products.get(i));
            searchPage.waitForVisibilityOfElement(Duration.ofSeconds(15), searchPage.getFirstElement());
            if (i == 0) {
                searchPage.clickOnFirstElement();
            } else {
                searchPage.clickOnOtherElement();
            }
            productPage = pageFactoryManager.getProductPage();
            productPage.waitForVisibilityOfElement(Duration.ofSeconds(15), productPage.getNameOfTheProduct());
            productPage.isNameOfTheProductDisplayed();
            productPage.isPriceDisplayed();
            Allure.addAttachment("Is price and name displayed", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            driver.navigate().refresh();
        }
    }

    @Test
    public void checkIfTotalPriceIsCorrect() {
        mainPage = pageFactoryManager.getMainPage();
        mainPage.openMainPage(URL);
        searchPage = pageFactoryManager.getSearchPage();
        for (int i = 0; i < products.size(); i++) {
            searchPage.waitForVisibilityOfElement(Duration.ofSeconds(15), searchPage.getSearchBar()); //I used longer waits, because my internet connection was a bit slow :D
            searchPage.clickOnSearchBar();
            searchPage.waitForVisibilityOfElement(Duration.ofSeconds(15), searchPage.getAnotherSearchBar());
            searchPage.typeInSearchBar(products.get(i));
            searchPage.waitForVisibilityOfElement(Duration.ofSeconds(15), searchPage.getFirstElement());
            if (i == 0) {
                searchPage.clickOnFirstElement();
            } else {
                searchPage.clickOnOtherElement();
            }
            productPage = pageFactoryManager.getProductPage();
            productPage.waitForVisibilityOfElement(Duration.ofSeconds(15), productPage.getBuyButton());
            productPage.clickOnBuyButton();
        }
        productPage.clickOnShoppingCartButton();
        productPage.waitForVisibilityOfElement(Duration.ofSeconds(15), productPage.getGoToCartButton());
        productPage.clickOnGoToCartButton();
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitForVisibilityOfElement(Duration.ofSeconds(15), cartPage.getTotalPriceTag());
        cartPage.compareTotalPrice();
        Allure.addAttachment("Inside the cart", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}

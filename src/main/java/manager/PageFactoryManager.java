package manager;

import org.openqa.selenium.WebDriver;
import pagefactory.CartPage;
import pagefactory.MainPage;
import pagefactory.ProductPage;
import pagefactory.SearchPage;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage getMainPage() {
        return new MainPage(driver);
    }

    public CartPage getCartPage() {
        return new CartPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SearchPage getSearchPage() {
        return new SearchPage(driver);
    }

}

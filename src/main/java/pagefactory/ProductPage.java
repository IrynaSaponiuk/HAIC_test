package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    private WebElement nameOfTheProduct;

    @FindBy(xpath = "//div[contains(@class,'ProductInfostyle')]//div[contains(@class,'ProductPriceValue')]")
    private WebElement productPriceValue;

    @FindBy(xpath = "//div[contains(@class,'ProductInfostyle')]//span[contains(@class,'ProductCurrency')]")
    private WebElement productPriceCurrency;

    @FindBy(xpath = "//*[contains(@class, 'ProductInfostyle')]//button[@aria-label = 'Купити']")
    private WebElement buyButton;

    @FindBy(xpath = "//*[@aria-label=\"dropdown-cart\"]")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//*[@aria-label=\"Перейти до кошика\"]")
    private WebElement goToCurtButton;

    private static final String NAME_OF_THE_PRODUCT = "//h1";
    private static final String BUY_BUTTON = "//*[contains(@class, 'ProductInfostyle')]//button[@aria-label = 'Купити']";
    private static final String GO_TO_CART_BUTTON = "//*[@aria-label=\"Перейти до кошика\"]";

    public By getNameOfTheProduct(){
        return By.xpath(NAME_OF_THE_PRODUCT);
    }

    public By getGoToCartButton(){
        return By.xpath(GO_TO_CART_BUTTON);
    }

    public By getBuyButton(){
        return By.xpath(BUY_BUTTON);
    }

    public void clickOnBuyButton(){
        buyButton.click();
    }

    public void clickOnGoToCartButton(){
        goToCurtButton.click();
    }

    public void clickOnShoppingCartButton(){
        shoppingCartButton.click();
    }

    public void isNameOfTheProductDisplayed(){
        if(nameOfTheProduct.isDisplayed()){
            System.out.println("Назва товару відображається на сторінці:  "
            + nameOfTheProduct.getText());
        }
    }

    public void isPriceDisplayed(){
        if(productPriceValue.isDisplayed() & productPriceCurrency.isDisplayed()){
            System.out.println("Ціна товару відображається на сторінці: "
                    + productPriceValue.getText() + " "
                    + productPriceCurrency.getText());
        }
    }


}

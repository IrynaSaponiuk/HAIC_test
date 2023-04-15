package pagefactory;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends  BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class, \"Cartstyle__CartTotal-\")]")
    private List<WebElement> totalPriceOfEachProduct;

    @FindBy(xpath = "//*[contains(@class,\"CartFooterstyle__CartFooterTotal-\")]")
    private WebElement totalPriceTag;

    private static final String TOTAL_PRICE_TAG = "//*[contains(@class,\"CartFooterstyle__CartFooterTotal-\")]";

    public By getTotalPriceTag(){
        return By.xpath(TOTAL_PRICE_TAG);
    }

    public void compareTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < totalPriceOfEachProduct.size(); i++) {
            String price = totalPriceOfEachProduct.get(i).getText();
            String priceWithoutCurrency = price.substring(0, price.length() - 4);
            int priceToInt = Integer.parseInt(priceWithoutCurrency);
            totalPrice = totalPrice + priceToInt;
            System.out.println(price + " " + priceWithoutCurrency + " " + priceToInt + " " + totalPrice);
        }

        int totalPriceTagToInt = Integer.parseInt(totalPriceTag.getText().substring(8,totalPriceTag.getText().length()-4));

        if (totalPrice==totalPriceTagToInt){
            System.out.println("TOTAL PRICE IS CORRECT!");
        }
    }
}

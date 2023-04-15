package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-scroll='up']//*[@aria-label='search']")
    private WebElement searchBarButton;

    @FindBy(xpath = "//*[@aria-label='multiSearch']")
    private WebElement searchBar;

    @FindBy(xpath = "(//div[contains(@class,'MultiSearchProductsstyle')]//div[contains(text(),'Фільтр масляний')])[2]")
    private WebElement firstProduct;

    @FindBy(xpath = "//div[contains(@class,'MultiSearchProductsstyle')]//div[contains(text(),'Фільтр масляний')]")
    private WebElement otherProducts;

    private static final String SEARCH_BAR = "//div[@data-scroll='up']//*[@aria-label='search']";
    private static final String ANOTHER_SEARCH_BAR = "//*[@aria-label='multiSearch']";
    private static final String FIRST_PRODUCT = "//div[contains(@class,'MultiSearchProductsstyle')]//div[contains(text(),'Фільтр масляний')]";

    public By getSearchBar(){
        return By.xpath(SEARCH_BAR);
    }

    public By getAnotherSearchBar(){
        return By.xpath(ANOTHER_SEARCH_BAR);
    }

    public By getFirstElement(){
        return By.xpath(FIRST_PRODUCT);
    }

    public void typeInSearchBar(String request){
        searchBar.sendKeys(request);
    }

    public void clickOnSearchBar(){
        Actions actions =new Actions(driver);
        actions.moveToElement(searchBarButton).click().perform();
        actions.release();
    }

    public void clickOnFirstElement(){
        firstProduct.click();
    }

    public void clickOnOtherElement(){
        otherProducts.click();
    }
}

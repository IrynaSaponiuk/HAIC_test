package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void waitForVisibilityOfElement(Duration timeToWait, By locator){
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

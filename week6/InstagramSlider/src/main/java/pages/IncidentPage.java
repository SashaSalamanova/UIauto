package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IncidentPage extends BasePage{
    public IncidentPage (WebDriver driver){
        super(driver);
    }

    private WebDriver driver = super.getDriver();
    private String pageUrl = System.getProperty("domain.url");

    public IncidentPage open(){
        driver.get(pageUrl);
        driver.manage().window().maximize();
        WebElement element = driver.findElements(By.cssSelector(".article__container")).get(2);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

}

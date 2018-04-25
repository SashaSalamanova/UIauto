package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PetsNewsPage extends BasePage {

    public PetsNewsPage(WebDriver driver){
        super(driver);
    }
    private WebDriver driver = super.getDriver();
    private String pageUrl = System.getProperty("webdriver.domain.url");
    private Wait wait = new WebDriverWait(driver,
            60).withMessage("Время ожидания превышено");

    @FindBy(css = ".js-pgng_more_link")
    private WebElement showMoreButton;

    private List<WebElement> articlesDisplayed;

    public PetsNewsPage open(){
        driver.get(pageUrl);
        return this;
    }
    public void clickShowMoreButton(){
        int articlesCount = getArticlesDisplayed().size();
        showMoreButton.click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".js-pgng_item"),
                articlesCount));
    }

    public List<WebElement> getArticlesDisplayed(){
        articlesDisplayed = driver.findElements(By.cssSelector(".js-pgng_item"));
        return articlesDisplayed ;
    }


}

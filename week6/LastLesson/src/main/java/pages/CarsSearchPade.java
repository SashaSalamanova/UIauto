package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarsSearchPade extends BasePage {

    public CarsSearchPade (WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@name = 'min_price']")
    private WebElement minPriceField;

    @FindBy(xpath = "//input[@name = 'max_price']")
    private WebElement maxPriceField;

    @FindBy(css = ".p-search__package")
    private List<WebElement> foundCarsList;



}

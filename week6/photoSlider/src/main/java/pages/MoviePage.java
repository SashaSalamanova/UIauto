package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoviePage extends BasePage{
    public MoviePage(WebDriver driver){
        super(driver);
    }

    private WebDriver driver = super.getDriver();
}

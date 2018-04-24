package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoviePage extends BasePage{
    public MoviePage(WebDriver driver){
        super(driver);
    }

    private WebDriver driver = super.getDriver();

    @FindBy(tagName = "h1")
    private WebElement header;

    public String getPageHeader(){
        return header.getText();
    }

}

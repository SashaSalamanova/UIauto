package pages;

import navigation.Page;
import navigation.UrlPattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Page
@UrlPattern
public class AutoMainPage extends BasePage {

    public AutoMainPage (WebDriver driver){
        super(driver);
    }

    @FindBy(css = ".pm-logo__link__pic")
    private List<WebElement> headers;

    @Override
    public String getPageHeader(){
        return headers.get(1).getAttribute("title");
    }


}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

    private WebDriver driver = null;

    @FindBy(tagName = "h1")
    private WebElement header;

    BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public String getPageHeader(){
        return header.getText();
    }
}


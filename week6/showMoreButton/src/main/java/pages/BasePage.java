package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver = null;
    BasePage(WebDriver driver){
        this.driver = driver;
    }
    public WebDriver getDriver(){
        return driver;
    }
}

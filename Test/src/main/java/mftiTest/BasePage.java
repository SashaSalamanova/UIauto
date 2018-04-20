package mftiTest;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    BasePage(WebDriver driver){
        this.driver = driver;
    }
    public WebDriver getDriver(){
        return driver;
    }

}



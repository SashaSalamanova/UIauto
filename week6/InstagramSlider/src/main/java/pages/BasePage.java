package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    public void scrollPage(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public  void maximizePage(){
        driver.manage().window().maximize();
    }
}


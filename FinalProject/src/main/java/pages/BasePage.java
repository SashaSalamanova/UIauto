package pages;

import navigation.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage extends PageObject {

    public BasePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1")
    private WebElement header;

    public String getPageHeader() {
        return header.getText();
    }

    public void open() {
        getDriver().get(getPageUrl());
    }

}

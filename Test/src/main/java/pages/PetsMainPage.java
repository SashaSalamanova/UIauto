package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PetsMainPage {
    private WebDriver driver;
    private String pageUrl = "https://pets.mail.ru/";
    private Pattern pagePattern = Pattern.compile("https://pets.mail.ru/");
    @FindBy(tagName = "h1")
    private WebElement header;

    public PetsMainPage(WebDriver driver){
        this.driver = driver;
    }
    private PetsMainPage open(){
        driver.get(pageUrl);
        return this;
    }

    private boolean isPageCheck(){
        Matcher matcher = pagePattern.matcher(driver.getCurrentUrl());
        return matcher.find();
    }

    public String getPageHeader(){
        return header.getText();
    }

    public String openMainPage(){
        open();
        isPageCheck();
        return getPageHeader();
    }
}

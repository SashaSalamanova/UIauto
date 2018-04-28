package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KinoMainPage extends BasePage{

    public KinoMainPage (WebDriver driver){
        super(driver);
    }

    private WebDriver driver = super.getDriver();
    private String pageUrl = System.getProperty("domain.url");
    private Pattern pagePattern = Pattern.compile("https://kino.mail.ru");

    public KinoMainPage open(){
        driver.get(pageUrl);
        return this;
    }

    private boolean isPageCheck(){
        Matcher matcher = pagePattern.matcher(driver.getCurrentUrl());
        return matcher.find();
    }

    public boolean openMainPage(){
        open();
        return isPageCheck();
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IncidentPage extends BasePage{

    public IncidentPage (WebDriver driver){
        super(driver);
    }

    private WebDriver driver = super.getDriver();
    private String pageUrl = System.getProperty("domain.url");
    private Pattern pagePattern = Pattern.compile("https://news.mail.ru/incident/"+ "\\d+");

    @FindBy(css = ".article__container")
    private List<WebElement> articlesToScroll;


    public IncidentPage open(){
        driver.get(pageUrl);
        maximizePage();
        scrollPage(articlesToScroll.get(2));
        return this;
    }

    public boolean isPageCheck(){
        Matcher matcher = pagePattern.matcher(driver.getCurrentUrl());
        return matcher.find();
    }

}

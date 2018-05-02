package pages;


import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailMainPage extends BasePage{

    private Pattern pagePattern = Pattern.compile("https://mail.ru");

    public MailMainPage(WebDriver driver){
        super(driver);
    }

    public boolean isPageCheck(){
        Matcher matcher = pagePattern.matcher(getDriver().getCurrentUrl());
        return matcher.find();
    }


}

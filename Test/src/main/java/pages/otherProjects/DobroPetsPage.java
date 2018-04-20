package pages.otherProjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DobroPetsPage {

    public DobroPetsPage(WebDriver driver){
        this.driver = driver;
    }
    private WebDriver driver = null;
    private Pattern pagePattern = Pattern.compile("http[s]?://.*?dobro\\..*?/projects/.*?");
    @FindBy(css = ".hdr__inner")
    private WebElement header;

    public boolean isPageCheck(){
        Matcher matcher = pagePattern.matcher(driver.getCurrentUrl());
        return matcher.find();
    }

    public String getPageHeader(){
        return header.getText();
    }


}

package pages;

import org.openqa.selenium.WebDriver;

public class IncidentPage extends BasePage{
    public IncidentPage (WebDriver driver){
        super(driver);
    }

    private WebDriver driver = super.getDriver();
    private String pageUrl = System.getProperty("domain.url");

    public IncidentPage open(){
        driver.get(pageUrl);
        return this;
    }

}

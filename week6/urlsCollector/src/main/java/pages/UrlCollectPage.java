package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class UrlCollectPage extends BasePage {
    public UrlCollectPage(WebDriver driver){
        super(driver);
    }

    private WebDriver driver = super.getDriver();
    private String pageUrl = System.getProperty("webdriver.url.collect");
    @FindBy(xpath = "//a[contains(@href, 'mail.ru') or starts-with(@href, '/') or @href = '#']")
    private List<WebElement> referenceLinks;
    @FindBy(tagName = "a")
    private List<WebElement> externalLinks;

    public UrlCollectPage open(){
        driver.get(pageUrl);
        return this;
    }

    public List<WebElement>  getReferenceLinks(){
        return referenceLinks;
    }

    public List<WebElement>  getExternalLinks(){
        return externalLinks.stream().filter(s -> !(referenceLinks.contains(s))).collect(Collectors.toList());
    }

}

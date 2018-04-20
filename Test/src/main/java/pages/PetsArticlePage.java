package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Pattern;

public class PetsArticlePage {
    private WebDriver driver = null;
    @FindBy(css = ".hdr__inner")
    private WebElement header;

    public PetsArticlePage(WebDriver driver){
        this.driver = driver;
    }
    private String pageUrl = "https://pets.mail.ru/";
    private Pattern pagePattern = Pattern.compile("https://pets.mail.ru/");


    public String getPageHeader(){
        return header.getText();
    }
}

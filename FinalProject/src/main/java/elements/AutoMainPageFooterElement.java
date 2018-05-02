package elements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.MailMainPage;

@Component(css = ".footer")
public class AutoMainPageFooterElement extends ComponentObject {

    public AutoMainPageFooterElement(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ".footer__link")
    private WebElement aboutCompanyLink;

    public MailMainPage clickAboutCompanyLink(){
        aboutCompanyLink.click();
        return PageFactory.initElements(getDriver(), MailMainPage.class);
    }

}

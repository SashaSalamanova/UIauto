package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShotPage extends BasePage{
    public ShotPage(WebDriver driver){
        super(driver);
    }

    private WebDriver driver = super.getDriver();
    @FindBy(css = ".viewbox__control_next")
    private WebElement nextShotArrow;
    @FindBy(css = ".viewbox__control_previous")
    private WebElement previousShotArrow;

    public ShotPage clickNextShotArrow(){
        nextShotArrow.click();
        return PageFactory.initElements(driver, ShotPage.class);
    }

    public ShotPage clickPreviousShotArrow(){
        previousShotArrow.click();
        return PageFactory.initElements(driver, ShotPage.class);
    }
}

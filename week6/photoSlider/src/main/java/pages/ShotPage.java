package pages;

import components.AfishaElement;
import components.TrailerAndShotsElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShotPage extends BasePage{
    public ShotPage(WebDriver driver){
        super(driver);
    }

    private WebDriver driver = super.getDriver();
    private Pattern pagePattern = Pattern.compile("https://kino.mail.ru/shot/" + "\\d+");
    @FindBy(css = ".viewbox__control_next")
    private WebElement nextShotArrow;
    @FindBy(css = ".viewbox__control_previous")
    private WebElement previousShotArrow;

    public boolean isPageCheck(){
        Matcher matcher = pagePattern.matcher(driver.getCurrentUrl());
        return matcher.find();
    }

    public ShotPage clickNextShotArrow(){
        nextShotArrow.click();
        return PageFactory.initElements(driver, ShotPage.class);
    }

    public ShotPage clickPreviousShotArrow(){
        previousShotArrow.click();
        return PageFactory.initElements(driver, ShotPage.class);
    }

    public ShotPage open(){

        KinoMainPage kinoMainPage = PageFactory.initElements(driver, KinoMainPage.class);
        kinoMainPage.open();
        AfishaElement afishaElement = PageFactory.initElements(driver, AfishaElement.class);
        String title = afishaElement.getAfishaArticleTitle(1);
        //Переход на страницу с фильмами
        Set<String> parentHandle = driver.getWindowHandles();
        MoviePage moviePage = afishaElement.clickAfishaMovie(title);
        Set<String> childHandle = driver.getWindowHandles();
        childHandle.remove(parentHandle);
        driver.switchTo().window(childHandle.iterator().next());
        TrailerAndShotsElement trailerAndShotsElement = PageFactory.initElements(driver, TrailerAndShotsElement.class);
        trailerAndShotsElement.clickFirstShot();

        return this;
    }

    public ShotPage clickRightLeftArrow(){

        Actions clickArrows = new Actions(driver);
        clickArrows.click(nextShotArrow).click(previousShotArrow).build().perform();
        return PageFactory.initElements(driver, ShotPage.class);
    }

}

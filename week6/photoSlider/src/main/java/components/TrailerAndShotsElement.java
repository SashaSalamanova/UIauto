package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.MoviePage;
import pages.ShotPage;

import java.util.stream.Collectors;

public class TrailerAndShotsElement {

    private WebDriver driver;

    public TrailerAndShotsElement(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".block_posrel")
    private WebElement component;

    public boolean isComponentPresent() {
        return component.isDisplayed();
    }

    private final String movieShotsLocator = "//a[contains(@data-share-url, '/shot/') and not(contains(@tabindex, '-1'))]";

    public ShotPage clickFirstShot(){

        WebElement firstShot = driver.findElements(By.xpath(movieShotsLocator)).stream()
                                .collect(Collectors.toList()).get(0);
        firstShot.click();
        return PageFactory.initElements(driver, ShotPage.class);
    }

}

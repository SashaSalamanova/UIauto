package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.MoviePage;

import java.util.stream.Collectors;

public class AfishaElement {

    private WebDriver driver;

    public AfishaElement(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".cinemaafisha__items")
    private WebElement component;
    private final String cinemaAfishaItemsTitleLocator = "//header[contains(@class, 'cinemaafisha__item__title')]";
    private final String getCinemaAfishaItemByTitleLocator = cinemaAfishaItemsTitleLocator + "//a[text()='%s']" ;

    public boolean isComponentPresent() {
        return component.isDisplayed();
    }

    //Для того, чтобы получить название статьи с заданным индексом на странице kino.mail.ru
    //чтобы потом можно было сверить названия статьи, на которую кликнули
    public String getAfishaArticleTitle(int index){
        return driver.findElements(By.xpath(cinemaAfishaItemsTitleLocator)).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList()).get(--index);
    }

    // Клик по выбранной статье
    public MoviePage clickAfishaMovie(String title){
        String locator = String.format(getCinemaAfishaItemByTitleLocator, title);
        driver.findElement(By.xpath(locator)).click();
        return PageFactory.initElements(driver, MoviePage.class);
    }

}

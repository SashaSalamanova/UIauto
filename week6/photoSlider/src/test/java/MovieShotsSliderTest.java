import components.AfishaElement;
import components.TrailerAndShotsElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.KinoMainPage;
import pages.MoviePage;
import pages.ShotPage;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieShotsSliderTest {

    private WebDriver driver;

    @Before
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--no-first-run");
        chromeOptions.addArguments("--homepage=about:blank");
        chromeOptions.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(chromeOptions);

    }

    @After
    public void close() {
        if(driver != null) {
            driver.quit();
        }
    }

    // Проверка того, что все страницы открылись корректно
    @Test
    public void  movieShotsElementCheck(){
        KinoMainPage kinoMainPage = PageFactory.initElements(driver, KinoMainPage.class);
        assertTrue("Неверный адрес гравной страницы", kinoMainPage.openMainPage());

        AfishaElement afishaElement = PageFactory.initElements(driver, AfishaElement.class);
        assertTrue("Компонента Афиши не найдена", afishaElement.isComponentPresent());

        String title = afishaElement.getAfishaArticleTitle(1);

        //Переход на страницу с фильмами
        Set<String> parentHandle = driver.getWindowHandles();
        MoviePage moviePage = afishaElement.clickAfishaMovie(title);
        Set<String> childHandle = driver.getWindowHandles();
        childHandle.remove(parentHandle);
        driver.switchTo().window(childHandle.iterator().next());

        //Проверка того, что произошел переход на страницу выбранного фильма
        String movieHeader = moviePage.getPageHeader();
        assertEquals("Названия фильмов не совпадают", title, movieHeader);


        TrailerAndShotsElement trailerAndShotsElement = PageFactory.initElements(driver, TrailerAndShotsElement.class);
        assertTrue("Компонента с кадрами не найдена", trailerAndShotsElement.isComponentPresent());

        ShotPage shotPage = trailerAndShotsElement.clickFirstShot(); //Страница с первым кадром
        assertTrue("Не открылась страница с кадром", shotPage.isPageCheck());

    }


    //Проверка функциональности слайдера Вправо
    @Test
    public void clickRightArrowCheck(){
        ShotPage shotPage = PageFactory.initElements(driver, ShotPage.class);
        shotPage.open();
        //НА всякий случай проверим, что открылась страница с кадром
        assertTrue("Не открылась страница с кадром", shotPage.isPageCheck());

        String currShotPageUrl = shotPage.getDriver().getCurrentUrl();
        ShotPage nextShotPage = shotPage.clickNextShotArrow();
        String nextShotPageUrl = nextShotPage.getDriver().getCurrentUrl();
        //Shot has changed
        assertTrue("Кадр не сменился после клика вперед",
                currShotPageUrl  != nextShotPageUrl);
    }

    //Проверка функциональности стрелки <- на слайдере
    @Test
    public void clickLeftArrowCheck(){
        ShotPage shotPage = PageFactory.initElements(driver, ShotPage.class);
        shotPage.open();
        //НА всякий случай проверим, что открылась страница с кадром
        assertTrue("Не открылась страница с кадром", shotPage.isPageCheck());

        String currShotPageUrl = shotPage.getDriver().getCurrentUrl();
        ShotPage previousShotPage = shotPage.clickNextShotArrow();
        String previousShotPageUrl = previousShotPage.getDriver().getCurrentUrl();
        //Shot has changed
        assertTrue("Кадр не сменился после клика назад",
                currShotPageUrl  != previousShotPageUrl);
    }
//Проверка того, что при нажатии вперед-назад вернемся к исходному кадру
    @Test
    public void clickRightLeftArrowsCheck(){
        ShotPage shotPage = PageFactory.initElements(driver, ShotPage.class);
        shotPage.open();
        //НА всякий случай проверим, что открылась страница с кадром
        assertTrue("Не открылась страница с кадром", shotPage.isPageCheck());

        String shotPageUrl = shotPage.getDriver().getCurrentUrl();
        ShotPage currShotPage = shotPage.clickRightLeftArrow();
        String currShotPageUrl = currShotPage.getDriver().getCurrentUrl();

        //Проверка того, что вернулись и исходному кадру
        assertEquals("Не произшел возврат на первоначальный кадр", shotPageUrl, currShotPageUrl);
    }


}

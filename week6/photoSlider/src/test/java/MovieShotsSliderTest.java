import components.AfishaElement;
import components.TrailerAndShotsElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
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

// Проверка того, что зашли на главную страницу
    @Test
    public void correctKinoMainPageCheck(){
        KinoMainPage kinoMainPage = PageFactory.initElements(driver, KinoMainPage.class);
        assertTrue("Неверный адрес гравной страницы", kinoMainPage.openMainPage());

        AfishaElement afishaElement = PageFactory.initElements(driver, AfishaElement.class);
        assertTrue("Компонента Афиши не найдена", afishaElement.isComponentPresent());

        String title = afishaElement.getAfishaArticleTitle(1);

        Set<String> parentHandle = driver.getWindowHandles();
        MoviePage moviePage = afishaElement.clickAfishaMovie(title);
        Set<String> childHandle = driver.getWindowHandles();

        childHandle.remove(parentHandle);
        driver.switchTo().window(childHandle.iterator().next());

        String movieHeader = moviePage.getPageHeader();
        assertEquals("Названия фильмов не совпадают", title, movieHeader);

        TrailerAndShotsElement trailerAndShotsElement = PageFactory.initElements(driver, TrailerAndShotsElement.class);
        ShotPage shotPage = trailerAndShotsElement.clickFirstShot(); //Current Shot Page
        String currShotPageUrl = shotPage.getDriver().getCurrentUrl();

        ShotPage nextShotPage = shotPage.clickNextShotArrow();
        String nextShotPageUrl = nextShotPage.getDriver().getCurrentUrl();
        //Shot has changed
        assertTrue("Кадр не сменился после клика вперед",
                currShotPageUrl  != nextShotPageUrl);

        ShotPage previousShotPage = shotPage.clickPreviousShotArrow();
        String previousShotPageUrl = previousShotPage.getDriver().getCurrentUrl();
        assertTrue("Кадр не сменился после клика назад",
                previousShotPageUrl != nextShotPageUrl);
        assertEquals("После нажатия вперед-назад не вернулись к исходному кадру",
                currShotPageUrl, previousShotPageUrl);

    }

}

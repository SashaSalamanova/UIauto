package mftiTest;

import components.HelpPetsElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import pages.PetsArticlePage;
import pages.PetsMainPage;
import pages.otherProjects.DobroPetsPage;

import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClickPetsDobroArticleTileTest {

    private WebDriver driver = null;

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

    @Test
    public void clickDobroPetsArticleTile(){
        PetsMainPage petsMainPage = PageFactory.initElements(driver, PetsMainPage.class);
        assertEquals("Название главной страницы не верное",
                "Все о питомцах",
                petsMainPage.openMainPage());

        HelpPetsElement helpPetsElement = PageFactory.initElements(driver, HelpPetsElement.class);
        helpPetsElement.isComponentPresent();
        String title = helpPetsElement.getPetsDobroTitle(1);

        String parentHandle = driver.getWindowHandle();
        PetsArticlePage petsArticlePage = helpPetsElement.clickPetsDobroArticleTile(title);

        for(String childHandle : driver.getWindowHandles()){
            if (!childHandle.equals(parentHandle)){
                driver.switchTo().window(childHandle);
            }
        }
        String articleHeader = petsArticlePage.getPageHeader();
        assertEquals("Названия статей не совпадают", title, articleHeader);

        DobroPetsPage dobroPetsPage = new DobroPetsPage(driver);
        assertTrue("Статья не на проекте Добро", dobroPetsPage.isPageCheck());

    }

}

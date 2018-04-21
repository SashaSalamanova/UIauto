import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PetsNewsPage;

import static org.junit.Assert.assertTrue;

public class ShowMoreButtonTest {

    private WebDriver driver;
    private List<WebElement> articlesBeforeShowMore;
    private List<WebElement> articlesAfterShowMore;
    private List<WebElement> articlesAfterSecondShowMore;
    private PetsNewsPage petsNewsPage;
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
    public void pressShowMoreButtonOnce(){
        petsNewsPage = PageFactory.initElements(driver, PetsNewsPage.class);
        petsNewsPage.open();
        articlesBeforeShowMore = petsNewsPage.getArticlesDisplayed();
        petsNewsPage.clickShowMoreButton();
        articlesAfterShowMore = petsNewsPage.getArticlesDisplayed();
        //Проверка того, что количество статей увеличилось
        assertTrue("Количество статей не увеличилось",
                articlesAfterShowMore.size() > articlesBeforeShowMore.size());
        //Проверка того, что на странице отображаются статьи, которые были до нажатия кнопки
        assertTrue("Новый список статей не содержит старые статьи",
                articlesAfterShowMore.containsAll(articlesBeforeShowMore));
        //Проверка того, что коичество статей увеличилось в 2 раза
        assertTrue("Количество статей увеличилось не в 2 раза",
                articlesAfterShowMore.size() == articlesBeforeShowMore.size()*2);
    }

    //Тест повторного нажатия кнопки "Показать еще"
    @Test
    public void pressShowMoreButtonMoreThanOnce(){
        petsNewsPage = PageFactory.initElements(driver, PetsNewsPage.class);
        petsNewsPage.open();
        //Получаем список статей до нажатия кнопки
        articlesBeforeShowMore = petsNewsPage.getArticlesDisplayed();

        petsNewsPage.clickShowMoreButton();
        //Получаем список статей после первого нажатия кнопки
        articlesAfterShowMore = petsNewsPage.getArticlesDisplayed();
        petsNewsPage.clickShowMoreButton();
        //Получаем список статей после второго нажатия кнопки
        articlesAfterSecondShowMore = petsNewsPage.getArticlesDisplayed();

        assertTrue("Количество статей после второго клика  не увеличилось",
                articlesAfterSecondShowMore.size() > articlesAfterShowMore.size());
        assertTrue("Новый список статей после первого клика не содержит старые статьи",
                articlesAfterSecondShowMore.containsAll(articlesBeforeShowMore)&&
                        articlesAfterSecondShowMore.containsAll(articlesAfterShowMore));
        assertTrue("Количество статей увеличилось не в 3 раза",
                articlesAfterSecondShowMore.size() == articlesBeforeShowMore.size()*3);
    }

}

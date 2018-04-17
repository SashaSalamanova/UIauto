import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class ShowMoreButtonTest {

    private WebDriver driver;
    private List<WebElement> articlesBeforeShowMore;
    private List<WebElement> articlesAfterShowMore;
    private Wait wait;
    private WebElement showMoreButton;

    @Before
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--no-first-run");
        chromeOptions.addArguments("--homepage=about:blank");
        chromeOptions.addArguments("--ignore-certificate-errors");

        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://pets.mail.ru/news/");
        showMoreButton = driver.findElement(By.cssSelector(".js-pgng_more_link"));
        wait = new WebDriverWait(driver, 20).withMessage("Количество статей не увеличилось");
    }

    @After
    public void close() {
        if(driver != null) {
            driver.quit();
        }
    }

    @Test
    public void pressOnceShowMoreButton(){
        articlesBeforeShowMore = driver.findElements(By.cssSelector(".js-pgng_item"));
        showMoreButton.click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".js-pgng_item"),
                articlesBeforeShowMore.size()));
        articlesAfterShowMore = driver.findElements(By.cssSelector(".js-pgng_item"));
        assertTrue("Количество статей не увеличилось",
                articlesAfterShowMore.size() > articlesBeforeShowMore.size());
    }

    @Test
    public void pressShowMoreButtonDoubleArticlesCount(){
        articlesBeforeShowMore = driver.findElements(By.cssSelector(".js-pgng_item"));
        showMoreButton.click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".js-pgng_item"),
                articlesBeforeShowMore.size()));
        articlesAfterShowMore = driver.findElements(By.cssSelector(".js-pgng_item"));
        assertTrue("Количество статей увеличилось не в 2 раза",
                articlesAfterShowMore.size() == articlesBeforeShowMore.size()*2);
    }
    @Test
    public void pressShowMoreButtonMoreThanOnce(){
        for(int i = 0; i < 3; i++){
            articlesBeforeShowMore = driver.findElements(By.cssSelector(".js-pgng_item"));
            showMoreButton.click();
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".js-pgng_item"),
                    articlesBeforeShowMore.size()));
        }
        articlesAfterShowMore = driver.findElements(By.cssSelector(".js-pgng_item"));
        assertTrue("Количество статей не увеличилось",
                articlesAfterShowMore.size() > articlesBeforeShowMore.size());
    }

    @Test
    public void pressShowMoreButtonMoreThanOnceArticlesCount(){
        articlesBeforeShowMore = driver.findElements(By.cssSelector(".js-pgng_item"));
        articlesAfterShowMore = articlesBeforeShowMore;
        for(int i = 0; i < 3; i++){
            showMoreButton.click();
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".js-pgng_item"),
                    articlesAfterShowMore.size()));
            articlesAfterShowMore= driver.findElements(By.cssSelector(".js-pgng_item"));
        }
        assertTrue("На странице неверное количество статей",
                articlesAfterShowMore.size() == articlesBeforeShowMore.size()*4);
    }

}

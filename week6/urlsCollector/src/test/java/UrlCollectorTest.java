import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import pages.UrlCollectPage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UrlCollectorTest {

    private WebDriver driver = null;
    private List<WebElement> referenceLinks;
    private List<WebElement> externalLinks;

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
    public void getUrls(){
        UrlCollectPage urlCollectPage = PageFactory.initElements(driver, UrlCollectPage.class);
        urlCollectPage.open();
        referenceLinks = urlCollectPage.getReferenceLinks();
        externalLinks = urlCollectPage.getExternalLinks();

        try {
            FileWriter writer = new FileWriter(System.getProperty("webdriver.result.collector"), false);
            writer.write("Внутренние ссылки (найдено" + referenceLinks.size() + ")\n");
            for(int i = 0; i < referenceLinks.size(); i++) {
                writer.write(referenceLinks.get(i).getAttribute("href") + "\n");
            }
            writer.write("\n" + "Внешние ссылки (найдено " + externalLinks.size() + ")\n");
            for(int i = 0; i < externalLinks.size(); i++) {
                writer.write(externalLinks.get(i).getAttribute("href") + "\n");
            }
            writer.flush();
        } catch (IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}

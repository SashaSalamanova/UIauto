import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import pages.CarsCatalogPage;
import steps.CarsCatalogPageSteps;


public class CarsCatalogTest {
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


    @Test
    public void carsByPriceSearchTest(){
        CarsCatalogPageSteps carsCatalogPage = new CarsCatalogPageSteps(driver);

        String catalog = "Каталог";

        carsCatalogPage.open(catalog);

        carsCatalogPage.findCars("1000000", "2000000");
    }

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage{

    private WebDriver driver = null;

    @FindBy(css = ".hdr_bold_huge .hdr__inner")
    private WebElement header;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    protected WebDriver getDriver() {
        return driver;
    }

    public void open() {
        getDriver().get(System.getProperty("webdriver.domain.url"));
        }

    public String getPageHeader() {
        return header.getText();
    }
}

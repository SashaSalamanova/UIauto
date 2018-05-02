package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.System.getProperty;

public class WaitTools {

    private WebDriver driver = null;

    public WaitTools(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForCondition(ExpectedCondition condition) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Long.parseLong(getProperty("webdriver.timeouts.implicitlywait")));
        try {
            webDriverWait.until(condition);
            return true;
        } catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

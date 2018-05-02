package navigation;

import org.openqa.selenium.WebDriver;
import tools.WaitTools;

import static org.junit.Assert.assertTrue;

public abstract class PageObject {

    private Class<?> pageClass = super.getClass();

    protected WaitTools waitTools;

    private WebDriver driver = null;


    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    protected String getPageUrl() {
        if(pageClass.isAnnotationPresent(Page.class))
            return System.getProperty("webdriver.domain.url") + pageClass.getAnnotation(Page.class).value();

        return "";
    }

    public void pageValidate() {
        if(pageClass.isAnnotationPresent(UrlPattern.class)) {
            String pattern = pageClass.getAnnotation(UrlPattern.class).value();
            assertTrue(String.format("URL страницы не соответствует шаблону %s", pattern),
                    driver.getCurrentUrl().matches("http[s]?.*?(?::\\d+)?/" + pattern + "/?"));
        }
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
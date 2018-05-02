package elements;

import data.AutoData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Component(css = ".filter__list")
public class FilterTestDriversElement extends ComponentObject {

    public FilterTestDriversElement(WebDriver driver) {
        super(driver);
    }

    private final String testdriversFilterTabLocator = "//a[contains(@class, 'filter__item')]//span[@class='filter__text'][text()='%s']";

    public boolean isFilterTabActive(AutoData autoData) {
        String locator = String.format(testdriversFilterTabLocator, autoData.getName());
        return waitTools.waitForCondition(ExpectedConditions.attributeContains(By.xpath(locator), "class", "filter__item_active"));
    }

    public boolean isFilterTabNotActive(AutoData autoData) {
        String locator = String.format(testdriversFilterTabLocator, autoData.getName());
        return waitTools.waitForCondition(ExpectedConditions.not(ExpectedConditions.attributeContains(By.xpath(locator), "class", "filter__item_active")));
    }

    public void clickFilterTab(AutoData autoData) {
        String locator = String.format(testdriversFilterTabLocator, autoData.getName());
        getDriver().findElement(By.xpath(locator)).click();
    }
}

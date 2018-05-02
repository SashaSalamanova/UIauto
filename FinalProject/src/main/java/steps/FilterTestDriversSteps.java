package steps;

import data.AutoData;
import elements.FilterTestDriversElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class FilterTestDriversSteps extends AbstractSteps {

    public FilterTestDriversSteps(WebDriver driver) {
        super(driver);
    }

    private FilterTestDriversElement filterTestDriversElement = null;

    private FilterTestDriversElement getFilterTestDriversElement() {
        if(filterTestDriversElement == null) filterTestDriversElement = PageFactory.initElements(getDriver(), FilterTestDriversElement.class);
        return filterTestDriversElement;
    }

    @Step("Проверяем, что вкладка {autoData.getName} активна в фильтре")
    public void filterTabShouldBeActive(AutoData autoData) {
        assertTrue(String.format("Вкладка фильтра %s должна быть активна", autoData.getName()),
                getFilterTestDriversElement().isFilterTabActive(autoData));
    }

    @Step("Проверяем, что вкладка {autoData.getName} не активна в фильтре")
    public void filterTabShouldNotBePresent(AutoData autoData) {
        assertTrue(String.format("Вкладка фильтра %s не должна быть активна", autoData.getName()),
                getFilterTestDriversElement().isFilterTabNotActive(autoData));
    }

    @Step("Кликаем на вкладку {autoData.getName}")
    public void clickFilterTab(AutoData autoData) {
        getFilterTestDriversElement().clickFilterTab(autoData);
    }
}

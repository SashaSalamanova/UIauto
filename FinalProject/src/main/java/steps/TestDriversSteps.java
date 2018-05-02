package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AutoTestDriversPage;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDriversSteps extends AbstractSteps{

    private AutoTestDriversPage autoTestDriversPage = null;

    public TestDriversSteps(WebDriver driver) {
        super(driver);
        autoTestDriversPage = PageFactory.initElements(driver, AutoTestDriversPage.class);
    }

    @Step("Получаем заголовок страницы")
    private void pageHeaderShouldBeSameAs(String header) {
        assertEquals("На странице отображается неверный заголовок",
                header,
                autoTestDriversPage.getPageHeader());
    }

    @Step("Открываем страницу {header}")
    public void open(String header) {
        autoTestDriversPage.open();
        autoTestDriversPage.pageValidate();
        pageHeaderShouldBeSameAs(header);
    }

    @Step("Получаем названия всех статей на странице")
    public List<String> getAllArticlesTitles() {
        return autoTestDriversPage.getAllArticlesTitles();
    }

    @Step("Проверяем, что список статей на странице изменился и не соответствует списку {titles}")
    public void articlesTitlesShouldBeChanged(List<String> titles) {
        assertTrue("Список статей на странице должен измениться",
                autoTestDriversPage.isArticlesTitlesChanged(titles));
    }
}

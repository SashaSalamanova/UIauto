import data.AutoData;
import driver.DriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.FilterTestDriversSteps;
import steps.TestDriversSteps;

import java.util.Arrays;
import java.util.List;

public class ClickComparativeFilterTabTest {

    private DriverProvider driverProvider = null;

    @Before
    public void initDriver() {
        driverProvider = new DriverProvider();
    }

    @After
    public void closeDriver() {
        driverProvider.closeDriver();
    }

    @Test
    public void clickComparativeFilterTab() {
        //Открываем страницу
        TestDriversSteps testDriversSteps = new TestDriversSteps(driverProvider.getDriver());
        testDriversSteps.open("Тест-драйвы");

        //Получаем названия всех статей на странице
        List<String> titles = testDriversSteps.getAllArticlesTitles();

        //Проверяем, что вкладка "Все материалы" активна
        FilterTestDriversSteps filterTestDriversSteps = new FilterTestDriversSteps(driverProvider.getDriver());
        filterTestDriversSteps.filterTabShouldBeActive(AutoData.All);

        //Кликаем на вкладку "Сравнительные тесты"
        filterTestDriversSteps.clickFilterTab(AutoData.Comprative);

        //Проверяем, что вкладка "Сравнительные тесты" активна
        filterTestDriversSteps.filterTabShouldBeActive(AutoData.Comprative);

        //Проверяем, что остальные вкладки не активны
        Arrays.stream(AutoData.values())
                .filter(pet -> pet != AutoData.Comprative)
                .forEach(pet -> filterTestDriversSteps.filterTabShouldNotBePresent(pet));

        //Проверяем, что список статей на странице изменился
        testDriversSteps.articlesTitlesShouldBeChanged(titles);
    }
}

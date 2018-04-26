package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.CarsCatalogPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarsCatalogPageSteps extends AbstractSteps{

    private CarsCatalogPage carsCatalogPage = null;

    public CarsCatalogPageSteps (WebDriver driver){
        super(driver);
        carsCatalogPage = PageFactory.initElements(getDriver(), CarsCatalogPage.class);
    }

    @Step("Проверяем то, что открылась верная страница")
    private void pageShouldHaveCorractUrl(){
        assertTrue("Страница не является каталогом машин",  carsCatalogPage.pageUrlCheck());
    }

    @Step("Проверяем, что у страницы верный заголовок")
    private void pageHeaderShouldBeSameAs(String header) {
        assertEquals("На странице отображается неверный заголовок",
                header,
                carsCatalogPage.getPageHeader());
    }

    @Step("Открываем страницу")
    public void open(String header){
        carsCatalogPage.open();
        pageShouldHaveCorractUrl();
        pageHeaderShouldBeSameAs(header);
    }

    @Step("Проверяем, что в поля введены верные значения")
    private void priceFieldValueCheck(String minPrice, String maxPrice){
        assertEquals("Введена неверная минимальная цена", minPrice,
                carsCatalogPage.getPriceFieldValue("min"));
        assertEquals("Введена неверная максимальная цена", maxPrice,
                carsCatalogPage.getPriceFieldValue("max"));
    }

    @Step("Вводим максимальную и минимальную стоимость и нажимам подобрать")
    public void findCars(String minPrice, String maxPrice){
        carsCatalogPage.setPriceField("min", minPrice);
        carsCatalogPage.setPriceField("max", maxPrice);
        priceFieldValueCheck(minPrice, maxPrice);
        carsCatalogPage.clickFindButton();
    }

}

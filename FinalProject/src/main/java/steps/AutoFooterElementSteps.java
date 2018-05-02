package steps;

import elements.AutoMainPageFooterElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AutoCommentsPage;
import pages.AutoMainPage;
import pages.MailMainPage;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AutoFooterElementSteps extends AbstractSteps {

    private AutoMainPage autoMainPage = null;
    private MailMainPage mailMainPage = null;
    private AutoMainPageFooterElement autoMainPageFooterElement = null;
    private Set<String> parentHandle;
    private Set<String> childHandle;

    public AutoFooterElementSteps (WebDriver driver) {
        super(driver);
        autoMainPage = PageFactory.initElements(driver, AutoMainPage.class);
    }

    @Step("Получаем заголовок страницы")
    private void pageHeaderShouldBeSameAs(String header) {
        assertEquals("На странице отображается неверный заголовок",
                header,
                autoMainPage.getPageHeader());
    }

    @Step("Открываем страницу {header}")
    public void open(String header) {
        autoMainPage.open();
        autoMainPage.pageValidate();
       // pageHeaderShouldBeSameAs(header);
    }

    @Step("Проверяяем наличие элемента на странице")
    private void footerElementIsPresent(){
        autoMainPageFooterElement.componentValidate();
    }


    @Step("Проверка перехрда на главную страницу компании")
    private void mainMailRuPageCheck(){
        assertTrue("Неверный адрес главной страницы", mailMainPage.isPageCheck());
    }

    @Step("Клик по ссылке и переход на главную страницу компании")
    public void goToMainMailRuPage(){
        //parentHandle = getDriver().getWindowHandles();
        autoMainPageFooterElement = PageFactory.initElements(getDriver(), AutoMainPageFooterElement.class);
        footerElementIsPresent();
        mailMainPage = autoMainPageFooterElement.clickAboutCompanyLink();
        //childHandle = getDriver().getWindowHandles();
        //childHandle.remove(parentHandle);
        //getDriver().switchTo().window(childHandle.iterator().next());
        mainMailRuPageCheck();
    }

}

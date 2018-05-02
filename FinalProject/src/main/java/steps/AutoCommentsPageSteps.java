package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.AutoCommentsPage;

import java.util.List;

import static org.junit.Assert.*;

public class AutoCommentsPageSteps extends AbstractSteps{

    private AutoCommentsPage autoCommentsPage = null;
    //private  AutoCommentsPage nextAutoCommentsPage = null;
    private List<WebElement> commentListBeforeClick;
    private List<WebElement> commentListAfterClick;

    public AutoCommentsPageSteps(WebDriver driver) {
        super(driver);
        autoCommentsPage = PageFactory.initElements(driver, AutoCommentsPage.class);
    }

    @Step("Получаем заголовок страницы")
    private void pageHeaderShouldBeSameAs(String header) {
        assertEquals("На странице отображается неверный заголовок",
                header,
                autoCommentsPage.getPageHeader());
    }

    @Step("Открываем страницу {header}")
    public void open(String header) {
        autoCommentsPage.open();
        autoCommentsPage.pageValidate();
        pageHeaderShouldBeSameAs(header);
    }

    @Step("Проверяем что кнопка перехода на следующую страницу доступна")
    private void nextCommentPageShouldBeDisplayed(){
        assertTrue("Нет кнопки перехода на следующую страницу", autoCommentsPage.isArrowPresent());
    }

    @Step("Клик на кнопку перехода на следующую страницу")
    private void nextPageClick(){
        nextCommentPageShouldBeDisplayed();
        autoCommentsPage.nextCommentPageClick();
    }

    @Step("Проверяем, что выделеный номер страницы равен 2")
    private void secondNumberShouldBeSelected(){
        assertEquals("На странице не выделен номер 2", "2",
                autoCommentsPage.getActiveCommentPageNumber());
    }

    @Step("Проверяем, что список комментариев изменился")
    private void listOfCommentsShouldChange(List<WebElement> commentListBeforeClick, List<WebElement> commentListAfterClick){

        assertFalse("Новый список коментариев не должен содержать старые",
                commentListAfterClick.contains(commentListBeforeClick));
    }

    @Step("Переход на вторую страницу, выделен нужный номер страницы")
    public void goToSecondPage(){
        //commentListBeforeClick = autoCommentsPage.getCommentList();
        nextPageClick();
        secondNumberShouldBeSelected();
        //commentListAfterClick = nextAutoCommentsPage.getCommentList();
        //listOfCommentsShouldChange(commentListBeforeClick, commentListAfterClick);
    }

}

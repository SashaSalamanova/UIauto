package pages;

import navigation.Page;
import navigation.UrlPattern;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.util.List;

@Page("comments/64294/")
@UrlPattern("comments/64294")
public class AutoCommentsPage extends BasePage {

    public AutoCommentsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ".icon_paging_next")
    private WebElement nextCommentPageArrow;

    @FindBy(css = ".comments-paging__item_active")
    private WebElement activeCommentPageNumber;

    @FindBy(css = ".js-comments_comment")
    private List<WebElement> commentList;

    public boolean isArrowPresent(){
        return nextCommentPageArrow.isDisplayed();
    }

    public void nextCommentPageClick(){
        nextCommentPageArrow.click();
        nextCommentPageArrow.sendKeys(Keys.F5);
        //getDriver().navigate().refresh();
        //return PageFactory.initElements(getDriver(),  AutoCommentsPage.class);
    }

    public String getActiveCommentPageNumber(){
        return activeCommentPageNumber.getAttribute("data-page");
    }

    public List<WebElement> getCommentList(){
        return commentList;
    }
}

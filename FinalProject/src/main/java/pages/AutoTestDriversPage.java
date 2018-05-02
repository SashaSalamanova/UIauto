package pages;

import navigation.Page;
import navigation.UrlPattern;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import java.util.stream.Collectors;


@Page("testdrives/")
@UrlPattern("testdrives/")
public class AutoTestDriversPage extends BasePage {

    public AutoTestDriversPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@href, 'article/')]/span/span")
    private List<WebElement> articles;

    public List<String> getAllArticlesTitles() {
        return articles.stream()
                .map(WebElement::getText)
                .limit(14)
                .collect(Collectors.toList());
    }


    public boolean isArticlesTitlesChanged(List<String> titles) {
        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return getAllArticlesTitles() != titles;
            }
        };
        return waitTools.waitForCondition(condition);
    }
}

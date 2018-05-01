package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InstagramFrameComponent {
    private WebDriver driver;
    private Wait wait;

    public InstagramFrameComponent(WebDriver driver) {
        this.driver = driver;
    }
    private String instaFrameLocator = "//iframe[contains(@class, 'instagram-media-rendered')]";

    @FindBy(css = ".coreSpriteRightChevron")
    private WebElement rightArrow;

    @FindBy(css = ".coreSpriteLeftChevron")
    private WebElement leftArrow;

    @FindBy(xpath = "//div[contains(@class, 'EmbedSidecar')]/div/div/div/div/img")
    private WebElement imageSrc;

    public void switchToInstaFrame(){
        wait = new WebDriverWait(driver,  Long.parseLong(System.getProperty("webdriver.timeouts.implicitlywait"))).withMessage("Время ожидания превышено");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(instaFrameLocator)));
    }

    public boolean isRightArrowPresent(){
        return rightArrow.isEnabled();
    }

    public void clickRightArrow(){
        rightArrow.click();
    }

    public boolean isLeftArrowPresent(){
        return leftArrow.isEnabled();
    }

    public void clickLeftArrow(){
        leftArrow.click();
    }

    public String getImageSrc(){
        return imageSrc.getAttribute("src");
    }

}

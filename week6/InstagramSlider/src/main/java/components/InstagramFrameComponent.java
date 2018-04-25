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
    private WebElement rightPhotoArrow;
    private WebElement leftPhotoArrow;
    private String instaFrameLocator = "//iframe[contains(@class, 'instagram-media-rendered')]";

    public void switchToInstaFrame(){
        wait = new WebDriverWait(driver,300).withMessage("Время ожидания превышено");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(instaFrameLocator)));
    }

    public boolean isRightArrowPresent(){
        return driver.findElement(By.cssSelector(".coreSpriteRightChevron")).isEnabled();
    }
    public void clickRightArrow(){
        rightPhotoArrow = driver.findElement(By.cssSelector(".coreSpriteRightChevron"));
        rightPhotoArrow.click();
    }

    public boolean isLeftArrowPresent(){
        return driver.findElement(By.cssSelector(".coreSpriteLeftChevron")).isEnabled();
    }

    public void clickLeftArrow(){
        leftPhotoArrow = driver.findElement(By.cssSelector(".coreSpriteLeftChevron"));
        leftPhotoArrow.click();
    }

    public String getImageSrc(){
        return driver.findElement(By.xpath("//div[contains(@class, 'EmbedSidecar')]/div/div/div/div/img"))
                .getAttribute("src");
    }

}

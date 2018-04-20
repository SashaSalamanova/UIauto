package mftiTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoMainPage extends BasePage {
    //private WebDriver driver;

    AutoMainPage(WebDriver driver){
        super(driver);
    }
    private WebElement addReview = super.driver.findElement(By.cssSelector(".button_color_project"));

    public void clickAddReview(){
        addReview.click();
    }
}

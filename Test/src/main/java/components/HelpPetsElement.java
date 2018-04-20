package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.PetsArticlePage;
import java.util.stream.*;

import java.util.List;
import java.util.stream.Collectors;

public class HelpPetsElement {
    private WebDriver driver;

    public HelpPetsElement(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".pets-dobro")
    private WebElement component;
    // @FindBy(css = ".pets-dobro .pypo-item__title")
    //private List<WebElement> dobroItemsTitles;
    private final String petsDobroItemTitleLocator =  "//*[contains(@class, 'pets-dobro')]//*[contains(@class, 'pypo-item__title')]";
    private final String petsDobroItemTileByTitleLocator = petsDobroItemTitleLocator + "[text()='%s']/ancestor::div[contains(@class, 'pypo-item_dobro')]";


    public String getPetsDobroTitle(int index){
        return driver.findElements(By.xpath(petsDobroItemTitleLocator)).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList()).get(--index);
    }


    public PetsArticlePage clickPetsDobroArticleTile(String title){
        String locator = String.format(petsDobroItemTileByTitleLocator, title);
        driver.findElement(By.xpath(locator)).click();
        return PageFactory.initElements(driver, PetsArticlePage.class);
    }

    public boolean isComponentPresent() {
        return component.isDisplayed();
    }



}
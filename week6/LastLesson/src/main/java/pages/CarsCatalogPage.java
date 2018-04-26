package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarsCatalogPage extends BasePage{

    public CarsCatalogPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ".button_full")
    private WebElement findCarsButton;

    private Pattern pagePattern = Pattern.compile("https://cars.mail.ru/catalog");
    private WebElement priceField;
    private String priceFieldByTypeLocator = "";

    private WebElement getPriceFieldByLocator(String fieldType){
        priceFieldByTypeLocator = "//input[@name = '" + fieldType +"_price']";
        return getDriver().findElement(By.xpath(priceFieldByTypeLocator));
    }

    public boolean pageUrlCheck(){
        Matcher matcher = pagePattern.matcher(getDriver().getCurrentUrl());
        return matcher.find();
    }


    public void setPriceField(String fieldType, String price){
        switch (fieldType){
            case "min": getPriceFieldByLocator(fieldType).sendKeys(price);
                        break;
            case "max": getPriceFieldByLocator(fieldType).sendKeys(price);
                        break;
        }
    }

    public void clickFindButton(){
        findCarsButton.click();
    }

    public String getPriceFieldValue(String fieldType) {
        String price = "";
        switch (fieldType) {
            case "min":
                price = getPriceFieldByLocator(fieldType).getAttribute("value");
                break;
            case "max":
                price = getPriceFieldByLocator(fieldType).getAttribute("value");
                break;
        }
        return price;
    }
}

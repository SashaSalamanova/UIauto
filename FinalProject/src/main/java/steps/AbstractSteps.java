package steps;

import navigation.PageObject;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSteps extends PageObject {

    public AbstractSteps(WebDriver driver) {
        super(driver);
    }
}

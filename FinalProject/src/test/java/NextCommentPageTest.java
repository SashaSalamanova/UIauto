import driver.DriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.AutoCommentsPage;
import steps.AutoCommentsPageSteps;

import java.util.List;

public class NextCommentPageTest {

    private DriverProvider driverProvider = null;

    @Before
    public void initDriver() {
        driverProvider = new DriverProvider();
    }

    @After
    public void closeDriver() {
        driverProvider.closeDriver();
    }

    @Test
    public void secondCommentPageTest(){
        AutoCommentsPageSteps autoCommentsPage = new AutoCommentsPageSteps(driverProvider.getDriver());
        String title = "Игрушки второй свежести — самый крутой секонд-хэнд";
        autoCommentsPage.open(title);

        autoCommentsPage.goToSecondPage();
    }
}

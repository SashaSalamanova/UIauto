import driver.DriverProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.AutoFooterElementSteps;

public class AutoFooterAboutcompanyTest {
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
    public void aboutCompanyLinkTest(){

        AutoFooterElementSteps autoFooterElementSteps = new AutoFooterElementSteps(driverProvider.getDriver());

        String title = "Авто Mail.ru";
        autoFooterElementSteps.open(title);

        autoFooterElementSteps.goToMainMailRuPage();

    }
}

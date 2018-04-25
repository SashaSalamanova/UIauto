import components.InstagramFrameComponent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import pages.IncidentPage;

import static org.junit.Assert.*;

public class InstagramSliderTest {
    private WebDriver driver;

    @Before
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--no-first-run");
        chromeOptions.addArguments("--homepage=about:blank");
        chromeOptions.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(chromeOptions);

    }

    @After
    public void close() {
        if(driver != null) {
            driver.quit();
        }
    }

    @Test
    public void instagramSliderCheck (){

        //Страница с новостью
        IncidentPage incidentPage = PageFactory.initElements(driver, IncidentPage.class);
        incidentPage.open();

        //Компонента, содержащая врез инстаграма
        InstagramFrameComponent instagramFrameComponent = PageFactory.initElements(driver, InstagramFrameComponent.class);
        instagramFrameComponent.switchToInstaFrame();

        //Проверка того, что стралка "Вправо" присутствует
        assertTrue("Должна быть возможность листать вперед", instagramFrameComponent.isRightArrowPresent());

        String currImageSrc = instagramFrameComponent.getImageSrc();
        instagramFrameComponent.clickRightArrow();
        String  nextImageSrc = instagramFrameComponent.getImageSrc();

        //Сравнение изображений после одного клика вправо
        assertNotEquals("Изображения не должны совпадать после одного клика вправо", currImageSrc, nextImageSrc);

        instagramFrameComponent.clickLeftArrow();
        String previousImageSrc = instagramFrameComponent.getImageSrc();

        //Сравнение изображений после возвращения на исходное фото
        assertNotEquals("Текущее и предыдущее изображения не долны совпадать", previousImageSrc, nextImageSrc);
        assertEquals("После слайда вперед и затем назад, изображение не должно измениться", currImageSrc, previousImageSrc);

    }

    //Проверка отсутсвия стрелочек там, где их быть не должно
    @Test(expected = WebDriverException.class)
    public void onFirstPhotoLeftArrowIsNotPresent(){
        IncidentPage incidentPage = PageFactory.initElements(driver, IncidentPage.class);
        incidentPage.open();
        InstagramFrameComponent instagramFrameComponent = PageFactory.initElements(driver, InstagramFrameComponent.class);
        instagramFrameComponent.switchToInstaFrame();

        assertTrue("На первом изображении должна отсутствовать возможность листать назад",
                instagramFrameComponent.isLeftArrowPresent());
    }

    //Пролистываем фото до конца, проверяем что стрелка "Вперед" отсутствует
    @Test(expected = WebDriverException.class)
    public void onLastPhotoRightArrowIsNotPresent(){
        IncidentPage incidentPage = PageFactory.initElements(driver, IncidentPage.class);
        incidentPage.open();
        InstagramFrameComponent instagramFrameComponent = PageFactory.initElements(driver, InstagramFrameComponent.class);
        instagramFrameComponent.switchToInstaFrame();

        for (int i = 0; i < 3; i++){
            instagramFrameComponent.clickRightArrow();
        }
        assertFalse("После пролистывания всех фото вправо, стрелка '->' не исчезла",
                instagramFrameComponent.isRightArrowPresent());
    }
}

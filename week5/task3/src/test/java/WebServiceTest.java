import org.mockito.Mockito;
import org.junit.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WebServiceTest extends Mockito{
    private static WebServiceForTest mockWebService;

    @BeforeClass
    public static void init(){
        mockWebService = new WebServiceForTest();
        mockWebService = mock(WebServiceForTest.class);
        //Ожидаемое поведение для метода getUserEmail(int id)
        when(mockWebService.getUserEmail(999)).thenReturn("userLAla_la@mail.ru");
        when(mockWebService.getUserEmail(777)).thenReturn("sasha_salamanova@mail.ru");
        //Ожидаемое поведение для метода getCurrentUrl()
        when(mockWebService.getCurrentUrl()).thenReturn("https://pets.mail.ru/");
        //Ожидаемое поведение для метода isRegisteredUser(String email)
        when(mockWebService.isRegisteredUser("sasha_salamanova@mail.ru")).thenReturn(true);
        when(mockWebService.isRegisteredUser("someRandom_person@mail.ru")).thenReturn(false);

    }

    @Test
    public void getUserEmailReturnsEmail() {
        Pattern pattern = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");
        Matcher matcher = pattern.matcher(mockWebService.getUserEmail(777));
        Assert.assertTrue("Возвращаемая строка не является email адресом", matcher.find());
    }
    @Test
    public void getUserEmailShouldReturnProperEmail() {
        Assert.assertNotEquals("Email не соответствует заданному id",
                                "userLAla_la@mail.ru", mockWebService.getUserEmail(777));
    }

    @Test
    public void getCurrentUrlShouldReturnUrl(){
        Pattern pattern = Pattern.compile("http[s]?://.*?(?::\\\\d+)?");
        Matcher matcher = pattern.matcher(mockWebService.getCurrentUrl());
        Assert.assertTrue("Возвращаемая строка не является url", matcher.find());
    }

    @Test
    public void isRegisteredUserShouldReturnTrueForRegisteredUser(){
        Assert.assertTrue("Пользователь зарегистрирован",
                            mockWebService.isRegisteredUser("sasha_salamanova@mail.ru"));
    }

    @Test
    public void isRegisteredUserShouldReturnFalseForUnregisteredUser(){
        Assert.assertFalse("Пользователь незарегистрирован",
                mockWebService.isRegisteredUser("someRandom_person@mail.ru"));
    }
}

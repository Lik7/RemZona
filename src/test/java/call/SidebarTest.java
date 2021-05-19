package call;

import base.BaseTest;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class SidebarTest extends BaseTest {

    @Test
    @Step("Тест номер телефона в боковом меню")
    public void clickPhoneNumberTest(){
        homePage.clickMenuBtn();
        homePage.clickPhoneNumberInMenu();
        homePage.clickCloseMenuBtn();
    }

}

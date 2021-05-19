package vacancy;

import base.BaseTest;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.DrivingDirections;

public class VacancyTest extends BaseTest {

    @Test
    @Step("Подать заявку на вакансию менеджер")
    public void vacancyManagerTest() {
        homePage.clickMenuBtn();

        DrivingDirections drivingDirections = homePage.clickDrivingDirectionsBtn();
        drivingDirections.clickVacancyLink();
        drivingDirections.clickVacancyManagerLink();
        drivingDirections.clickSendRequestBtn();
        drivingDirections.inputNameField("Andrey");
        drivingDirections.inputPhoneNumber("123456789");
        drivingDirections.clickClosedVacancyBtn();
    }

}

package addCarToGarage;

import base.BaseTest;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class AddCarToGarageTest extends BaseTest {

    @Test
    @Step("Тест: добавить авто в гараж")
    public void testAddCarToGarage() {
        hoverElement(homePage.getGarage());//навожу курсор на кнопку Гараж
        homePage.addCarButtonClick();
        homePage.addYearOfCar();
        homePage.addModelCar();
        homePage.addSubModelCar();
        homePage.addEngineCar();
        //System.out.println(homePage.getCarFromGarage());
        Assert.assertEquals(homePage.getCarFromGarage(), "TOYOTA CAMRY 2.0 vvt-i\n" +
                "1 998 см.куб. бензин, 147 лс 1AZ-FE выпуск с 2006/01 до 2011/09");
    }

    @Test
    @Step("Тест: удалить авто из гаража")
    public void testDeleteCarFromGarage(){
        Assert.assertEquals(homePage.getCarFromGarage(), "TOYOTA CAMRY 2.0 vvt-i\n" +
                "1 998 см.куб. бензин, 147 лс 1AZ-FE выпуск с 2006/01 до 2011/09", "Авто нет в гараже");
homePage.deleteFromGarage();
        System.out.println(homePage.getCarFromGarage());

    }

}

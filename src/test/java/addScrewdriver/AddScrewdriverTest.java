package addScrewdriver;

import base.BaseTest;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ElektroinstrumentPage;
import pages.ToolsPage;

public class AddScrewdriverTest extends BaseTest {

    @Test
    @Step("Добавляем шуруповерт в корзину")
    public void testAddScrewdriver() {
        ToolsPage toolsPage = homePage.clickToolsBtn();
        toolsPage.clickElektroToolsBtn();
        ElektroinstrumentPage elektroinstrumentPage = new ElektroinstrumentPage(toolsPage.getDriver());
        elektroinstrumentPage.clickScrewdriverLink();
        elektroinstrumentPage.clickСheckboxMakita();
        elektroinstrumentPage.addScrewdriverMakita();
        String modelScrewdriver = elektroinstrumentPage.getModelScrewdriverMakita();
        Assert.assertEquals(modelScrewdriver, elektroinstrumentPage.getModelItemInBasketWindow());
        elektroinstrumentPage.clickCloseCartBtn();
    }

    @Test
    @Step("Удаление товара из корзины")
    public void testDeleteItemFromBasket() {
        ToolsPage toolsPage = homePage.clickToolsBtn();
        ElektroinstrumentPage elektroinstrumentPage = new ElektroinstrumentPage(toolsPage.getDriver());
        elektroinstrumentPage.clickBasket();
        elektroinstrumentPage.clickDeleteItemFromBasketBtn();
        Assert.assertEquals(elektroinstrumentPage.getNumberOfGoodsFromBasket(), "0");
    }
}

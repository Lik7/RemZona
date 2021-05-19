package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElektroinstrumentPage {
    WebDriver driver;

    private By screwdriver = By.cssSelector(".showcase-list [href=\"/shurupovert\"]");
    private By checkboxMakita = By.cssSelector("[data-brand=\"makita\"]");
    private By modelScrewdriverMakita = By.cssSelector(".article-caption-title [href=\"/makita/td0101\"]");
    private By buyTD0101MakitaBtn = By.cssSelector("[data-sar_id=\"6940170\"]");
    private By closeCartBtn = By.cssSelector(".mb_content_wrap > i");
    private By basket = By.className("fa-shopping-cart");
    private By deleteItemFromBasketBtn = By.className("cart-item-remove");
    private By numberOfGoodsFromBasket = By.cssSelector(".shopcart-checkout-summary-quantity > span");

    public ElektroinstrumentPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать ссылку Шуруповерт")
    public void clickScrewdriverLink() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(screwdriver));
        driver.findElement(screwdriver).click();
    }

    @Step("Отметить checkbox Makita")
    public void clickСheckboxMakita() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(checkboxMakita));
        driver.findElement(checkboxMakita).click();
    }

    @Step("Добавляем Шуруповерт сетевой ударный TD 0101 MAKITA TD0101 в корзину")
    public void addScrewdriverMakita() {
        WebElement webElement = driver.findElement(modelScrewdriverMakita);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(modelScrewdriverMakita));
        driver.findElement(buyTD0101MakitaBtn).click();
    }

    @Step("Закрыть окно Корзина")
    public void clickCloseCartBtn() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(closeCartBtn));
        driver.findElement(closeCartBtn).click();
    }

    @Step("Нажать Корзина")
    public void clickBasket() {
        driver.findElement(basket).click();
    }

    @Step("Нажать кнопку удалить товар")
    public void clickDeleteItemFromBasketBtn() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(deleteItemFromBasketBtn));
        driver.findElement(deleteItemFromBasketBtn).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-bigger")));
    }

    //получить кол-во товаров в корзине
    public String getNumberOfGoodsFromBasket() {
        return driver.findElement(numberOfGoodsFromBasket).getText();
    }

    //получить модель инструмента из прайс-листа
    public String getModelScrewdriverMakita() {
        return driver.findElement(By.cssSelector(".article-caption-title [href=\"/makita/td0101\"]")).getText();
    }

    //получить модель инструмента из корзины
    public String getModelItemInBasketWindow() {
        return driver.findElement(By.cssSelector(".article-caption-title [href=\"/makita/td0101\"]")).getText();
    }
}

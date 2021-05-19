package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DrivingDirections {
    WebDriver driver;

    private By vacancy = By.cssSelector(".category-section-list [href=\"/company/vacancy\"]");
    private By vacancyManager = By.linkText("Менеджер по подбору автозапчастей");
    private By sendRequestBtn = By.xpath("//*[@class='btn btn-default mobile-full-width']/span");
    private By nameField = By.name("first_name");
    private By phoneField = By.name("phone_number");
    private By closedBtn = By.xpath("//*[@class=\"ui-button ui-corner-all ui-widget\"]");

    public DrivingDirections(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать ссылку Вакансии")
    public void clickVacancyLink() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(vacancy));
        driver.findElement(vacancy).click();
    }

    @Step("Нажать ссылку Менеджер по подбору автозапчастей")
    public void clickVacancyManagerLink() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(vacancyManager));
        driver.findElement(vacancyManager).click();
    }

    @Step("Нажать кнопку Отправить заявку")
    public void clickSendRequestBtn() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(sendRequestBtn));
        driver.findElement(sendRequestBtn).click();
    }

    @Step("Вводим имя в поле заявки на вакансию")
    public void inputNameField(String name) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Вводим номер телефона в поле заявки на вакансию")
    public void inputPhoneNumber(String number) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(phoneField));
        driver.findElement(phoneField).sendKeys(number);
    }

    @Step("Нажать кнопку Отправить заявку")
    public void clickClosedVacancyBtn() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(closedBtn));
        driver.findElement(closedBtn).click();
    }
}

package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    private By garage = By.cssSelector(".nav-extended > .fa-car");
    private By addCarButton = By.cssSelector(".dropdown-menu-cars-action > .btn-primary");
    private By yearOfCar2010 = By.cssSelector(".dropdown-menu > li:nth-child(13)");
    private By modelCarToyota = By.cssSelector("div > ul > li:nth-child(50)");
    private By subModelCarCamry = By.cssSelector("div.bs-container.btn-group.bootstrap-select.select.opened.btn-active.open > div > ul > li:nth-child(7)");
    private By typeEngineCar = By.cssSelector("div.bs-container.btn-group.bootstrap-select.select.opened.btn-active.open > div > ul > li:nth-child(2)");
    private By carFromGarage = By.className("garage-select");
    private By carDeleteFromGarageBtn = By.cssSelector(".pointer > i");
    private By toolsBtn = By.cssSelector("div.navbar-before-select > ul > li:nth-child(2) > a");
    //private By toolsBtn = By.cssSelector("[href=\"/tools\"] ");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public By getGarage() {
        return garage;
    }

    @Step("Нажимаем добавить авто в гараж")
    public void addCarButtonClick() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addCarButton));
        driver.findElement(addCarButton).click();
    }

    @Step("Выбираем год выпуска автомобиля")
    public void addYearOfCar() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mb_content")));
        WebElement webElement = driver.findElement(By.cssSelector(".dropdown-menu > li:nth-child(13)"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        driver.findElement(yearOfCar2010).click();
    }

    @Step("Выбираем марку автомобиля")
    public void addModelCar() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("filter-option")));
        WebElement webElement = driver.findElement(By.cssSelector("div > ul > li:nth-child(48)"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        driver.findElement(modelCarToyota).click();
    }

    @Step("Выбираем марку автомобиля")
    public void addSubModelCar() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("filter-option")));
        //WebElement webElement = driver.findElement(By.cssSelector("div > ul > li:nth-child(48)"));
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        driver.findElement(subModelCarCamry).click();
    }

    @Step("Выбираем двигатель автомобиля")
    public void addEngineCar() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("filter-option")));
        //WebElement webElement = driver.findElement(By.cssSelector("div > ul > li:nth-child(48)"));
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        driver.findElement(typeEngineCar).click();
    }

    @Step("Удалить автомобиль из гаража")
    public void deleteFromGarage(){
        driver.findElement(carFromGarage).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(carDeleteFromGarageBtn));
        driver.findElement(carDeleteFromGarageBtn).click();
    }

//получить данные авто из гаража
    public String getCarFromGarage() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(carFromGarage));
        return driver.findElement(carFromGarage).getText();
    }

    @Step("Нажать кнопку Инструмент")
    public ToolsPage clickToolsBtn(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(toolsBtn));
        driver.findElement(toolsBtn).click();
        return new ToolsPage(driver);
    }
}

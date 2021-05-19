package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolsPage {
    WebDriver driver;

    private By elektroToolsBtn = By.cssSelector(".showcase-note [href=\"/tools-elektroinstrument\"]");

    public ToolsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать кнопку Электроинструмент")
    public ElektroinstrumentPage clickElektroToolsBtn() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".showcase-note [href=\"/tools-elektroinstrument\"]")));
        driver.findElement(elektroToolsBtn).click();
        return new ElektroinstrumentPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }
}

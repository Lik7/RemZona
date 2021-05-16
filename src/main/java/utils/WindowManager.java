package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack() {
        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void refresh() {
        navigate.refresh();
    }

    public void goToURL(String url) {
        navigate.to(url);
    }

    //метод переключения по вкладкам
    public void switchToTab(String tabTitle) {
        Set<String> windows = driver.getWindowHandles();
        System.out.println("Number of tabs: " + windows.size());
        System.out.println("Tabs titles: ");
        windows.forEach(System.out::println);

        for (String win : windows){
            System.out.println("Switching to tab" + win);
            driver.switchTo().window(win);//переключаемся на окно по заголовку

            System.out.println("Tab title is " + driver.getTitle());
            if (tabTitle.equals(driver.getTitle())){
                break;
            }
        }
    }
    // ctrl click tests
    public void switchToLastTab() {
        Set<String> windows = driver.getWindowHandles();
        int windowsQuantity = windows.size();
        driver.switchTo().window((String) windows.toArray()[windowsQuantity - 1]);
    }
}

package cuc.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverSettings {
    public static WebDriver driver;

    public WebDriver startDriver(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public void waiterElementXpath(String elementXpath) {
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
    }

    public void waiterElement(WebElement element) {
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean isElementPresentByXpath(String xpath) {
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

}


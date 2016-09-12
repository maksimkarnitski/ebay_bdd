package cuc.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Maksim_Karnitski on 04.09.2016.
 */
public class Utils {
    private WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }
    public void waiterElementXpath(String elementXpath) {
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
    }

    public void waiterElement(WebElement element) {
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOf(element));
    }
}


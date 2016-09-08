package cuc.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Maksim_Karnitski on 31.08.2016.
 */
public class DriverSettings {
    public WebDriver driver;

    public WebDriver startDriver(String URL){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        return driver;
    }
}

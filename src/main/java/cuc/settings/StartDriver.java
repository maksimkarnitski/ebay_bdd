package cuc.settings;

import org.openqa.selenium.WebDriver;

public class StartDriver{

    protected static WebDriver driver;

    public static String URL = "http://www.ebay.com";

    public void startDriver(){
        driver = new DriverSettings().startDriver();
        driver.get(URL);
    }



}

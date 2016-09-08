package cuc.settings;

import org.openqa.selenium.WebDriver;

public class StartDriver {

    public static String URL = "http://www.ebay.com";
    protected static WebDriver driver = new DriverSettings().startDriver(URL);

//    public void startDriver(){
//        driver = new DriverSettings().startDriver(URL);
//    }



}

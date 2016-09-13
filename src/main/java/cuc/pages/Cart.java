package cuc.pages;

import cuc.settings.DriverSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart extends AbstractPage {

    private String foundElementXpath = ".//*[contains(text(), 'variable')]";

    public DriverSettings driverSettings = new DriverSettings();

    public Cart(WebDriver driver) {
        super(driver);
    }

    public boolean isElementFoundByText(String text) {
        String foundElement = foundElementXpath.replace("variable", text);
        return driverSettings.isElementPresentByXpath(foundElement);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

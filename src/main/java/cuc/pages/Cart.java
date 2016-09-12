package cuc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart extends AbstractPage{

    private String foundElementXpath = ".//*[contains(text(), 'variable')]";

    public Cart(WebDriver driver) {
        super(driver);
    }

    public boolean findElementByText(String text){
        String foundElement = foundElementXpath.replace("variable", text);
        return driver.findElements(By.xpath(foundElement)).size() > 0;
    }

    public String getCurrentUrl(){
        String ba = driver.getCurrentUrl();
        return ba;
    }
}

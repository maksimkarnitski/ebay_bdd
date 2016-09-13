package cuc.pages;

import cuc.settings.DriverSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractPage {

    @FindBy(id = "gh-eb-Geo-a-default")
    private WebElement languageSelector;

    private String myEbayEngXpath = ".//ul[@id='gh-eb']//a[text()='My eBay']";

    private String myEbayRusXpath = ".//ul[@id='gh-eb']//a[text()='Мой eBay']";

    private String languageItemXpath = ".//li[@id='gh-eb-Geo']//span[text()='language']";

    @FindBy(id = "gh-ac")
    private WebElement searchFld;

    @FindBy(id = "gh-btn")
    private WebElement searchBtn;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void selectLanguageItem(String language){
        String languageItem = languageItemXpath.replace("language", language);
        driver.findElement(By.xpath(languageItem)).click();
    }

    public void hoverCurrentLanguage(){
        new Actions(driver).moveToElement(languageSelector).build().perform();
    }

    public void changeLanguage(String language){
        hoverCurrentLanguage();
        selectLanguageItem(language);
    }

    public void hidePopUp(){
        new Actions(driver).moveToElement(driver.findElement(By.xpath(myEbayEngXpath))).moveByOffset(200, 0).click().build().perform();
    }

    public boolean isLanguageEng(){
        return DriverSettings.isElementPresentByXpath(myEbayEngXpath);
    }

    public boolean isLanguageRus(){
        return DriverSettings.isElementPresentByXpath(myEbayRusXpath);
    }

    public WebElement getElementSearchBtn(){
        return searchBtn;
    }

    public void doSearch(String query){
        searchFld.clear();
        searchFld.sendKeys(query);
        searchBtn.click();
    }

    public void setSearchQuery(String query){
        searchFld.sendKeys(query);
    }

    public void pushSearchBtn(){
        searchBtn.click();
    }


}

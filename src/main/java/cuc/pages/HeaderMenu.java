package cuc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractPage {

    @FindBy(id = "gh-eb-Geo-a-default")
    private WebElement languageSelector;

    private String languageItemXpathVariable = ".//li[@id='gh-eb-Geo']//span[text()='language']";

    private String languageItemXpath = "//span[@class='gh-eb-Geo-txt']";

    @FindBy(id = "gh-ac")
    private WebElement searchFld;

    @FindBy(id = "gh-btn")
    private WebElement searchBtn;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void selectLanguageItem(String language){
        String languageItem = languageItemXpathVariable.replace("language", language);
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
        driver.findElement(By.xpath(languageItemXpath)).click();
    }

    public boolean isSelectedLanguage(String language){
        String languageItemText = driver.findElement(By.xpath(languageItemXpath)).getText();
        return languageItemText.equals(language);
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

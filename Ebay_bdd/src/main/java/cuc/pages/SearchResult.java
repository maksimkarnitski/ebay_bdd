package cuc.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Maksim_Karnitski on 31.08.2016.
 */
public class SearchResult extends cuc.pages.AbstractPage {

    private String resultRowXpath = ".//ul[@id='ListViewInner']/li[variable]/h3[@class='lvtitle']/a";
    private String foundItemsElementXpath = ".//div[@id='Results']//*[contains(text(), 'variable')]";

    @FindBy (xpath = ".//div[@class='pnl-b frmt']/*[3]")
    private WebElement buyNowBtn;

    public SearchResult(WebDriver driver){
        super(driver);
    }

    public void selectResultItem(String number){
        String resultRow = resultRowXpath.replace("variable", number);
        driver.findElement(By.xpath(resultRow)).click();
    }

    public String getResultItemText(String number){
        String resultRow = resultRowXpath.replace("variable", number);
        String selectedItemLabel = driver.findElement(By.xpath(resultRow)).getText();
        return selectedItemLabel;
    }

    public String getSelectedItemTitle(String number){
        String resultRow = resultRowXpath.replace("variable", number);
        return driver.findElement(By.xpath(resultRow)).getText();
    }

    public void filterBuyNow(){
        buyNowBtn.click();
    }

    //Works only for English version
    public boolean findElementsWithText(String text){
        String foundItemsElement = foundItemsElementXpath.replace("variable", text);
        return driver.findElements(By.xpath(foundItemsElement)).size() > 0;
    }

    public boolean foundItemRelatesToSearchQuery(String number, String searchQuery){
        String resultRow = resultRowXpath.replace("variable", number);
        String elementLabel = driver.findElement(By.xpath(resultRow)).getText();
        return StringUtils.containsIgnoreCase(elementLabel, searchQuery);
    }


}

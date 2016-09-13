package cuc.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResult extends cuc.pages.AbstractPage {

    private String resultRowXpath = ".//ul[@id='ListViewInner']/li[variable]/h3[@class='lvtitle']/a";
    private String foundItemsElementXpath = ".//div[@id='Results']//*[contains(text(), 'variable')]";

    @FindBy(xpath = ".//*[contains (@class, 'tgl_button last_b')]")
    private WebElement buyNowBtn;

    public SearchResult(WebDriver driver) {
        super(driver);
    }

    public void selectResultItem(int number) {
        String resultRow = resultRowXpath.replace("variable", Integer.toString(number));
        driver.findElement(By.xpath(resultRow)).click();
    }

    public String getResultItemText(int number) {
        String resultRow = resultRowXpath.replace("variable", Integer.toString(number));
        return driver.findElement(By.xpath(resultRow)).getText();
    }

    public String getSelectedItemTitle(int number) {
        String resultRow = resultRowXpath.replace("variable", Integer.toString(number));
        return driver.findElement(By.xpath(resultRow)).getText();
    }

    public void filterBuyNow() {
        buyNowBtn.click();
    }

    //Works only for English version
    public boolean isElementsWithTextFound(String text) {
        String foundItemsElement = foundItemsElementXpath.replace("variable", text);
        return driver.findElements(By.xpath(foundItemsElement)).size() > 0;
    }

    public boolean isFoundItemRelatesToSearchQuery(int number, String searchQuery) {
        String resultRow = resultRowXpath.replace("variable", Integer.toString(number));
        String elementLabel = driver.findElement(By.xpath(resultRow)).getText();
        return StringUtils.containsIgnoreCase(elementLabel, searchQuery);
    }


}

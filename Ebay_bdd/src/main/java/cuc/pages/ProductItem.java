package cuc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Maksim_Karnitski on 04.09.2016.
 */
public class ProductItem extends cuc.pages.AbstractPage {

    @FindBy(xpath = ".//*[@id='itemTitle']")
    private WebElement itemTitle;

    @FindBy(xpath = ".//*[@id='isCartBtn_btn']")
    private WebElement addToCart;


    public ProductItem(WebDriver driver){
        super(driver);
    }


    public String getItemTitleText (){
        return itemTitle.getText();
    }

    public void addItemToCart (){
        addToCart.click();
    }

}

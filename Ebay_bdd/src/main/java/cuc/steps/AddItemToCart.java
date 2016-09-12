package cuc.steps;

import cuc.pages.Cart;
import cuc.pages.HeaderMenu;
import cuc.pages.ProductItem;
import cuc.pages.SearchResult;
import cuc.settings.DriverSettings;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by Maksim_Karnitski on 07.09.2016.
 */
public class AddItemToCart {

    WebDriver driver = new DriverSettings().startDriver("http://www.ebay.com");

    private String itemResultItemText;


//    @Given("^I search for \"([^\"]*)\"")
//    public void iSetSearchQuery(String searchQuery) {
//        new HeaderMenu(driver).setSearchQuery(searchQuery);
//    }
//
//    @And("^I push \"?Search\"? button$")
//    public void iPushSearchBtn() {
//        new HeaderMenu(driver).pushSearchBtn();
//    }
//
//    @And("^I (?:use filter|filter|filter by) Buy It Now$")
//    public void iFilterBuyItNow() {
//        new SearchResult(driver).filterBuyNow();
//    }
//
//    @And("^I open found item \"(\\d+)\"$")
//    public void iOpenFoundItem(String foundItemNumber) {
//        itemResultItemText = new SearchResult(driver).getResultItemText(foundItemNumber);
//        System.out.println("Item that will be selected has label: '" + itemResultItemText + "'.");
//        new SearchResult(driver).selectResultItem(foundItemNumber);
//        System.out.println("Select row item '" + foundItemNumber + "'.");
//    }

    @When("^I add item to cart")
    public void iAddItemToCart(){
        new ProductItem(driver).addItemToCart();
    }

    @Then("^Page \"([^\"]*)\" is opened")
    public void cartIsOpened(String text) {
        Assert.assertTrue(StringUtils.containsIgnoreCase(text, new Cart(driver).getCurrentUrl()), "Selected item and opened item is not the same");
    }

    @And("^(?:Selected item|Item) is in cart")
    public void itemIsInCart() {
        Assert.assertTrue(new Cart(driver).findElementByText(itemResultItemText), "Selected item and opened item is not the same");
    }

}



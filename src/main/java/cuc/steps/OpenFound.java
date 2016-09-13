package cuc.steps;

import cuc.pages.ProductItem;
import cuc.pages.SearchResult;
import cuc.settings.StartDriver;
import cuc.utils.Variables;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

public class OpenFound extends StartDriver{

    @When("^I add item to cart")
    public void iAddItemToCart(){
        new ProductItem(driver).addItemToCart();
    }

    @When("^I open found item \"(\\d+)\"$")
    public void iOpenFoundItem(int foundItemNumber) {
        Variables.itemResultItemText = new SearchResult(driver).getResultItemText(foundItemNumber);
        System.out.println("Item that will be selected has label: '" + Variables.itemResultItemText + "'.");
        new SearchResult(driver).selectResultItem(foundItemNumber);
        System.out.println("Select row item '" + foundItemNumber + "'.");
    }

    @Then("^Selected item is opened")
    public void selectedElementIsOpened() {
        System.out.println(new ProductItem(driver).getItemTitleText());
        Assert.assertTrue("Selected item and opened item is not the same", StringUtils.containsIgnoreCase(Variables.itemResultItemText, new ProductItem(driver).getItemTitleText()));
    }

}


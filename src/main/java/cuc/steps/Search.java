package cuc.steps;

import cuc.pages.HeaderMenu;
import cuc.pages.ProductItem;
import cuc.pages.SearchResult;
import cuc.settings.StartDriver;
import cuc.utils.Variables;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

public class Search extends StartDriver {

    @When("^I search for \"([^\"]*)\"")
    public void iSetSearchQuery(String searchQuery) {
        new HeaderMenu(driver).doSearch(searchQuery);
    }

    @When("^I (?:use filter|filter|filter by) Buy It Now$")
    public void iFilterBuyItNow() {
        new SearchResult(driver).filterBuyNow();
    }

    @When("^I add item to cart")
    public void iAddItemToCart(){
        new ProductItem(driver).addItemToCart();
    }

    @When("^I open found item \"(\\d+)\"$")
    public void iOpenFoundItem(int foundItemNumber) {
        String itemResultItemText = new SearchResult(driver).getResultItemText(foundItemNumber);
        Variables.itemResultItemText = itemResultItemText.substring(0, Math.min(itemResultItemText.length(), 80));
        System.out.println("Item that will be selected has label: '" + Variables.itemResultItemText + "'.");
        new SearchResult(driver).selectResultItem(foundItemNumber);
        System.out.println("Select row item '" + foundItemNumber + "'.");
    }

    @Then("Found (?:element|item) \"(\\d+)\" contains \"([^\"]*)\"")
    public void foundElementContains(int foundItemNumber, String text) {
        Assert.assertTrue("Item number '" + foundItemNumber + "' is not related to text '" + text + "'.", new SearchResult(driver).isFoundItemRelatesToSearchQuery(foundItemNumber, text));
    }

    //    @Then("^(?:Found(?:elements|items)|Search results) don't contain \"([^\"]*)\"$") // а можно как-нибудь так?
    @Then("^Found (?:elements|items) don't contain \"([^\"]*)\"$")
    public void foundElementContains(String text) {
        Assert.assertFalse("Filtered by 'Buy It Now' search results contain auction items", new SearchResult(driver).isElementsWithTextFound(text));
    }

    @Then("^Selected item is opened")
    public void selectedElementIsOpened() {
        System.out.println(new ProductItem(driver).getItemTitleText());
        Assert.assertTrue("Selected item and opened item is not the same", StringUtils.containsIgnoreCase(Variables.itemResultItemText, new ProductItem(driver).getItemTitleText()));
    }
}

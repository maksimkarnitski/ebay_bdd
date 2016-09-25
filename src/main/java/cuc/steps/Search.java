package cuc.steps;

import cuc.pages.HeaderMenu;
import cuc.pages.ProductItem;
import cuc.pages.SearchResult;
import cuc.settings.StartDriver;
import cuc.utils.Variables;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

public class Search extends StartDriver {

    HeaderMenu headerMenu;
    SearchResult searchResult;
    ProductItem productItem;

    @Before
    public void initializeObject(){
        headerMenu = new HeaderMenu(driver);
        searchResult = new SearchResult(driver);
        productItem = new ProductItem(driver);
    }

    @When("^I search for \"([^\"]*)\"")
    public void iSetSearchQuery(String searchQuery) {
        headerMenu.doSearch(searchQuery);
    }

    @When("^I (?:use filter|filter|filter by) Buy It Now$")
    public void iFilterBuyItNow() {
        searchResult.filterBuyNow();
    }

    @When("^I add item to cart")
    public void iAddItemToCart(){
        productItem.addItemToCart();
    }

    @When("^I open found item \"(\\d+)\"$")
    public void iOpenFoundItem(int foundItemNumber) {
        String itemResultItemText = searchResult.getResultItemText(foundItemNumber);
        Variables.itemResultItemText = itemResultItemText.substring(0, Math.min(itemResultItemText.length(), 80));
        System.out.println("Item that will be selected has label: '" + Variables.itemResultItemText + "'.");
        searchResult.selectResultItem(foundItemNumber);
        System.out.println("Select row item '" + foundItemNumber + "'.");
    }

    @Then("Found (?:element|item) \"(\\d+)\" contains \"([^\"]*)\"")
    public void foundElementContains(int foundItemNumber, String text) {
        Assert.assertTrue("Item number '" + foundItemNumber + "' is not related to text '" + text + "'.", searchResult.isFoundItemRelatesToSearchQuery(foundItemNumber, text));
    }

    //    @Then("^(?:Found(?:elements|items)|Search results) don't contain \"([^\"]*)\"$") // а можно как-нибудь так?
    @Then("^Found (?:elements|items) don't contain \"([^\"]*)\"$")
    public void foundElementContains(String text) {
        Assert.assertFalse("Filtered by 'Buy It Now' search results contain auction items", searchResult.isElementsWithTextFound(text));
    }

    @Then("^Selected item is opened")
    public void selectedElementIsOpened() {
        System.out.println(productItem.getItemTitleText());
        Assert.assertTrue("Selected item and opened item is not the same", StringUtils.containsIgnoreCase(Variables.itemResultItemText, productItem.getItemTitleText()));
    }
}

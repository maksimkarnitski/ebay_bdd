package cuc.steps;

import cuc.pages.HeaderMenu;
import cuc.pages.SearchResult;
import cuc.settings.StartDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Search extends StartDriver{

    @When("^I search for \"([^\"]*)\"")
        public void iSetSearchQuery(String searchQuery){
        new HeaderMenu(driver).doSearch(searchQuery);
    }

    @When("^I (?:use filter|filter|filter by) Buy It Now$")
    public void iFilterBuyItNow() {
        new SearchResult(driver).filterBuyNow();
    }

    @Then("Found element (\\d+) contains \"([^\"]*)\"")
    public void foundElementContains(String foundItemNumber, String text){
        Assert.assertTrue("Item number '" + foundItemNumber + "' is not related to text '" + text + "'.", new SearchResult(driver).foundItemRelatesToSearchQuery(foundItemNumber, text));
    }

    //    @Then("^(?:Found(?:elements|items)|Search results) don't contain \"([^\"]*)\"$") // а можно как-нибудь так?
    @Then("^Found (?:elements|items) don't contain \"([^\"]*)\"$")
    public void foundElementContains(String text) {
        Assert.assertFalse("Filtered by 'Buy It Now' search results contain auction items", new SearchResult(driver).findElementsWithText(text));
    }
}

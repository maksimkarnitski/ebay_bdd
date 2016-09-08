package cuc.steps;

import cuc.pages.HeaderMenu;
import cuc.pages.SearchResult;
import cuc.settings.DriverSettings;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by Maksim_Karnitski on 07.09.2016.
 */
public class FilterBuyItNow {

    WebDriver driver = new DriverSettings().startDriver("http://www.ebay.com");

//    @Given("^I search for \"([^\"]*)\"")
//    public void iSetSearchQuery(String searchQuery) {
//        new HeaderMenu(driver).setSearchQuery(searchQuery);
//    }
//
//    @And("^I push \"?Search\"? button$")
//    public void iPushSearchBtn() {
//        new HeaderMenu(driver).pushSearchBtn();
//    }

    @When("^I (?:use filter|filter|filter by) Buy It Now$")
    public void iFilterBuyItNow() {
        new SearchResult(driver).filterBuyNow();
    }

//    @Then("^(?:Found(?:elements|items)|Search results) don't contain \"([^\"]*)\"$") // а можно как-нибудь так?
    @Then("^Found (?:elements|items) don't contain \"([^\"]*)\"$")
    public void foundElementContains(String text) {
        Assert.assertFalse(new SearchResult(driver).findElementsWithText(text), "Filtered by 'Buy It Now' search results contain auction items");
    }
}


package cuc.steps;

import cuc.pages.HeaderMenu;
import cuc.pages.SearchResult;
import cuc.settings.DriverSettings;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by Maksim_Karnitski on 06.09.2016.
 */
public class Search {

    WebDriver driver = new DriverSettings().startDriver("http://www.ebay.com");

    @Given("^I search for \"([^\"]*)\"")
        public void iSetSearchQuery(String searchQuery){
        new HeaderMenu(driver).setSearchQuery(searchQuery);
    }

    @When("^I push \"?Search\"? button$")
    public void iPushSearchBtn(){
        new HeaderMenu(driver).pushSearchBtn();
    }

    @Then("Found element (\\d+) contains \"([^\"]*)\"")
    public void foundElementContains(String foundItemNumber, String text){
        Assert.assertTrue(new SearchResult(driver).foundItemRelatesToSearchQuery(foundItemNumber, text), "Item number '" + foundItemNumber + "' is not related to text '" + text + "'.");
    }
}

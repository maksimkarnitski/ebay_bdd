package cuc.steps;

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
public class OpenFound {

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

    @When("^I open found item \"(\\d+)\"$")
    public void iOpenFoundItem(String foundItemNumber) {
        itemResultItemText = new SearchResult(driver).getResultItemText(foundItemNumber);
        System.out.println("Item that will be selected has label: '" + itemResultItemText + "'.");
        new SearchResult(driver).selectResultItem(foundItemNumber);
        System.out.println("Select row item '" + foundItemNumber + "'.");
    }

    @Then("^Selected item is opened")
    public void selectedElementIsOpened() {
        System.out.println(new ProductItem(driver).getItemTitleText());
        Assert.assertTrue(StringUtils.containsIgnoreCase(itemResultItemText, new ProductItem(driver).getItemTitleText()), "Selected item and opened item is not the same");
    }

}


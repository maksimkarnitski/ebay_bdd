package cuc.steps;

import cuc.pages.Cart;
import cuc.settings.StartDriver;
import cuc.utils.Variables;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

public class AddItemToCart extends StartDriver{

    Cart cart;

    @Before
    public void initializeObject(){
        cart = new Cart(driver);
    }

    @Then("^Page \"([^\"]*)\" is opened")
    public void pageIsOpened(String text) {
        Assert.assertTrue("Page " + "\'" + text + "\'" + " is not opened", StringUtils.containsIgnoreCase(text, cart.getCurrentUrl()));
    }

    @Then("^(?:Selected item|Item) is in cart")
    public void itemIsInCart() {
        Assert.assertTrue("Selected item and opened item is not the same", cart.isElementFoundByText(Variables.itemResultItemText));
    }

}



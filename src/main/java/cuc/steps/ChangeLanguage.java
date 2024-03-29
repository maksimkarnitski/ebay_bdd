package cuc.steps;

import cuc.pages.HeaderMenu;
import cuc.settings.StartDriver;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class ChangeLanguage extends StartDriver {

    private String language;
    HeaderMenu headerMenu;

    @Before
    public void initializeObject(){
        headerMenu = new HeaderMenu(driver);
    }

    @Given("^I open language selector$")
    public void iOpenLanguageSelector() {
        headerMenu.hoverCurrentLanguage();
    }

    @When("^I select \"(.*)\"")
    public void iSelectLanguage(String language) {
        headerMenu.selectLanguageItem(language);
        this.language = language;
        //Step hides pop up after language changes, this needs to be done for running next tests after language changing
        headerMenu.hidePopUp();
    }

    @Then("^Selected language is applied$")
    public void selectedLanguageApplied() {
        Assert.assertTrue("Language is not changed", headerMenu.isSelectedLanguage(this.language));
        }

}

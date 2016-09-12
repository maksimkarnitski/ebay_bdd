package cuc.steps;

import cuc.pages.HeaderMenu;
import cuc.settings.StartDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;


public class ChangeLanguage extends StartDriver{

    private String language;

    @Given("^I open language selector$")
    public void iOpenLanguageSelector(){
       new HeaderMenu(driver).hoverCurrentLanguage();
    }

    @When("^I select \"(.*)\"")
    public void iSelectLanguage(String language){
        new HeaderMenu(driver).selectLanguageItem(language);
        this.language = language;
    }

    @Then("^Selected language is applied$")
    public void selectedLanguageApplied(){
        HeaderMenu headerMenu = new HeaderMenu(driver);
        if (this.language == "English") {
            Assert.assertTrue(headerMenu.isLanguageEng(), "Language is not changed");
        }
        if (this.language == "Русский") {
            Assert.assertTrue(headerMenu.isLanguageRus(), "Language is not changed");
        }
    }

}

package cuc.steps;

import cuc.pages.HeaderMenu;
import cuc.settings.StartDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class ChangeLanguage extends StartDriver {

    private String language;

    @Given("^I open language selector$")
    public void iOpenLanguageSelector() {
        new HeaderMenu(driver).hoverCurrentLanguage();
    }

    @When("^I select \"(.*)\"")
    public void iSelectLanguage(String language) {
        new HeaderMenu(driver).selectLanguageItem(language);
        this.language = language;
        //Step hides pop up after language changes, this needs to be done for running next tests after language changing
        new HeaderMenu(driver).hidePopUp();
    }

    @Then("^Selected language is applied$")
    public void selectedLanguageApplied() {
        HeaderMenu headerMenu = new HeaderMenu(driver);
        if (this.language.equals("English")) {
            Assert.assertTrue("Language is not changed", headerMenu.isLanguageEng());
        }
        if (this.language.equals("Русский")) {
            Assert.assertTrue("Language is not changed", headerMenu.isLanguageRus());
        }

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChangeLanguage that = (ChangeLanguage) o;

        return !(language != null ? !language.equals(that.language) : that.language != null);

    }

    @Override
    public int hashCode() {
        return language != null ? language.hashCode() : 0;
    }
}

package cuc;

import cuc.settings.StartDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty"}
)

public class TestRunner {
    @BeforeClass
    public static void startDriver() {
        new StartDriver().startDriver();
    }
}



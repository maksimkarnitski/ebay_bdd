package cuc;

import cuc.settings.StartDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;


@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty"}
)


public class TestRunner {
    @BeforeClass
    public static void startDriver() {
//        new StartDriver().startDriver();
    }
}



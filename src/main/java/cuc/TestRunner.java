package cuc;

import cuc.settings.StartDriver;

import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

public class TestRunner {
    @BeforeClass
    public static void startDriver() {
        new StartDriver().startDriver();
    }
}



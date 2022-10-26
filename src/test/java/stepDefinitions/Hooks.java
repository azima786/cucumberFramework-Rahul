package stepDefinitions;

import io.cucumber.java.After;
import utils.TestContextSetup;

import java.io.IOException;


public class Hooks {
   public TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }


    @After
    public void AfterScenario() throws IOException {
testContextSetup.testBase.WebDriverManager().quit();

    }

}

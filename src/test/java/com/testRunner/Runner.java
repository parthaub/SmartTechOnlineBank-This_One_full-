package com.testRunner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "/Users/parthadebnath/eclipse-Batch-41/Batch-44/smartTechOnlineBank/src/main/resources/STOBLogin.feature", // Path to your feature files
    glue = "com.StepDef", // <-- Make sure this is the package containing your step definitions
    plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"},
    monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

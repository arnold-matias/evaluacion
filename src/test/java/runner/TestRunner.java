package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber-pretty"
        },
        features = "src/test/java/features/Ebay.feature",
        glue = "steps"
)
public class TestRunner extends AbstractTestNGCucumberTests{

}

package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed_scenarios.txt",   // @ tells Cucumber to read the file
        glue = {"stepdefinitions", "hooks"},
        plugin = {
                "pretty",
                "html:target/RerunReports/RerunReport.html"
        },
        dryRun = false
)
public class FailedTestRunner {

}

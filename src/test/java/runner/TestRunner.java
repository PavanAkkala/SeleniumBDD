package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/features/Demo.feature",
                 glue = {"stepdefinitions","hooks"},
                 plugin={"pretty","html:target/CucumberReports/CucumberReport.html", "rerun:target/failed_scenarios.txt"},
                 tags = "@smoke"




)
public class TestRunner {

}

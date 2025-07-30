package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

public class TestRunnerOne {

    @CucumberOptions(
            features = "src/test/resources/features",
            glue = {"stepdefinitions", "hooks"},
            plugin = {
                    "pretty",
                    "html:target/CucumberReports/CucumberReport.html",
                    "rerun:target/failed_scenarios.txt"
            },
            tags = "@smoke"
    )
    public class TestRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {

            return super.scenarios();
        }
    }
}

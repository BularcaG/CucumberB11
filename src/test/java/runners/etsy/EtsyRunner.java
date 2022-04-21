package runners.etsy;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features/com.weborder/com.etsy",
        glue = "stepdefinitions/etsysteps",
        dryRun = false,
        tags="@OutlineRegression",
        plugin={"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}

)

public class EtsyRunner {
}

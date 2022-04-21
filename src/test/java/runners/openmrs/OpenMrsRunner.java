package runners.openmrs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features="src/test/resources/features/com.weborder/com.openMRS/OpenMRS.feature",
        glue="stepdefinitions/openmrssteps",
        dryRun = false,
        tags="@openMRS",
        plugin={"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)


public class OpenMrsRunner {
}

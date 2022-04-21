package runners.etsy;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "target/uiFailedTests.txt",//location of the failed test
        glue ="stepdefinitions/etsysteps",//stepdefinitions//sourceroot
        tags = "@OutlineRegression",
        plugin={"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)
public class etsyRerun {


}

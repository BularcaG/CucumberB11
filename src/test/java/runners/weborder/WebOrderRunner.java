package runners.weborder;

//Runner class is a way to run all feature files from here
//@runWith() comes from JUNIT and it executes the feature files
//CucumberOptions is a special annotation that has some keywords
//    features: this is the location of feature files(this one shoul dbe content root
//    glue:This is the location of stepdefinitions(this one should be source root and delete.java file to make it more general
//    dryRun:This is a way to get snips without executing the whole implementation.
//    it means if you make it true,you will get immediately unimplemented snips



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features/com.weborder",//this is path for feature files
        glue = "stepdefinitions/webordersteps", // this is path for step definitions  //source
        dryRun = false,
        tags="@SmokeLoginOutline"
)


public class WebOrderRunner {

}

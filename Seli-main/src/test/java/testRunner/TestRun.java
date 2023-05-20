package testRunner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/Features/Login.feature",
//        glue = "stepDefinitions",
//        dryRun = false,
//        monochrome = true,
//        plugin = {"pretty", "html:test-output.html"}
//)
//@CucumberOptions(
//        features = "src/Features/AdminSearch.feature",
//        glue = "stepDefinitions",
//        dryRun = false,
//        monochrome = true,
//        plugin = {"pretty", "html:test-output.html"}
//)
@CucumberOptions(
        features = "src/Features/PIM.feature",
        glue = "stepDefinitions",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty", "html:test-output.html"}
)
public class TestRun {
}

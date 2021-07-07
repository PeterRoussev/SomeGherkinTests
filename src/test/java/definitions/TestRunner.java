package definitions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


// @RunWith(Cucumber.class)
@CucumberOptions(features="src/test/features", glue= {"definitions"},
        plugin={"html:target/HtmlReports.html" })
public class TestRunner extends AbstractTestNGCucumberTests {

}

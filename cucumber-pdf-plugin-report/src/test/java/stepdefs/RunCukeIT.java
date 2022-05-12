package stepdefs;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;*/

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/stepdefs/", plugin = { "json:target/cucumber-json.json",
		"summary" }/* , tags = "@tabledoc or @exception" */)
public class RunCukeIT extends AbstractTestNGCucumberTests {

	/*
	 * @DataProvider(parallel = true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */

}

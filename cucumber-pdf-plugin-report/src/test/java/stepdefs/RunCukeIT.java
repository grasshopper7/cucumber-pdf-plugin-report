package stepdefs;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;*/

//@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "json:target/cucumber-json.json", "summary" }/* , tags = "@scen or @tabledoc" */)
public class RunCukeIT extends AbstractTestNGCucumberTests {

	/*
	 * @DataProvider(parallel = true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */

}

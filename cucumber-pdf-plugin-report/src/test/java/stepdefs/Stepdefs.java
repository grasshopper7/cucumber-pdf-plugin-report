package stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*import cucumber.api.*;
import cucumber.api.java.*;
import cucumber.api.java.en.*;*/

import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdefs {

	private Scenario scenario;

	@Given("Hello background")
	public void backgrond() {
	}

	@Before(value = "not @failure")
	public void before() throws InterruptedException {
		Thread.sleep(100);
		// System.out.println("BEFORE HOOK");
	}

	@After(value = "not @failure")
	public void after() throws InterruptedException {
		Thread.sleep(200);
		// System.out.println("AFTER HOOK");
	}

	@BeforeStep
	public void beforeStep() throws InterruptedException {
		Thread.sleep(100);
	}

	@AfterStep
	public void afterStep() throws InterruptedException {
		Thread.sleep(200);
	}

	@Before(value = "@failure")
	public void beforeFailure(Scenario scenario) { //
		this.scenario = scenario;
		scenario.log("FAILURE HI");
		scenario.log("FAILURE HELLO");
		throw new RuntimeException();
	}

	@After(value = "@failure")
	public void afterFailure() { //
		scenario.log("FAILURE HI");
		scenario.log("FAILURE HELLO");
		throw new RuntimeException();
	}

	@Given("Hook failure step")
	public void hook_failure_step() throws InterruptedException {
		// System.out.println("Failure step");
		Thread.sleep(500);
		scenario.log("FAILURE STEP HI");
		scenario.log("FAILURE STEP HELLO");
	}

	@Given("Skip hook failure step")
	public void skip_hook_failure_step() throws InterruptedException {
		Thread.sleep(250);
	}

	@Given("{string} background")
	public void background(String type) {
		System.out.format("%s type background. \n", type);
	}

	@Given("Write a {string} step with precondition in {string}")
	@When("Complete action in {string} step in {string}")
	@Then("Validate the outcome in {string} step in {string}")
	public void step(String step, String scenario) throws InterruptedException {
		// System.out.format("%s step from %s.\n", step.toUpperCase(),
		// scenario.toUpperCase());
		Thread.sleep(500);
	}

	@Then("Raise exception")
	public void raiseExcep() {

		Random r = new Random();
		boolean flag = r.nextBoolean();
		assertEquals(flag, true);
	}

	@Then("Do not raise exception")
	public void doNotRaiseExcep() {
		assertEquals(true, true);
	}

	@Given("Customer orders the dishes")
	public void dataTable(List<List<String>> table) {
	}

	@Given("the doc string is")
	public void docStr(String docStr) {
	}

	private WebDriver driver;
	private String site;

	@And("Go to {word}")
	public void visitweb(String site) throws Exception {
		driver.get(site);
		this.site = site;
		// scenario.write("scenario write");
		scenario.log("scenario website name - " + site);
		Thread.sleep(3000);
	}

	@BeforeStep(value = "@website")
	public void beforeSite(Scenario scenario) {
		this.scenario = scenario;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterStep(value = "@website")
	public void afterSite() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		// scenario.embed(screenshot, "image/png", this.site);
		// scenario.embed(screenshot, "image/png");
		scenario.attach(screenshot, "image/png", this.site);
		scenario.log("	first log");
		scenario.log("second log second log");
		scenario.log("third log third log third log");
		scenario.log("fourth log fourth log fourth log fourth log");
		scenario.log("fifth log fifth log fifth log fifth log fifth log");
		scenario.log("sixth log sixth log sixth log sixth log sixth log sixth log");
		scenario.log(
				"	seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log seventh log");
		driver.quit();
	}

	@Given("Pending step definition")
	public void pending_step_definition_methods() {
		throw new PendingException();
	}

	@Given("Skipped step definition")
	public void skippedStep() {
		throw new SkipException("SKip it");
	}
}
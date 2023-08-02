package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/Login.feature",
                  glue= {"stepdefinitions","hooks"},
                  monochrome = false,
                  publish = true,
                  plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                			"timeline:test-output-thread/","pretty:target/json-report.json"
							}
                  
		)
public class TestRunner {

	
	
}

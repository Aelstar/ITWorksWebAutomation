package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\ITWebAutomation\\src\\test\\java\\featureFiles",glue="ITWorksWebAutomation\\src\\test\\java\\testCases", plugin= {"pretty", "html:target\\reports.html", "json:target\\reports.json"},dryRun=false)

public class Runners {
	
	

}

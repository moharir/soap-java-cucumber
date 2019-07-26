package cigniti.runner;

import org.testng.annotations.AfterSuite;

import cigniti.utils.ReportGeneration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cigniti/features", tags = { "not @ignore" }, monochrome = true, plugin = {
		"pretty", "html:target/cucumber-report/soapresult", "json:target/cucumber-report/soapresult.json",
		"rerun:target/soaprerun.txt" }, glue = { "/cigniti/steps" }

)
public class SoapRunner extends AbstractTestNGCucumberTests {
	ReportGeneration generateReport = new ReportGeneration();

	@AfterSuite
	public void afterSuite() {
		generateReport.generateSummaryReport();
	}
}

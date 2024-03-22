package testCases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import testBasis.SetUpMain;

public class ExtentReportsTest extends SetUpMain{

	
	
	public ExtentReportsTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeSuite
	public void beforeSuite() {
		
		 extent=new ExtentReports("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\ITWebAutomation\\TestDataOut\\ExtentReport.html", true);
		extent.addSystemInfo("TesterName", "A_Abdelstar");
		
	}
	
	@AfterSuite
	public void afterSuite() {
		
		extent.flush();
	}
}

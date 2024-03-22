package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import testBasis.SetUpMain;
import testPages.DashboardPage;
import testPages.LoginPage;

public class LoginPageTest extends SetUpMain {

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	LoginPage loginpage;
	DashboardPage dashboardpage;
	
	@BeforeMethod
	public void identifypages() throws IOException {
		loginpage=new LoginPage();	
		
	}
	
	

	
	
	@Test( enabled=false)
//	@When("I open browser login by {string}  and {string}valid credintials")
	public void loginActionPerform() throws IOException, InterruptedException  {
		
		 
		dashboardpage=loginpage.perform_Login();
		
	}

	
	
}

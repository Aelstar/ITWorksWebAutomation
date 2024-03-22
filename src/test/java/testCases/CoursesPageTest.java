package testCases;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testBasis.SetUpMain;
import testPages.CoursesPage;
import testPages.DashboardPage;
import testPages.LoginPage;

public class CoursesPageTest extends SetUpMain{

	public CoursesPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}




	LoginPage loginpage;
	DashboardPage dashboardpage;
	CoursesPage coursespage;


	@BeforeMethod
	public void identifypages() throws IOException {

		loginpage	=new LoginPage();
		dashboardpage	=new DashboardPage();
		coursespage=new CoursesPage();

	}



	

	@Test(priority=1)

	public void addCourseToSystem() throws IOException, InterruptedException {
		dashboardpage=loginpage.perform_Login();
		coursespage=dashboardpage.goTo_CoursesPage();
		
		coursespage.addCourse("AhmedAbdelstarCourse1", "Creative Arts", "2");
		
		
	}
	
	
	

	

	@Test(priority=2 )

	public void searchAbboutAddedUser() throws IOException, InterruptedException, AWTException {
		
		dashboardpage=loginpage.perform_Login();
		coursespage=dashboardpage.goTo_CoursesPage();
	boolean actual=	coursespage.searchUser("AhmedAbdelstarCourse1");
		boolean expected=true;
		
	Assert.assertEquals(expected, actual);

		
		

		
	}
	

	
	
	
	
	


}

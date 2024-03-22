package testPages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBasis.SetUpMain;

public class DashboardPage extends SetUpMain {

	public DashboardPage() throws IOException {

		PageFactory.initElements(driver, this);
	}






	@FindBy(xpath="//li[@class='lms-icon-visible']//a[@href='/Course']")
	WebElement Courses_Tab;









	


	public CoursesPage goTo_CoursesPage() throws IOException {
		
		Courses_Tab.click();
		return new CoursesPage();
		
	}





}

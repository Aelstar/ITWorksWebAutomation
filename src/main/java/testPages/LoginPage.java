package testPages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBasis.SetUpMain;

public class LoginPage extends SetUpMain{


	public LoginPage() throws IOException {

		PageFactory.initElements(driver, this);

	}


	@FindBy(name="Email")
	WebElement UserName;

	@FindBy(name="Password")
	WebElement Password;

	@FindBy(xpath="//input[@type='submit']")
	WebElement Login_button;



	

	public void checkBrowseropen() {

		System.out.println("browser opens successfully");
	}


	
	
	
	



	public DashboardPage perform_Login() throws IOException, InterruptedException {


		UserName.sendKeys(prop.getProperty("userName"));

		Password.sendKeys(prop.getProperty("passWord"));

		Login_button.click();


		return new DashboardPage();
	}


}

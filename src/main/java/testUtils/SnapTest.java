package testUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testBasis.SetUpMain;

public class SnapTest extends SetUpMain{
	
	
	
	
	public SnapTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void TakeShot(String name) throws IOException {
		
		
File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(srcfile, new File("C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\ITWebAutomation\\TestDataOut\\"+name+".png"));



	}

}

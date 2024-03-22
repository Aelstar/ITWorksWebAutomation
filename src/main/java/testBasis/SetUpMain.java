package testBasis;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.WebListener;

import testUtils.SnapTest;

public class SetUpMain {

	public static WebDriver driver;
	public static Properties prop;
	public static WebListener listener;
	public static EventFiringWebDriver e_driver;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static Actions action;
	public static Wait<WebDriver> waits;
	


private static String path="C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\ITWebAutomation\\";

	public SetUpMain() throws IOException {

		prop=new Properties();
		FileInputStream fis=new FileInputStream(path+"TestDataIn\\properties.properties");
		prop.load(fis);
	}


	@BeforeMethod
	@Parameters({"Browsers"})
	public void openBrowser(String browser, Method methods ) throws InterruptedException, IOException {



		logger=extent.startTest(methods.getName());


		if(browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", path+"TestDataIn\\chromedriver.exe");

			
			ChromeOptions option=new ChromeOptions();			
			option.addArguments("--incognito");
			option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver=new ChromeDriver(option);

		}

		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",path+"TestDataIn\\geckodriver.exe");
			driver=new FirefoxDriver();
		}

		else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", path+"TestDataIn\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}

		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", path+"TestDataIn\\msedgedriver.exe");

			EdgeOptions option=new EdgeOptions();
			//option.addArguments("--headless=new");
			option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver=new EdgeDriver(option);


		}

		else {

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}



		e_driver=new EventFiringWebDriver(driver);
		listener=new	WebListener();
		e_driver.register(listener);
		driver=e_driver;

		action=new Actions(driver);

		driver.get(prop.getProperty("URL"));


		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Thread.sleep(3000);


	 waits=new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(60)).withTimeout(Duration.ofSeconds(90)).ignoring(NoSuchElementException.class);


		driver.manage().window().maximize();		


	}











	@AfterMethod
	public void closeBrowser(Method method, ITestResult result) throws IOException, InterruptedException {


		SnapTest.TakeShot(method.getName());


		if(result.getStatus()==ITestResult.SUCCESS) {

			logger.log(LogStatus.PASS, "Test Passes");
			logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");
			logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".mov" + "'><span class='lable info'>Download Video</span></a>");

		}

		else if(result.getStatus()==ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL,"test fail"+result.getThrowable());
			logger.log(LogStatus.PASS,"<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");

		}

		else {
			logger.log(LogStatus.SKIP,"test skipped");

		}
		Thread.sleep(3000);
		driver.close();
	}
	
	
	
	

}

package testPages;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import testBasis.SetUpMain;

public class CoursesPage extends SetUpMain{

	public CoursesPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}




	@FindBy(xpath="//button[@id='btnListAddCourse']")
	WebElement Add_buttton;

	@FindBy(xpath="//input[@id='txtCourseName']")
	WebElement  CourseName_field;

	@FindBy(xpath="//select[@id='courseSubject']")
	WebElement  Select_Subject;


	@FindBy(xpath="//select[@id='courseGrade']")
	WebElement  Select_Grade;

	@FindBy(xpath="//input[@id='chkGetSelectedSubjectTeachers']")
	WebElement  chk_Teacher;
	
	
	@FindBy(xpath="//*[text() = \"Course Teacher\"]")
	WebElement  Select_Teacher;
	@FindBy(xpath="//span[@title = \"nada.rehan@aaa.com\"]")
	WebElement  add_Teacher;
	
	
	
	@FindBy(xpath="//button[@id='btnSaveAsDraftCourse']")
	WebElement  Create_btn;
	
	

	@FindBy(xpath="//button[@id='btnPublish']")
	WebElement  Publish_btn;
	
	
	@FindBy(xpath="//input[@id='txtCourseSearch']")
	WebElement Search_field;
	

	@FindBy(xpath="//button[@id='btnCourseSearch']")
	WebElement  Search_btn;


	@FindBy(xpath="//ul[@class='dd-list lms-flex-equal-height']//li")
	WebElement  list_Courses;

	




	

	public  void addCourse(String CourseName, String SubjectName,String GradeNo) throws InterruptedException {

		Add_buttton.click();
		CourseName_field.sendKeys(CourseName);
		
		//Select_Subject.click();
		Select selctSubject=new Select(Select_Subject);
		selctSubject.selectByVisibleText(SubjectName);
		
		Select selctGrade=new Select(Select_Grade);
		selctGrade.selectByVisibleText(GradeNo);
		
	
		
		JavascriptExecutor 	executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Select_Teacher);
		add_Teacher.click();
	//	Select_Teacher.sendKeys(TeacherName); 
		
		Create_btn.click();
		
		waits.until(ExpectedConditions.elementToBeClickable(Publish_btn));
	
		

	}
	



	public boolean searchUser(String CourseName) {

		Search_field.sendKeys(CourseName);
		Search_btn.click();
		
		List<WebElement> coursesList = driver.findElements(By.xpath("//ul[@class='dd-list lms-flex-equal-height']//li"));
		int rowCount = coursesList.size();
		System.out.println(rowCount);
		for(int i=0; i<rowCount; i++) {
			
		String Corsedisplayed=list_Courses.getAttribute("data-winji-course").toString();
		
		System.out.println(Corsedisplayed);
		
		}
		if(rowCount>0) {
			System.out.println("Course found as it added");
			return true;
		}
		return false;
		
		

	}

	



}



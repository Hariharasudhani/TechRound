package LaunchUrl;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.TestNG;
import org.testng.Assert;
import org.testng.TestRunner;
import org.testng.annotations.Test;


public class Firstscript {
//	public static void main(String[] args) {
	@Test
	public void login(){
		// TODO Auto-generated method stub
		String exepath = "C:\\Program Files (x86)\\Google\\Chrome\\Application/chrome.exe";
		System.setProperty("webdriver.chrome.driver", exepath);
//	WebDriver driver = new ChromeDriver();
		WebDriver driver =  new ChromeDriver();
		driver.get("https://qa-refapp.openmrs.org/openmrs/login.htm");
		
		driver.close();
//	driver.get("https://qa-refapp.openmrs.org/");
//	driver.manage().window().maximize();
	driver.findElement(By.id("username")).sendKeys("Admin");
	driver.findElement(By.id("password")).sendKeys("Admin123");
	driver.findElement(By.id("Inpatient Ward")).click();
	driver.findElement(By.id("loginButton")).click();
	
	
		
	String title = "Home";
	driver.get("https://qa-refapp.openmrs.org/openmrs/referenceapplication/home.page");
	String actualtitle = driver.getTitle();
	System.out.println(actualtitle);
	Assert.assertEquals(actualtitle, title);
	
	driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();
	String Name ="TestJohn";
	String Familyname ="Test";
	String Address = "13B Block"; 
	driver.findElement(By.name("givenName")).sendKeys(Name);
	driver.findElement(By.name("familyName")).sendKeys(Familyname);
	driver.findElement(By.id("next-button")).click();
//	WebElement dropdown = driver.findElement(By.id("gender-field"));
//	Select selectgender =new Select(dropdown);
//	selectgender.selectByIndex(1);
//	selectgender.selectByValue();
	driver.findElement(By.xpath("//*[@value='M']")).click();
	driver.findElement(By.id("next-button")).click();
	
	driver.findElement(By.id("birthdateDay-field")).sendKeys("09");
	driver.findElement(By.id("birthdateMonth-field")).click();
	driver.findElement(By.xpath("//*[@value='6']")).click();
	driver.findElement(By.id("birthdateYear-field")).sendKeys("2000");
	driver.findElement(By.id("next-button")).click();
	
	driver.findElement(By.id("address1")).sendKeys(Address);
	driver.findElement(By.id("cityVillage")).sendKeys("Newyork");
	driver.findElement(By.id("stateProvince")).sendKeys("NY");
	driver.findElement(By.id("country")).sendKeys("US");
	driver.findElement(By.id("postalCode")).sendKeys("1022");
	driver.findElement(By.id("next-button")).click();
	String Phonenumber = "99887766155";
	driver.findElement(By.name("phoneNumber")).sendKeys(Phonenumber);
	driver.findElement(By.id("next-button")).click();
	driver.findElement(By.id("next-button")).click();

//	WebElement finalpagename = driver.findElement(By.xpath("/html/body//div[3]/form/div[1]/div[2]//p[1]/text()"));
	WebElement finalpagename = driver.findElement(By.id("//*[@id=\"dataCanvas\"]//p[1]/text()"));
	Assert.assertEquals(finalpagename, Name);
//	WebElement finaladdress = driver.findElement(By.xpath("/html/body//div[3]/form/div[1]/div[2]//p[4]/text()"));
//	Assert.assertEquals(finaladdress, Address);
	WebElement finalphoneno = driver.findElement(By.xpath("/html/body//div[3]/form/div[1]/div[2]//p[5]/text()"));
	Assert.assertEquals(finalphoneno, Phonenumber);

	 driver.findElement(By.xpath("/html/body//div[3]/form/div[1]/div[5]/p[1]/input")).click();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	 driver.findElement(By.className("col-11")).click();	
	 driver.findElement(By.id("start-visit-with-visittype-confirm")).click();
	 driver.findElement(By.id("attachments.attachments.visitActions.default")).click(); 
//	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
//	 driver.findElement(By.xpath("//*[@id='visit-documents-dropzone']/div[2]")).click();
//	 driver.findElement(By.xpath("/html/body//div[3]//div[1]/att-file-upload/div[3]//div[1]/form/div[2]")).click();
	 
	 driver.findElement(By.className("dropzone")).click();
//	 driver.findElement(By.className("dropzone")).sendKeys("C:\\Users\\welcome\\Desktop\\Test");
	 
	 driver.findElement(By.xpath("//*[@id='att-page-main']/div[1]//div[3]//textarea")).sendKeys("Test");
	 driver.findElement(By.className("confirm")).click();
	 
//     driver.findElement(By.id("start-visit-with-visittype-confirm")).click();)
//	driver.close();
	
		try {
	 Robot robot = new Robot();
	 
	 StringSelection filepath = new StringSelection("C:\\Users\\welcome\\Desktop\\Test");
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
	 //Press ctrl
	 robot.keyPress(KeyEvent.VK_CONTROL);
	 
	 //Press V
	 robot.keyPress(KeyEvent.VK_V);
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	 
	 //Release
	 robot.keyRelease(KeyEvent.VK_V);
	 robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	catch (AWTException e) {
		e.printStackTrace();
	}
		
		 driver.findElement(By.xpath("//*[@id='att-page-main']/div[1]//div[3]//textarea")).sendKeys("Test");
		 driver.findElement(By.className("confirm")).click();
		 driver.findElement(By.xpath("//a[@href='/openmrs/coreapps/clinicianfacing/patient.page?patientId=560&']")).click();
		 driver.findElement(By.className("col-11")).click();
		 driver.findElement(By.className("col-11")).click();
		 driver.findElement(By.id("delete-reason")).sendKeys("Remove");
		 driver.findElement(By.className("Confirm")).click();
	
	
	}	}



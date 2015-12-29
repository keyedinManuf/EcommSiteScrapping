package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import selenium.test002;

public class loginpage {

public static void main(String[] args) throws Exception {
	test002.getExcelpath("C:\\Selenium\\com.project.selenium\\src\\TestData\\Book1.xlsx", "Sheet1");
	WebDriver driver=new FirefoxDriver();
	String username=test002.getExceldata(1,0);
	String username_1=test002.getExceldata(2,0);
	String username_2=test002.getExceldata(3,0);
	String username_3=test002.getExceldata(4,0);
	String password=test002.getExceldata(1,1);
	String password_1=test002.getExceldata(2,1);
	String password_2=test002.getExceldata(3,1);     
	String password_3=test002.getExceldata(4,1);
	driver.navigate().to("http://kimdev01.keyedinuat.com/Dev03");
	driver.manage().window().maximize();
	driver.findElement(By.xpath(".//form[@method='post']/ul/li[1]/input")).sendKeys(username);
	driver.findElement(By.xpath(".//form[@method='post']/ul/li[2]/input")).sendKeys(password);
	driver.findElement(By.xpath(".//form[@method='post']/ul/li[3]/input")).click();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	try{
	String Act=driver.getCurrentUrl();
	String Expected="http://kimdev01.keyedinuat.com/Dev03";
	if(Act.trim().equalsIgnoreCase(Expected)){
		System.out.println("Loggin successfully done.");
		test002.SetExcelValue(1, 2, "pass");
		
	} else {
		System.out.println("Loggin failed. Try again with valid crendtials");
		test002.SetExcelValue(1, 2, "Fail");
		driver.navigate().to("http://kimdev01.keyedinuat.com/Dev03");
		driver.findElement(By.xpath(".//form[@method='post']/ul/li[1]/input")).sendKeys(username_1);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//form[@method='post']/ul/li[2]/input")).sendKeys(password_1);
		driver.findElement(By.xpath(".//form[@method='post']/ul/li[3]/input")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		if(Act.trim().equalsIgnoreCase(Expected)){
			System.out.println("Loggin successfully done.");
			test002.SetExcelValue(2, 2, "pass");
		} else {
			System.out.println("Loggin failed. Try again with valid crendtials");
			test002.SetExcelValue(2, 2, "Fail");
			driver.navigate().to("http://kimdev01.keyedinuat.com/Dev03");
			driver.findElement(By.xpath(".//form[@method='post']/ul/li[1]/input")).sendKeys(username_2);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath(".//form[@method='post']/ul/li[2]/input")).sendKeys(password_2);
			driver.findElement(By.xpath(".//form[@method='post']/ul/li[3]/input")).click();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			if(Act.trim().equalsIgnoreCase(Expected)){
				System.out.println("Loggin successfully done.");
				test002.SetExcelValue(3, 2, "pass");
			} else {
				System.out.println("Loggin failed. Try again with valid crendtials");
				test002.SetExcelValue(3, 2, "Fail");
				driver.navigate().to("http://kimdev01.keyedinuat.com/Dev03");
				driver.findElement(By.xpath(".//form[@method='post']/ul/li[1]/input")).sendKeys(username_3);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.findElement(By.xpath(".//form[@method='post']/ul/li[2]/input")).sendKeys(password_3);
				driver.findElement(By.xpath(".//form[@method='post']/ul/li[3]/input")).click();
				
				if(Act.trim().equalsIgnoreCase(Expected)){
					System.out.println("Loggin failed. Try again with valid crendtials");
					test002.SetExcelValue(4, 2, "Fail");			
				} else {
					driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
					System.out.println("Loggin successfully done.");
					test002.SetExcelValue(4, 2, "pass");
					driver.quit();
				}
				
		}
		}	
		
	}
	}catch(Exception e){
		throw e;
	}
	
}
	
	
}


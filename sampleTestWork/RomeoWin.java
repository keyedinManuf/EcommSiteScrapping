package sampleTestWork;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RomeoWin {
public static WebDriver dr;

public static void main(String[] args){
	
		get1();
	
	
	
}
public static void get1()
{
	dr = new FirefoxDriver();
//	System.setProperty("webdriver.ie.driver", "C:\\Users\\sakthivel\\Documents\\Jar files\\IEDriverServer_x64_2.48.0\\IEDriverServer.exe");
//	DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
//	caps.setCapability(
//	    InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
//	    true);
//	dr = new InternetExplorerDriver(caps);
	dr.get("http://dev.researchservicesoffice.com/");
	//dr.manage().window().maximize();
	
	dr.findElement(By.xpath(".//*[@id='content']/ul/li[1]/a")).click();
	dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	String wind1 =dr.getWindowHandle();
	System.out.println(wind1);
	dr.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys("su");
	dr.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("sudemo");
	dr.findElement(By.xpath(".//*[@id='btn_SignIn']")).click();
	Set<String> win2 =dr.getWindowHandles();
	System.out.println(win2);
	for(String wind : win2){
		dr.switchTo().window(wind);
		
	}
	
	WebDriverWait wait = new WebDriverWait(dr, 20);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[2]/a")));
//	dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[2]/a")).click();
	List<WebElement> li =dr.findElements(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li"));
	System.out.println("The options are:");
	for(WebElement TextList : li){
		String output = TextList.getText();
		System.out.println(output);
	}
	Random rand = new Random(System.currentTimeMillis());
	WebElement web =li.get(rand.nextInt(li.size()));
	String result = web.getText();
	System.out.println("The selected option from the list: "+result);
	web.click();
	dr.close();
	dr.switchTo().window(wind1);
	
	dr.close();
	
	
	
	
	
}
}

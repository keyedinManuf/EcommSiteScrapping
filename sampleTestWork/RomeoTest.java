package sampleTestWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RomeoTest {
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
	dr.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys("su");
	dr.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("sudemo");
	dr.findElement(By.xpath(".//*[@id='btn_SignIn']")).click();
	
	dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[2]/a")).click();
	
	
//	List<WebElement> li = dr.findElements(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_panel1']/ul/li/a"));
//	System.out.println("Val: "+li.size());
//	Random rand = new Random(System.currentTimeMillis());
////	for(int i=1;i<=li.size();i++)
////	{
////	System.out.println("I val: "+i);
//	WebElement w = li.get(rand.nextInt(li.size()));
//	
//	System.out.println("Val: "+w.getText());
//	w.click();
////	}
}

}

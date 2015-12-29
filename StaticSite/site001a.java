package StaticSite;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class site001a {
	
	public static WebDriver dr;
	
	public static void main(String[] args){
//		
//		System.setProperty("webdriver.ie.driver", "C:/Users/sakthivel/Documents/Jar files/IEDriverServer_x64_2.48.0/IEDriverServer.exe");
//		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
//		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//		dr=new InternetExplorerDriver(caps);
		dr= new FirefoxDriver();
		dr.navigate().to("http://kimdev01.keyedinuat.com/Dev03/Tab/71");
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.manage().window().maximize();
		dr.findElement(By.xpath(".//form[@method='post']/ul/li[1]/input")).sendKeys("lizc-admin");
		dr.findElement(By.xpath(".//form[@method='post']/ul/li[2]/input")).sendKeys("password");
		dr.findElement(By.xpath(".//form[@method='post']/ul/li[3]/input")).click();
		dr.manage().window().maximize();
		
		int j=3;
		for(int i=1; i<=39; i++){
			WebElement opt = dr.findElement(By.xpath(".//*[@id='MainWrapper']/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr["+i+"]/td["+j+"]"));
			String SOnum = opt.getText();
			System.out.println(SOnum);
		}
		dr.close();
		
	}
	}
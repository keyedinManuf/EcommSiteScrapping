package StaticSite;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class site001 {
	
	public static WebDriver dr;
	
	public static void main(String[] args){
		
		System.setProperty("webdriver.ie.driver", "C:/Users/sakthivel/Documents/Jar files/IEDriverServer_x64_2.48.0/IEDriverServer.exe");
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		dr=new InternetExplorerDriver(caps);
		dr.navigate().to("http://wow.tsstaging.com/");
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.manage().window().maximize();
		List<WebElement> sites = dr.findElements(By.xpath("html/body/div/ul/li"));
		WebElement sitesel=sites.get(new Random().nextInt(sites.size()));
		sitesel.click();
		
		
		
		
	}

}

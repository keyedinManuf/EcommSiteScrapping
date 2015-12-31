package StaticSite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class angelplastics {

	public static WebDriver dr;
	public static int i,j;
	
	
	public static void RandomSelection(){
		
	}
	
	
	
	
	public static void main(String[] args){
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sakthivel\\Documents\\Jar files\\chromedriver_win32\\chromedriver.exe");
//		dr = new ChromeDriver();
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setAcceptUntrustedCertificates(true);
		myprofile.setAssumeUntrustedCertificateIssuer(true);
		WebDriver dr = new FirefoxDriver(myprofile);
		dr.get("https://www.angelplastics.co.uk/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.findElement(By.xpath(".//*[@id='categories']/a[1]/div")).click();
		List<WebElement> options = dr.findElements(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a"));
		int n=options.size();
		for(i=1;i<=n; i++ ){
			String str1="html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a[";
			String str2="]/div";
			dr.findElement(By.xpath(str1+i+str2)).click();
			List<WebElement> suboptions =dr.findElements(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a"));
			int no = suboptions.size();
			for(j=1; j<=no;j++){
				String str3="html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a[";
				String str4="]/div/div[2]";
				dr.findElement(By.xpath(str3+j+str4)).click();
				dr.navigate().back();
//				RandomSelection();
			}
			
			
		}
	}
}

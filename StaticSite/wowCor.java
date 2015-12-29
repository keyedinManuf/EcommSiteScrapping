package StaticSite;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class wowCor {

	public static WebDriver dr;
	
	public static void main(String[] args){
		
		dr= new FirefoxDriver();
		dr.get("http://corporate.wow.tsstaging.com/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		for(int i=0; i<=10; i++){
		String win1 =dr.getWindowHandle();
		List<WebElement> sites = dr.findElements(By.xpath(".//*[@id='main']/div/ul/li"));
		WebElement siteslink = sites.get(new Random().nextInt(sites.size()));
		siteslink.click();
		String terrace ="WOW Hospitality – Terrace In the Park";
		String newWinTitle=dr.getTitle();
		if(terrace.equals(newWinTitle)){
			dr.findElement(By.xpath("html/body/div[1]/div/header/div/h1/a/img")).click();
			String title1 = dr.getTitle();
			System.out.println(title1);
		} else {
		Set<String> win2=dr.getWindowHandles();
		for(String win: win2){
			dr.switchTo().window(win);
			String title = dr.getTitle();
			System.out.println(title);
			
		}
		dr.close();
		dr.switchTo().window(win1);
		}
		}
		dr.close();
		
	}
	
}

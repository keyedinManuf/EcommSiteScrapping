package sampleTestWork;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class RomeoPlay {

public static WebDriver dr;

public static void main(String[] args) throws InterruptedException{
	
	dr = new FirefoxDriver();
	dr.navigate().to("http://dev.researchservicesoffice.com/");
	dr.findElement(By.xpath(".//*[@id='super-user']/a")).click();
	dr.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys("su");
	dr.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("sudemo");
	String handle1=dr.getWindowHandle();
	
	dr.findElement(By.xpath(".//*[@id='btn_SignIn']")).click();
	
	Set<String> handles = dr.getWindowHandles();
	for(String s: handles){
		dr.switchTo().window(s);
	}
	WebElement a =dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[2]/a/span"));
	Actions act = new Actions(dr);
	act.moveToElement(a).perform();
	WebElement b= dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[2]/div/div[1]/div/ul/li[10]/a/span"));
	act.moveToElement(b).perform();

	List<WebElement> options = dr.findElements(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[2]/div/div[2]/ul/li"));
	for(WebElement print:options){
		String result =print.getText();
		System.out.println(result);
	}
		
		Random rand = new Random(System.currentTimeMillis());
		WebElement li = options.get(rand.nextInt(options.size()));
		String t = li.getText();
		System.out.println("The select options is:" +t);
		li.click();
		dr.close();
		dr.switchTo().window(handle1);
	
		dr.quit();
}

}

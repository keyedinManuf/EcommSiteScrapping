package sampleTestWork;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToolsQA1 {

	public static WebDriver dr;
	
	public static void main(String[] args) throws InterruptedException{
		
		dr=new FirefoxDriver();
		dr.get("http://toolsqa.com/automation-practice-switch-windows/");
		dr.manage().window().maximize();
		String WinName = dr.getWindowHandle();
		
		dr.findElement(By.xpath(".//*[@id='content']/p[3]/button")).click();
		TimeUnit.SECONDS.sleep(1);
		Set<String> winlist = dr.getWindowHandles();
		for(String s: winlist){
			dr.switchTo().window(s);
		}
		dr.close();
		System.out.println("New window closed");
		dr.switchTo().window(WinName);
		dr.findElement(By.xpath(".//*[@id='alert']")).click();
		Alert alt = dr.switchTo().alert();
		TimeUnit.SECONDS.sleep(2);
		alt.accept();
		System.out.println("Alert box is handled");
		dr.close();
		
		
		
	}
}

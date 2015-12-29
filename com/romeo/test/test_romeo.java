package com.romeo.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class test_romeo {

	public static WebDriver dr;
	
	public static void main(String[] args) throws InterruptedException{
		
		dr= new FirefoxDriver();
		dr.get("http://dev.researchservicesoffice.com/Romeo/frmLogin.aspx?ReturnUrl=%2fROMEO%2f");
		dr.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys("su");
		dr.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("sudemo");
		dr.findElement(By.xpath(".//*[@id='btn_SignIn']")).click();
		for(String e : dr.getWindowHandles()){
			dr.switchTo().window(e);
		}
		Actions act = new Actions(dr); 
		WebElement gen = dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[2]/a/span"));
		act.moveToElement(gen).clickAndHold(gen).perform();
		
		TimeUnit.SECONDS.sleep(2);
		dr.quit();
		
	}
}

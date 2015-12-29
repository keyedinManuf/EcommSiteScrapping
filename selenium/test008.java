package selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class test008 {
	private static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, AWTException {
		driver = new FirefoxDriver();
		driver.navigate().to("http://kimdev01.keyedinuat.com/Dev03");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//form[@method='post']/ul/li[1]/input")).sendKeys("lizc-admin");
		driver.findElement(By.xpath(".//form[@method='post']/ul/li[2]/input")).sendKeys("password");
		driver.findElement(By.xpath(".//form[@method='post']/ul/li[3]/input")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//span[@class='k-icon k-icon-clipboard']")).click();
		driver.findElement(By.xpath(".//*[@id='main']/div/div[1]/div[2]/div/ul/li[1]/ul/li[2]/div[1]/a[3]")).click();
		driver.findElement(By.xpath(".//*[@id='main']/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[1]/div[1]/a[3]")).click();
		
		driver.findElement(By.xpath(".//span[@id='select2-chosen-2']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String s1="html/body/div[5]/ul/li[";
		String s2="]/div";
		List<WebElement> options=driver.findElements(By.xpath("html/body/div[5]/ul"));
		int Size = options.size();
		System.out.println("Size:" +Size);
		Random rand = new Random(System.currentTimeMillis());
		int rval=rand.nextInt(Size)+4;
		System.out.println("R val is : "+rval);
		driver.findElement(By.xpath(s1+rval+s2)).click();
		FirefoxProfile prof = new FirefoxProfile();
		prof.setPreference("browser.download.folderlist",0);
		prof.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv");
		driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[1]/div/a")).click();
		Robot object = new Robot();
		object.delay(3000);
		object.keyPress(KeyEvent.VK_ENTER);
		object.keyRelease(KeyEvent.VK_ENTER);
		object.keyPress(KeyEvent.VK_ALT);
		object.keyPress(KeyEvent.VK_ALT);
		object.keyRelease(KeyEvent.VK_F4);
		object.keyRelease(KeyEvent.VK_ALT);
		System.out.println("Sales order delivery listing done Succesfully");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.quit();
	}}
		

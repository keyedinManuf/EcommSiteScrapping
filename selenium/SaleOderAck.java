package selenium;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SaleOderAck {
	private static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new FirefoxDriver();
		driver.navigate().to("http://kimdev01.keyedinuat.com/Dev03");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//form[@method='post']/ul/li[1]/input")).sendKeys("lizc-admin");
		driver.findElement(By.xpath(".//form[@method='post']/ul/li[2]/input")).sendKeys("password");
		driver.findElement(By.xpath(".//form[@method='post']/ul/li[3]/input")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("html/body/div[1]/ul[2]/li[2]/div/a")).click();
		driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[5]/div[1]/a[3]")).click();
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.xpath(".//input[@id='s2id_autogen2']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String string3="html/body/div[5]/ul/li[";
		String string4="]/div";
		List<WebElement> SOID1=driver.findElements(By.xpath("html/body/div[5]"));
		int Size =SOID1.size();
		Random select = new Random(System.currentTimeMillis());
		int rval=select.nextInt(Size)+7;
		driver.findElement(By.xpath(string3+rval+string4)).click();
		driver.findElement(By.xpath(".//li[@class='select2-search-field']")).click();
		driver.findElement(By.xpath(".//button[@class='btn btn-xs btn-success']")).click();
		System.out.println("Sales order Acknowledgement done successfully");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*driver.close();*/
	}}
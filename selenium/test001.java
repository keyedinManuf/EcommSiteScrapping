package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class test001 {
 private static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to("http://kimdev01.keyedinuat.com/Dev03");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//form[@method='post']/ul/li[1]/input")).sendKeys("lizc-admin");
		driver.findElement(By.xpath(".//form[@method='post']/ul/li[2]/input")).sendKeys("password");
		driver.findElement(By.xpath(".//form[@method='post']/ul/li[3]/input")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//span[@class='k-icon k-icon-clipboard']")).click();
		//driver.findElement(By.xpath(".//span[@id='select2-chosen-6']")).click();
		System.out.print("Test1");
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[7]/span/div/a/span[1]")).click();
		System.out.print("Test2");
		driver.findElement(By.xpath("/html/body/div[5]/div/input")).click();
		System.out.print("Test3");
		driver.findElement(By.id("s2id_autogen6_search")).sendKeys("New");
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//button[@data-label='Search']")).click();
		
//		Select sel = new Select(driver.findElement(By.className("select2-results")));
//		List<WebElement> options = sel.getOptions();
//		int element = options.size();
//		for(int i=0; i<=element; i++){
//			sel.selectByVisibleText("New");
//		}
//		
//		driver.findElement(By.id("s2id_autogen5")).sendKeys("New");
////		Select sel = new Select(driver.findElement(By.id("s2id_autogen5")));
////		sel.selectByVisibleText("New");
//		driver.findElement(By.xpath(".//button[@data-label='Search']")).click();
//		driver.quit();

	}

}

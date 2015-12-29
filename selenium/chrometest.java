package selenium;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.webdriven.commands.KeyEvent;


public class chrometest {
public static void main(String[] args) throws InterruptedException{
	
//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\sakthivel\\Documents\\Jar files\\chromedriver_win32\\chromedriver.exe");
//	WebDriver driver=new ChromeDriver();
	WebDriver driver=new FirefoxDriver();
	driver.navigate().to("http://kimdev01.keyedinuat.com/Dev03/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath(".//form[@method='post']/ul/li[1]/input")).sendKeys("lizc-admin");
	driver.findElement(By.xpath(".//form[@method='post']/ul/li[2]/input")).sendKeys("password");
	driver.findElement(By.xpath(".//form[@method='post']/ul/li[3]/input")).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@title='Sales Orders']")).click();
	String str = driver.getPageSource();
	if(str.contains("Sales Orders")){
		List<WebElement> orderlist=driver.findElements(By.xpath("html/body/div[2]/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]"));
		for(WebElement list: orderlist){
		   System.out.println(list.getText());
		}
	}
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//li[@data-id='73']")).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/ul/li[1]/div[1]/a[3]")).click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[1]/span/div/a")).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("html/body/div[5]/div/input")).sendKeys("\b");	
	String s1="html/body/div[5]/ul/li[";
	String s2="]/div";
	List<WebElement> options=driver.findElements(By.xpath("html/body/div[5]/ul"));
	int Size = options.size();
	System.out.println("Size:" +Size);
	Random rand = new Random(System.currentTimeMillis());
	int rval=rand.nextInt(Size)+4;
	System.out.println("R val is : "+rval);
	driver.findElement(By.xpath(s1+rval+s2)).click();

	
	
}
}

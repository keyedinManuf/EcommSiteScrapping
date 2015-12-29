package selenium;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Workflow {
public static WebDriver dr;
public static void main(String[] args) throws InterruptedException{
	/*dr=new FirefoxDriver();*/
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\sakthivel\\Documents\\Jar files\\chromedriver_win32\\chromedriver.exe");
	dr=new ChromeDriver();
	dr.navigate().to("http://kimdev01.keyedinuat.com/Dev03");
	dr.manage().window().maximize();
	dr.findElement(By.xpath(".//form[@method='post']/ul/li[1]/input")).sendKeys("lizc-admin");
	dr.findElement(By.xpath(".//form[@method='post']/ul/li[2]/input")).sendKeys("password");
	dr.findElement(By.xpath(".//form[@method='post']/ul/li[3]/input")).click();
	dr.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	/*try {
	    Thread.sleep(1000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}*/
	dr.findElement(By.xpath(".//span[@class='k-icon k-icon-clipboard']")).click();
	WebDriverWait wait = new WebDriverWait(dr, 30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='main']/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/div[1]/a[3]")));
	dr.findElement(By.xpath(".//*[@id='main']/div/div[1]/div[2]/div/ul/li[1]/ul/li[1]/div[1]/a[3]")).click();
	System.out.println("Test1 pass");
	List<WebElement> tab = dr.findElements(By.tagName("tr"));
	String S1="html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
	String S2="]/td[1]/div[2]/a[6]";
	int sel=tab.size();
	Random rad = new Random();
	int val=rad.nextInt(sel);
	dr.findElement(By.xpath(S1+val+S2)).click();
	System.out.println("Test2 pass");
	dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	String S3="html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
	String S4="]/td[1]/div[2]/ul/li[3]";
	dr.findElement(By.xpath(S3+val+S4)).click();
	System.out.println("Test3 pass");
	WebDriverWait wait1 = new WebDriverWait(dr, 30);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[3][@class='btn btn-xs btn-primary']/span[2]")));
	dr.findElement(By.xpath(".//button[3][@class='btn btn-xs btn-primary']/span[2]")).click();
	dr.findElement(By.xpath(".//*[@id='MainWrapper']/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[3]/div[1]/div/div/div[2]/div/div[1]/span/a[1]")).click();
	System.out.println("Test4 pass");
	dr.switchTo().frame(0);
	dr.findElement(By.xpath(".//*[@id='select2-chosen-2']")).click();
	List<WebElement> BUNit = dr.findElements(By.className("select2-results"));
	Thread.sleep(5000);
	String S5="html/body/div[3]/ul/li[";
	String S6 ="]/div";
	int sum =BUNit.size();
	Random nval = new Random(System.currentTimeMillis());
	int val1=nval.nextInt(sum);
	dr.findElement(By.xpath(S5+val1+S6)).click();
	dr.findElement(By.xpath(".//button[1][@class='btn btn-sm btn-default']")).click();
	dr.findElement(By.xpath("html/body/div[1]/form/div[2]/div[2]/div[3]/div[2]/div/table/tbody/tr/td[1]/a")).click();
	System.out.println("Test5 pass");
	dr.findElement(By.xpath(".//a[1][@class='btn btn-xs btn-default']")).click();
	dr.switchTo().frame(0);
	Thread.sleep(5000);
	dr.findElement(By.xpath("html/body/div[1]/form/div[2]/div[2]/div[2]/ul/li[1]/span/div/a/span[1]")).click();
	WebDriverWait wait2 = new WebDriverWait(dr, 20);
	List<WebElement> table1 =dr.findElements(By.xpath("html/body/div[3]/ul"));
	wait2.until(ExpectedConditions.visibilityOfAllElements(table1));
	String S7="html/body/div[3]/ul/li[";
	String S8="]/div";
	int tabval = table1.size();
	Random rand2= new Random(System.currentTimeMillis());
	int rval2 = rand2.nextInt(tabval);
	dr.findElement(By.xpath(S7+rval2+S8)).click();
	dr.findElement(By.xpath(".//button[1][@class='btn btn-sm btn-default']")).click();
	dr.findElement(By.xpath(".//a[1][@class='btn btn-xs btn-default']")).click();
	dr.findElement(By.id("Quantity")).sendKeys("100");
	dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[3]/div/button[1]")).click();
	/*dr.close();*/
	
}

}

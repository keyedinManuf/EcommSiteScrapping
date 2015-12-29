package selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testautocomplete {
	public static String str;
	public static void main(String [] args) throws InterruptedException{
	WebDriver dr=new FirefoxDriver();
	dr.navigate().to("http://kimdev01.keyedinuat.com/Dev03");
	dr.manage().window().maximize();
	dr.findElement(By.xpath(".//form[@method='post']/ul/li[1]/input")).sendKeys("lizc-admin");
	dr.findElement(By.xpath(".//form[@method='post']/ul/li[2]/input")).sendKeys("password");
	dr.findElement(By.xpath(".//form[@method='post']/ul/li[3]/input")).click();
	dr.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	dr.findElement(By.xpath(".//span[@class='k-icon k-icon-clipboard']")).click();
	dr.findElement(By.xpath(".//a[@href='/Dev03/Form/Create/70']")).click();
	dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[2]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
	dr.findElement(By.xpath("html/body/div[5]/div/input")).sendKeys("Test");
	dr.findElement(By.xpath("html/body/div[5]/ul/li[2]/div")).click();
	dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[5]/div[1]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
	Thread.sleep(1000);
	dr.findElement(By.xpath("html/body/div[6]/div/input")).sendKeys("KI Bikes");
	dr.findElement(By.xpath("html/body/div[6]/ul/li[1]/div")).click();
	dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[6]/div[1]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
	dr.findElement(By.xpath("html/body/div[7]/div/input")).sendKeys("CAD - Canadian Dollars");
	dr.findElement(By.xpath("html/body/div[7]/ul/li[1]/div")).click();
	dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[8]/div[2]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
	dr.findElement(By.xpath("html/body/div[8]/div/input")).sendKeys("Mark B");
	dr.findElement(By.xpath("html/body/div[8]/ul/li[1]/div")).click();
	dr.findElement(By.xpath(".//button[@class='btn btn-xs btn-success']")).click();
	dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement orderno = dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[1]/div/div/div[2]/div/div[1]/span"));
		str =orderno.getText();
	System.out.println("Created Sales order is :"+str);
  
	  dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[1]/button[3]")).click();
	  dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  dr.findElement(By.xpath(".//*[@id='s2id_autogen5']")).click();
	  List<WebElement> PartNumber = dr.findElements(By.className("select2-results"));
	  String s1="html/body/div[5]/ul/li[";
	  String s2="]/div";
	  int Size=PartNumber.size();
	  Random rand = new Random(System.currentTimeMillis());
	  int rval = rand.nextInt(Size);
	  Thread.sleep(3000);
	  dr.findElement(By.xpath(s1+rval+s2)).click();
	  dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[6]/div[1]/div/div/div[2]/div/div[1]/span/a[1]")).click();
	  dr.switchTo().frame(0);
	  dr.findElement(By.xpath("html/body/div/form/div[2]/div[2]/div[2]/ul/li[1]/span/div/a/span[1]")).click();
	  List<WebElement> DDA = dr.findElements(By.xpath("html/body/div[3]/ul"));
	  dr.findElement(By.xpath("html/body/div[3]/ul/li[1]/div")).click();
	  dr.findElement(By.xpath(".//button[@class='btn btn-sm btn-default']")).click();
	  dr.findElement(By.xpath("html/body/div[1]/form/div[2]/div[2]/div[3]/div[2]/div/table/tbody/tr/td[1]/a")).click();
	  dr.findElement(By.id("Quantity")).sendKeys("10");
	  dr.findElement(By.id("List_Price")).sendKeys("100");
	  dr.findElement(By.id("Shipping_Charges")).sendKeys("12");
	  dr.findElement(By.xpath(".//button[@class='btn btn-xs btn-success']")).click();
	
}
}
		 
//List<WebElement> options = driver.findElements(By.xpath("html/body/div[5]/ul/li[1]/div"));
//Iterator i = options.iterator();
// while(i.hasNext()){
//	 WebElement row= (WebElement) i.next();
//	 System.out.println("Randomly selected value is :"+row.getText());
//	 row.click();
//}	 
	 
//	 for(WebElement ele:autoPopulatedList)  
//	 {  
//		 System.out.println(ele.getText());
//	      if(ele.getText().equals("testng"))
//	      {
//	             System.out.println("Your case passed..!!");
//	      }  
//	 }  


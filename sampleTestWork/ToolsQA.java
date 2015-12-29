package sampleTestWork;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToolsQA {

	public static WebDriver dr; 
	
	public static void main(String[] args) throws InterruptedException{
		
		dr = new FirefoxDriver();
		dr.navigate().to("http://www.tutorialspoint.com/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.findElement(By.xpath(".//*[@id='liTL']/a")).click();
		List<WebElement> li =dr.findElements(By.xpath(".//*[@id='top-sub-menu']/div[1]/a"));
		System.out.println("The options are:");
		for(WebElement TextList : li){
			String output = TextList.getText();
			System.out.println(output);
		}
		Random rand = new Random(System.currentTimeMillis());
		WebElement web =li.get(rand.nextInt(li.size()));
		String result = web.getText();
		System.out.println("The selected option from the list: "+result);
		web.click();
		dr.close();
	
		
	}
}

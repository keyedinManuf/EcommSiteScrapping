package selenium;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ramdomvalueselection {
public static WebDriver dr = new FirefoxDriver();

public static void main(String[] args){
	
	dr.navigate().to("https://www.google.co.in/");
	dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	dr.findElement(By.name("q")).sendKeys("Selenium");
	List<WebElement>options = dr.findElements(By.className("sbsb_b"));
	for(int i=0; i<=options.size();i++){
	System.out.print(options.get(i).getText());
	options.get(i).click();
	break;
	
	}
	dr.close();
	}}
  
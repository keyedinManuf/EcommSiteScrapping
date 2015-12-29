package sampleTestWork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test_05 {
public static WebDriver dr;
public static void main(String[] args){
	dr = new FirefoxDriver();
	dr.get("http://toolsqa.com/automation-practice-table/");
	String City = dr.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[2]")).getText();
	System.out.println(City);
	
	String Clock = dr.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[2]/th")).getText();
	System.out.println(Clock);
	
	for(int i=0; i<=7;i++){
	List<WebElement> l = dr.findElements(By.xpath(".//*[@id='content']/table/tbody/tr[2]/td["+i+"]"));
	for(WebElement list:l){
		String print =list.getText();
		System.out.println(print);
	}
	
}
dr.quit();
}
}
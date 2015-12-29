package StaticSite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import StaticSite.SCSWriteCSV;

public class sample_test {

	public static WebDriver dr;
	public static String title;
	public static String Text;
	
	
	public static void GetTitle() throws Exception{
		SCSWriteCSV.getExcelPath("C:\\Users\\sakthivel\\Documents\\SCS\\SCS.xlsx", "Title");
		dr = new FirefoxDriver();
		dr.get("http://www.scs.co.uk/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement Fabric = dr.findElement(By.xpath(".//*[@id='nav-main__list']/li[2]/a"));
		Actions act = new Actions(dr);
		act.moveToElement(Fabric).click().perform();
		dr.findElement(By.xpath(".//*[@id='nav-main__list']/li[2]/div/div/div[1]/ul/li[4]/a")).click();
		JavascriptExecutor jse = (JavascriptExecutor)dr;
		jse.executeScript("scroll(0, 250)"); 
		WebElement D =dr.findElement(By.xpath(".//*[@id='search-result-items']/li[1]"));
		act.moveToElement(D).click().build().perform();
		title = dr.getTitle();
		SCSWriteCSV.SetExcelData(1, 1, title);
	}
	
	public static void Description()throws Exception{
		
		SCSWriteCSV.getExcelPath("C:\\Users\\sakthivel\\Documents\\SCS\\SCS.xlsx", "Description");
		JavascriptExecutor jse = (JavascriptExecutor)dr;
		jse.executeScript("scroll(0, 500)");
		WebElement ProductInfo = dr.findElement(By.xpath(".//*[@id='product-information']/div/div/div/div"));
		Text= ProductInfo.getText();
//		System.out.println("Description:"+Text);
		SCSWriteCSV.SetExcelData(1, 1, Text);
		
	}
	
	public static void main(String[] args) throws Exception{
		GetTitle();
		Description();
		dr.close();
	}
}

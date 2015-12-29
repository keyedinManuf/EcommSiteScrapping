package StaticSite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StaticSite.SCSWriteCSV;

public class SCS {

	public static WebDriver dr;
	public static String title;
	public static String Text;
	public static int i, j;
	
	public static void GetProductTitle() throws Exception{
		SCSWriteCSV.getExcelPath("C:\\Users\\sakthivel\\Documents\\SCS\\SCS.xlsx", "Title");
		title=dr.getTitle();
		int j=1;
		SCSWriteCSV.SetExcelData(i,j,title);
	}
	
	public static void GetProductDescription() throws Exception{
		SCSWriteCSV.getExcelPath("C:\\Users\\sakthivel\\Documents\\SCS\\SCS.xlsx", "Description");
		int j=1;
		JavascriptExecutor jse = (JavascriptExecutor)dr;
		jse.executeScript("scroll(0, 1500)");
		WebDriverWait wait = new WebDriverWait(dr,15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='product-information']/div/div/div/div")));
		WebElement ProductInfo = dr.findElement(By.xpath(".//*[@id='product-information']/div/div/div/div"));
		Text= ProductInfo.getText();
		TimeUnit.SECONDS.sleep(5);
		dr.navigate().back();	
		SCSWriteCSV.SetExcelData(i,j,Text);
	}
	
	public static void main(String[] args) throws Exception{
		
		dr = new FirefoxDriver();
		dr.get("http://www.scs.co.uk/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement Fabric = dr.findElement(By.xpath(".//*[@id='nav-main__list']/li[2]/a"));
		Actions act = new Actions(dr);
		act.moveToElement(Fabric).click().perform();
		dr.findElement(By.xpath(".//*[@id='nav-main__list']/li[2]/div/div/div[1]/ul/li[4]/a")).click();
		dr.findElement(By.xpath(".//*[@id='wrapper']/div[4]/div/div/div/div[2]/div/div[1]/div/div/a")).click();
		dr.findElement(By.xpath(".//*[@id='category-level-2']/li[1]/a")).click();
		JavascriptExecutor jse = (JavascriptExecutor)dr;
		jse.executeScript("scroll(0, 2500)");
		List<WebElement> options=dr.findElements(By.xpath(".//*[@id='wrapper']/div[3]/div/div/div/div[3]/ul[1]/li"));
		int n=options.size();
		System.out.println("Total number of items: "+n);
		for(i=1; i<=n; i++){
		String str1=".//*[@id='wrapper']/div[3]/div/div/div/div[3]/ul[1]/li[";
		String str2="]";
		dr.findElement(By.xpath(str1+i+str2)).click();
		GetProductTitle();
		GetProductDescription();
		}
		dr.findElement(By.xpath(".//*[@id='wrapper']/div[3]/div/div/div/div[3]/ul[2]/li[1]")).click();
		title=dr.getTitle();
		SCSWriteCSV.SetExcelData(15,1,title);
		JavascriptExecutor jse1 = (JavascriptExecutor)dr;
		jse1.executeScript("scroll(0, 1500)");
		WebDriverWait wait = new WebDriverWait(dr,15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='product-information']/div/div/div/div")));
		WebElement ProductInfo = dr.findElement(By.xpath(".//*[@id='product-information']/div/div/div/div"));
		Text= ProductInfo.getText();
		TimeUnit.SECONDS.sleep(5);
		SCSWriteCSV.SetExcelData(15,1,Text);
		dr.quit();
		}
}
		
		
	


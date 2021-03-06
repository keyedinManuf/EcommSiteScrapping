package StaticSite;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
	 
	public static void GetMainImage() throws AWTException, InterruptedException{
		dr.findElement(By.xpath(".//*[@id='wrapper']/div[3]/div/div[1]/ul/li/div/img")).click();
		Actions act = new Actions(dr).contextClick();
		act.click().build().perform();
		Robot down = new Robot();
		down.delay(3000);
		down.keyPress(KeyEvent.VK_V);
		down.keyRelease(KeyEvent.VK_V);
		dr.switchTo().frame(1);
		down.keyPress(KeyEvent.VK_ENTER);
		down.keyRelease(KeyEvent.VK_ENTER);
		down.keyRelease(KeyEvent.VK_ESCAPE);
		down.keyRelease(KeyEvent.VK_ESCAPE);
		TimeUnit.SECONDS.sleep(4);
		dr.navigate().refresh();
		
		
	}
	
	public static void GetWindsorTitle() throws Exception{
		SCSWriteCSV.getExcelPath("C:\\Users\\sakthivel\\Documents\\SCS\\SCS.xlsx", "Title");
		title=dr.getTitle();
		SCSWriteCSV.SetExcelData(15,1,title);
	}
	
	public static void GetWindsorDescription() throws Exception{
		SCSWriteCSV.getExcelPath("C:\\Users\\sakthivel\\Documents\\SCS\\SCS.xlsx", "Description");
		JavascriptExecutor jse1 = (JavascriptExecutor)dr;
		jse1.executeScript("scroll(0, 1500)");
		WebDriverWait wait = new WebDriverWait(dr,15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='product-information']/div/div/div/div")));
		WebElement ProductInfo = dr.findElement(By.xpath(".//*[@id='product-information']/div/div/div/div"));
		Text= ProductInfo.getText();
		TimeUnit.SECONDS.sleep(5);
		SCSWriteCSV.SetExcelData(15,1,Text);
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
		WebDriverWait filt = new WebDriverWait(dr, 10);
		filt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='wrapper']/div[4]/div/div/div/div[2]/div/div[1]/div/div/a")));
		WebElement Filter =dr.findElement(By.xpath(".//*[@id='wrapper']/div[4]/div/div/div/div[2]/div/div[1]/div/div/a"));
		act.moveToElement(Filter).click().perform();
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
		GetMainImage();
		GetProductDescription();
		}
		dr.findElement(By.xpath(".//*[@id='wrapper']/div[3]/div/div/div/div[3]/ul[2]/li[1]")).click();
		List<WebElement> option=dr.findElements(By.xpath(".//*[@id='wrapper']/div[3]/div/div/div/div[3]/ul[2]/li"));
		int no=option.size();
		System.out.println("Total number of items: "+no);
		for(i=1;i<=no;i++){
			String str1=".//*[@id='wrapper']/div[3]/div/div/div/div[3]/ul[2]/li[";
			String str2="]";
			dr.findElement(By.xpath(str1+i+str2)).click();
			GetWindsorTitle();
			GetMainImage();
			GetWindsorDescription();
		}
		dr.quit();
		}
}
		
		
	


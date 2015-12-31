package StaticSite;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class downloadImage {

	public static WebDriver dr;
	public static void main(String[] args) throws AWTException{
		dr= new FirefoxDriver();
		dr.navigate().to("http://www.scs.co.uk/endurance-jewell-4-seater-sofa/L027820_ENDURANCE-FABRIC-BLACK-CTRST-STITCH_CHROME-FOOT.html?cgid=fabric-sofas-4-seaters");
		dr.findElement(By.xpath(".//*[@id='wrapper']/div[3]/div/div[1]/ul/li/div/img")).click();
		Actions act = new Actions(dr).contextClick();
		act.click().build().perform();
		Robot down = new Robot();
		down.delay(2000);
		down.keyPress(KeyEvent.VK_V);
		down.keyRelease(KeyEvent.VK_V);
		dr.switchTo().frame(1);
		down.keyPress(KeyEvent.VK_ENTER);
		down.keyRelease(KeyEvent.VK_ENTER);
		down.keyPress(KeyEvent.VK_ESCAPE);
		
		
	}
}

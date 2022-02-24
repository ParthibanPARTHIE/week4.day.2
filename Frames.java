package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	public static void main (String [] args) {
		  WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
			driver.manage().window().maximize();
			driver.switchTo().frame("frame1");
			driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input")).sendKeys("Not a Friendly Topic");
			
			driver.switchTo().frame("frame3");
			
			driver.findElement(By.id("a")).click();
			driver.switchTo().defaultContent();
			
			driver.switchTo().frame("frame2");
			
			WebElement findElement = driver.findElement(By.id("animals"));
			Select select = new Select(findElement);
			select.selectByVisibleText("Avatar");
	}
	

}

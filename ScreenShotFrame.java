package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotFrame {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement button = driver.findElement(By.id("Click"));
		button.click();
		File source = button.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/main/resources/snaps/Img002.jpg");
		FileUtils.copyFile(source, dest);
		driver.switchTo().defaultContent()	;
		driver.switchTo().frame(1);
		driver.switchTo().frame(0);
		driver.findElement(By.tagName("button")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame(0);
		WebElement text = driver.findElement(By.tagName("body"));
		System.out.println(text.getText());
		driver.switchTo().defaultContent();
		List<WebElement>frames =driver.findElements(By.tagName("iframe"));
		int totalframes = frames.size();
		System.out.println(totalframes);
		
		
		
	
		
		
		
		
	}

}

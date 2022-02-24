package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {
	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://jqueryui.com/selectable/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.switchTo().frame(0);
			WebElement element1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
			WebElement element2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
			WebElement element3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
			WebElement element4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
			WebElement element5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
			Actions builder = new Actions(driver);
			builder.keyDown(Keys.CONTROL).click(element1).click(element2).click(element3).click(element4).click(element5).keyUp(Keys.CONTROL).perform();
			

}}

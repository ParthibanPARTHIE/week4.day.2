package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {
	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://jqueryui.com/sortable/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.switchTo().frame(0);
		    List<WebElement> list=driver.findElements(By.xpath("//ul[@id='sortable']/li"));
		    WebElement from=list.get(0);
			WebElement to= list.get(5);
       		Actions sortable1 = new Actions(driver);
       		sortable1.clickAndHold(from);
       		sortable1.moveToElement(to);
       		sortable1.release(to);
       		sortable1.build().perform();
       		
       		
	}

       		}

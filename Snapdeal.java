package week4.day2;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*
		 * * Assignment 7: ============ 1. Launch https://www.snapdeal.com/ 2. Go to
		 * Mens Fashion 3. Go to Sports Shoes 4. Get the count of the sports shoes 5.
		 * Click Training shoes 6. Sort by Low to High 7. Check if the items displayed
		 * are sorted correctly 8.Select the price range (900-1200) 9.Filter with color
		 * Navy 10 verify the all applied filters 11. Mouse Hover on first resulting
		 * Training shoes 12. click QuickView button 13. Print the cost and the discount
		 * percentage 14. Take the snapshot of the shoes. 15. Close the current window
		 * 16. Close the main window 
		 */
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement mensFashionElement = driver.findElement(By.xpath("//span[contains(text(),\"Men's Fashion\")]"));
		Actions action = new Actions(driver);
		action.moveToElement(mensFashionElement).click().perform();
		driver.findElement(By.xpath("(//span[contains(text(),\"Sports Shoes\")])[1]")).click();
		String numberOfSportShoes = driver.findElement(By.xpath("//span[contains(@class,'category-count')]")).getText();
		System.out.println(numberOfSportShoes);
		driver.findElement(By.xpath("//div[contains(text(),'Training Shoes')]")).click();
		List <WebElement> priceListUnsorted = driver.findElements(By.xpath("//span[@data-price]"));
		driver.findElement(By.className("sort-selected")).click();
		driver.findElement(By.xpath("//*[@class=\"sort-value\"]/li[2]")).click();
		List<WebElement> priceListSorted = driver.findElements(By.xpath("//span[@data-price]"));
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("900");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200");
		WebElement firstTrainingShoe = driver.findElement(By.xpath("(//picture/img)[1]"));
		
		action.moveToElement(firstTrainingShoe).click(driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"))).perform();
		
		System.out.println("Price of the product is : " + driver.findElement(By.className("payBlkBig")).getText());
		System.out.println("Discount % of the product is : " + driver.findElement(By.xpath("//*[contains(@class,'percent-desc')]")).getText());
		WebElement shoeImage = driver.findElement(By.xpath("(//img[@class='cloudzoom'])[1]"));
		File src = shoeImage.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/snap/shoe.jpg");
		FileUtils.copyFile(src, dest);
		driver.quit();
	}

}
	
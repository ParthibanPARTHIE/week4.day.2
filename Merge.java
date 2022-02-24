package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Merge {
	public static void main (String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.id("username")).sendKeys("Democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		String home = driver.getWindowHandle();
		driver.findElement(By.xpath("(//img[@src = '/images/fieldlookup.gif'])[1]")).click();
		Set<String>from = driver.getWindowHandles();
		List<String>listfrom = new ArrayList<String>(from);
		String SecondWindow = listfrom.get(1);
        driver.switchTo().window(SecondWindow);
        driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
        driver.switchTo().window(home);
        driver.findElement(By.xpath("(//img[@src = '/images/fieldlookup.gif'])[2]")).click();
        Set<String>to = driver.getWindowHandles();
		List<String>listto = new ArrayList<String>(to);
		String thirdWindow = listto.get(1);
        driver.switchTo().window(thirdWindow);
        driver.findElement(By.xpath("(//a[@class='linktext'])[11]")).click();
		driver.switchTo().window(home);
		driver.findElement(By.xpath("//a[text()= 'Merge']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Page title is: "+driver.getTitle());


}}

package Ayatana;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gallery {
	public static  WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeSuite 
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://ayatana.xircular.io/admin/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys("ayatanadev@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Ayatanaphygital@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//div[.='Content Manager']")).click();
	}
	
	@Test
	
	public void images() throws AWTException {
		driver.findElement(By.xpath("//span[.='Gallery']")).click();
		WebElement createvariant = driver.findElement(By.xpath("//span[.='Create new entry']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", createvariant);
		driver.findElement(By.xpath("//button[@class='sc-bdvvtL sc-gsDKAQ DaXIO cESTgu']")).click();
		WebElement popup = driver.findElement(By.xpath("//div[@aria-labelledby='asset-dialog-title']"));
		popup.click();
		WebElement add_assets = driver.findElement(By.xpath("//span[.='Add more assets']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", add_assets);
		driver.findElement(By.xpath("//span[.='From url']")).click();
		driver.findElement(By.xpath("//textarea[@aria-describedby='urls-hint']")).sendKeys("https://ayatana.xircular.io/uploads/Frame_13783_1591172255.png");
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//textarea[@aria-describedby='urls-hint']")).sendKeys("https://ayatana.xircular.io/uploads/Whats_App_Image_2023_08_04_at_09_45_21_b41977bfd6.jpg");
		driver.findElement(By.xpath("//button[.='Next']")).click();
		driver.findElement(By.xpath("//button[.='Upload 2 asset to the library']")).click();
		driver.findElement(By.xpath("//button[.='Finish']")).click();
		//System.out.println(popup.getText());
	}
}

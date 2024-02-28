package Zalora;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageSearching {
	public static  WebDriver driver;
	private static WebDriverWait wait;
	@SuppressWarnings("unused")
	private static int size_of_edit_icons;

	@SuppressWarnings("deprecation")
	public void setup() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://sellercenter.zalora.com/new/user/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		//Login
		driver.findElement(By.id("email")).sendKeys("partners@styletribute.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("B2b12345");
		WebElement submit = driver.findElement(By.id("submit"));
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		submit.click();

		WebElement catelog = driver.findElement(By.xpath("//div[.='Catalog']"));
		wait.until(ExpectedConditions.elementToBeClickable(catelog));
		catelog.click();

		WebElement all_products = driver.findElement(By.xpath("//div[.='All Products']"));
		wait.until(ExpectedConditions.elementToBeClickable(all_products));
		all_products.click();

		WebElement products = driver.findElement(By.xpath("//span[.='Products  ']"));
		wait.until(ExpectedConditions.elementToBeClickable(products));
		products.click();










		WebElement manage_images = driver.findElement(By.xpath("//span[.='Manage Images']"));
		wait.until(ExpectedConditions.elementToBeClickable(manage_images));
		manage_images.click();
		Thread.sleep(5000);
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='SKU or any other available criteria']"));


		for(int i=0; i<29; i++) {

			FileInputStream filein = new FileInputStream("D:\\javanew\\Styletribute\\src\\test\\java\\Zalora\\New Microsoft Office Excel Worksheet.xlsx");
			Workbook book = WorkbookFactory.create(filein);

			Cell dename = book.getSheet("Sheet1").getRow(i).getCell(0);
			String style = dename.getStringCellValue();
			search.sendKeys(style);
			Thread.sleep(100);
			Robot keys = new Robot();
			keys.keyPress(KeyEvent.VK_ENTER);
			keys.keyRelease(KeyEvent.VK_ENTER);
		}
		

	}

	public void editing() throws InterruptedException {



		for(int i=0; i<size_of_edit_icons; i++) {

			WebElement image_size = driver.findElements(By.xpath("//span[@class='image-size']")).get(i);

			if(image_size.getText().contains("620x620")) {

				WebElement edit_icons = driver.findElements(By.xpath("//i[@class='iconset-btn iconset-edit']")).get(i);
				wait.until(ExpectedConditions.elementToBeClickable(edit_icons));
				edit_icons.click();

				for(int j=1; j<=6; j++) {

					WebElement crop_box = driver.findElement(By.className("cropper-crop-box"));
					wait.until(ExpectedConditions.visibilityOf(crop_box));

					WebElement zoomout = driver.findElement(By.xpath("//button[@title='Zoom Out']"));
					wait.until(ExpectedConditions.elementToBeClickable(zoomout));
					zoomout.click();

					//							WebElement zoomin = driver.findElement(By.xpath("//button[@title='Zoom In']"));
					//							wait.until(ExpectedConditions.elementToBeClickable(zoomin));
					//							zoomin.click();
				}
				
				WebElement crop = driver.findElement(By.xpath("//button[@title='Crop']"));
				wait.until(ExpectedConditions.elementToBeClickable(crop));
				crop.click();
			}
		}
	}


	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException, AWTException {

		ImageSearching execute = new ImageSearching();
		execute.setup();
		PageObjects no_of_units = new PageObjects(driver);
		Thread.sleep(2000);
		for(int k=1; k<=3; k++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
			size_of_edit_icons = no_of_units.edit_icons.size();
			System.out.println("total images - "+size_of_edit_icons);
			execute.editing();
			Thread.sleep(8000);
		}
		
		
		
		//		WebElement page = driver.findElement(By.xpath("//a[@class='paginate_button']"));
		//		if(page.isDisplayed()) {
		//
		//			List<WebElement> pages = driver.findElements(By.xpath("//a[@class='paginate_button']"));
		//			int size = pages.size();
		//			System.out.println("pages - "+size);
		//
		//			for(int k=0; k<size; k++) {
		//				WebElement next_page = pages.get(k);
		//				wait.until(ExpectedConditions.elementToBeClickable(next_page));
		//				next_page.click();
		//				int size_of_edit_icons1 = no_of_units.edit_icons.size();
		//				System.out.println("total images - "+size_of_edit_icons1);
		//				execute.editing();
		//			}
		//		}
	}
}
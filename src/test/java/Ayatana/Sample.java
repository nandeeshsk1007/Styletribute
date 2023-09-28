package Ayatana;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
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
	public void content() throws InterruptedException, AWTException, EncryptedDocumentException, IOException {

		int row=1;
		int namec=3;
		int descriptioc=4;
		int sizec=47;
		int pricec=5;
		int designerc=11;
		int colorc=45;
		int materialc=46;
		int conditionc=12;
		int skucodec=1;

		for(int i=1; i<=1; i++) {

//			//File input
//			FileInputStream filein = new FileInputStream("D:\\javanew\\Styletribute\\src\\test\\java\\Ayatana\\boook.xlsx");
//			Workbook book = WorkbookFactory.create(filein);
//
//			//Product name
//			Cell productname = book.getSheet("Sheet1").getRow(row).getCell(namec);
//			String name = productname.getStringCellValue();
//
//			//Product description
//			Cell productdescription = book.getSheet("Sheet1").getRow(row).getCell(descriptioc);
//			String description = productdescription.getStringCellValue();

			driver.findElement(By.xpath("//div[.='Content Manager']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[.='Product']")).click();
			Thread.sleep(1000);
			WebElement createproduct = driver.findElement(By.xpath("//span[.='Create new entry']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", createproduct);

			Thread.sleep(2000);
			driver.findElement(By.xpath("//section[@aria-label='thumbnail']")).click();
			Thread.sleep(1000);
			int in = driver.getWindowHandles().size();
			System.out.println(in);
			driver.switchTo().window(null);
			driver.findElement(By.xpath("//*[@id=\"folder-61-77-title\"]/button/h2/span[1]/text()")).click();
			


//			//Product creation
//			driver.findElement(By.name("title")).sendKeys(name);
//			driver.findElement(By.id("description")).sendKeys(description);
//			driver.findElement(By.id("product_category")).sendKeys("Jewellery");
//			Thread.sleep(1000);	
//			Robot keys = new Robot();
//			keys.keyPress(KeyEvent.VK_ENTER);
//			keys.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(1000);
//			WebElement productsave = driver.findElement(By.xpath("//span[.='Save']"));
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", productsave);
//			Thread.sleep(1000);
//			WebElement productpublish = driver.findElement(By.xpath("//span[.='Publish']"));
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", productpublish);
//			Thread.sleep(1000);
//
//			//Product variant creation
//			driver.findElement(By.xpath("//span[.='Product_variant']")).click();
//			WebElement createvariant = driver.findElement(By.xpath("//span[.='Create new entry']"));
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", createvariant);
//			driver.findElement(By.name("title")).sendKeys(name);
//			driver.findElement(By.id("description")).sendKeys(description);
//
//			//Product size
//			Cell productsize = book.getSheet("Sheet1").getRow(row).getCell(sizec);
//			String size = productsize.getStringCellValue();
//			driver.findElement(By.name("size")).sendKeys(size);
//
//			//Product selection
//			driver.findElement(By.id("product")).sendKeys(name);
//			Thread.sleep(2000);
//			keys.keyPress(KeyEvent.VK_ENTER);
//			keys.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(1000);
//
//			//Product price
//			Cell productprice = book.getSheet("Sheet1").getRow(row).getCell(pricec);
//			double price_in_double = productprice.getNumericCellValue();
//			int price_in_integer = (int) price_in_double;
//			String price = String.valueOf(price_in_integer);
//			driver.findElement(By.name("price")).sendKeys("S$"+price);
//
//			//Product designer
//			Cell productdesigner = book.getSheet("Sheet1").getRow(row).getCell(designerc);
//			String designer = productdesigner.getStringCellValue();
//
//			//Product color
//			Cell productcolor = book.getSheet("Sheet1").getRow(row).getCell(colorc);
//			String color = productcolor.getStringCellValue();
//
//			//Product material
//			Cell productmaterial = book.getSheet("Sheet1").getRow(row).getCell(materialc);
//			String material = productmaterial.getStringCellValue();
//
//			//Product condition
//			Cell productcondition = book.getSheet("Sheet1").getRow(row).getCell(conditionc);
//			String condition = productcondition.getStringCellValue();
//
//			//Product code
//			Cell productcode = book.getSheet("Sheet1").getRow(row).getCell(skucodec);
//			String code = productcode.getStringCellValue();
//
//			if(designer!=null) {
//				driver.findElement(By.id("key_features")).sendKeys("DESIGNER - "+designer);
//			}			
//			if(color!=null) {
//				keys.keyPress(KeyEvent.VK_ENTER);
//				keys.keyRelease(KeyEvent.VK_ENTER);
//				driver.findElement(By.id("key_features")).sendKeys("COLOR - "+color);
//			}
//			if(material!=null) {
//				keys.keyPress(KeyEvent.VK_ENTER);
//				keys.keyRelease(KeyEvent.VK_ENTER);
//				driver.findElement(By.id("key_features")).sendKeys("MATERIAL - "+material);
//			}
//			if(condition!=null) {
//				keys.keyPress(KeyEvent.VK_ENTER);
//				keys.keyRelease(KeyEvent.VK_ENTER);
//				driver.findElement(By.id("key_features")).sendKeys("CONDITION - "+condition);
//			}
//			if(code!=null) {
//				keys.keyPress(KeyEvent.VK_ENTER);
//				keys.keyRelease(KeyEvent.VK_ENTER);
//				driver.findElement(By.id("key_features")).sendKeys("PRODUCT CODE - "+code);
//			}
//			WebElement variantsave = driver.findElement(By.xpath("//span[.='Save']"));
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", variantsave);
//			Thread.sleep(1000);
//			WebElement variantpublish = driver.findElement(By.xpath("//span[.='Publish']"));
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", variantpublish);
//			Thread.sleep(1000);
//			row++;
		}
		Thread.sleep(2000);
		//driver.quit();
	}
}

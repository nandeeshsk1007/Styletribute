package Shopify;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductsCreate {

	public static  WebDriver driver;
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setup() throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://admin.shopify.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		driver.findElement(By.name("account[email]")).sendKeys("styletribute.shopify@gmail.com");
		WebElement submit1 = driver.findElement(By.name("commit"));
		wait.until(ExpectedConditions.elementToBeClickable(submit1)).click();
		driver.findElement(By.name("account[password]")).sendKeys("Shopify@123");
		WebElement submit2 = driver.findElement(By.xpath("//button[.='Log in']"));
		wait.until(ExpectedConditions.elementToBeClickable(submit2)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='Polaris-Navigation__ItemInnerWrapper_1umqf'])[2]"))).click();

	}

	@Test
	public void productsAdding() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
//		int row=72;
//		int title=1;
//		//int description=2;
//		int images=8;
//		int price=3;
//		int oldprice=4;
//		int sku=0;
//		//		int size=7;
//		//		int seller=33;
//		//		int dimensions=5;
//		//		int material=6;
//		//		int condition=32;
//		//		int color=12;
//		//		int designer=31;
//		for(int j=1; j<=2; j++) {
//
//			FileInputStream filein = new FileInputStream("D:\\javanew\\Styletribute\\src\\test\\java\\Ayatana\\boook.xlsx");
//			Workbook book = WorkbookFactory.create(filein);
//
			driver.findElement(By.xpath("//span[.='Add product']")).click();
			driver.findElement(By.xpath("//input[@name='productType']")).sendKeys("BAGS");
			driver.findElement(By.xpath("//input[@class='Polaris-TextField__Input_30ock Polaris-TextField__Input--alignLeft_exwxn']")).sendKeys("1");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"metafields.custom.seller_customer_id\"]/div/span/div/div")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys("11");
			driver.findElement(By.name("title")).click();
			driver.findElement(By.xpath("//*[@id=\"metafields.custom.size\"]/div/span/div/div")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys("22");
			driver.findElement(By.name("title")).click();
			driver.findElement(By.xpath("//*[@id=\"metafields.custom.date_of_entry\"]/div/span/div/div")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys("33");
			driver.findElement(By.name("title")).click();
			driver.findElement(By.xpath("//*[@id=\"metafields.custom.seller\"]/div/span/div/div")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys("44");
			driver.findElement(By.name("title")).click();
			driver.findElement(By.xpath("//*[@id=\"metafields.custom.dimensions\"]/div/span/div/div")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys("55");
			driver.findElement(By.name("title")).click();
			driver.findElement(By.xpath("//*[@id=\"metafields.custom.heel_height\"]/div/span/div/div")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys("66");
			driver.findElement(By.name("title")).click();
			driver.findElement(By.xpath("//*[@id=\"metafields.custom.material\"]/div/span/div/div")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys("77");
			driver.findElement(By.name("title")).click();
			driver.findElement(By.xpath("//*[@id=\"metafields.custom.condition\"]/div/span/div/div")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys("88");
			driver.findElement(By.name("title")).click();
			driver.findElement(By.xpath("//*[@id=\"metafields.custom.color\"]/div/span/div/div")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys("99");
			driver.findElement(By.name("title")).click();
			driver.findElement(By.xpath("//*[@id=\"metafields.custom.designer\"]/div/span/div/div")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys("00");
			driver.findElement(By.name("title")).click();
//			Cell productname = book.getSheet("Sheet3").getRow(row).getCell(title);
//			String titlev = productname.getStringCellValue();
//			driver.findElement(By.name("title")).sendKeys(titlev);
//
//			WebElement file = driver.findElement(By.xpath("//button[@class='Polaris-Button_r99lw Polaris-Button--sizeLarge_61dxo Polaris-Button--primary_7k9zs Polaris-Button--success_z03ht']"));
//			file.click();
//
//			//		Cell productdescription = book.getSheet("Sheet3").getRow(row).getCell(description);
//			//		String descriptionv = productdescription.getStringCellValue();
//			//		driver.findElement(By.id("tinymce")).click();
//			//		driver.switchTo().frame("tinymce");
//			//		driver.findElement(By.tagName("body")).sendKeys(descriptionv);
//
//			Cell productprice = book.getSheet("Sheet3").getRow(row).getCell(price);
//			double price_in_double = productprice.getNumericCellValue();
//			int price_in_integer = (int) price_in_double;
//			String price1 = String.valueOf(price_in_integer);
//
//			Cell productoldprice = book.getSheet("Sheet3").getRow(row).getCell(oldprice);
//			double oprice_in_double = productoldprice.getNumericCellValue();
//			int oprice_in_integer = (int) oprice_in_double;
//			String oprice1 = String.valueOf(oprice_in_integer);
//
//			Cell productsku = book.getSheet("Sheet3").getRow(row).getCell(sku);
//			String skuv = productsku.getStringCellValue();
//
//			//		Cell productsize = book.getSheet("Sheet3").getRow(row).getCell(size);
//			//		String sizev = productsize.getStringCellValue();
//			//		
//			//		Cell productseller = book.getSheet("Sheet3").getRow(row).getCell(seller);
//			//		String sellerv = productseller.getStringCellValue();
//			//		
//			//		Cell productdimensions = book.getSheet("Sheet3").getRow(row).getCell(dimensions);
//			//		String dimensionsv = productdimensions.getStringCellValue();
//			//		
//			//		Cell productmaterial = book.getSheet("Sheet3").getRow(row).getCell(material);
//			//		String materialv = productmaterial.getStringCellValue();
//			//		
//			//		Cell productcondition = book.getSheet("Sheet3").getRow(row).getCell(condition);
//			//		String conditionv = productcondition.getStringCellValue();
//			//		
//			//		Cell productcolor = book.getSheet("Sheet3").getRow(row).getCell(color);
//			//		String colorv = productcolor.getStringCellValue();
//			//		
//			//		Cell productdesigner = book.getSheet("Sheet3").getRow(row).getCell(designer);
//			//		String designerv = productdesigner.getStringCellValue();
//
//			for(int i=1; i<=23; i++) {
//				Thread.sleep(2000);
//				Cell productimages = book.getSheet("Sheet3").getRow(row).getCell(images);
//				String imagesv = productimages.getStringCellValue();
//
//				WebElement add = driver.findElement(By.xpath("//button[.='Add from URL']"));
//				((RemoteWebDriver) driver).executeScript("arguments[0].scrollIntoView(true);", add);
//				((JavascriptExecutor) driver).executeScript("arguments[0].click();", add);
//				driver.findElement(By.xpath("//div[@class='Polaris-Modal-Dialog__Modal_2v9yc']")).click();
//				WebElement text = driver.findElement(By.xpath("//input[@placeholder='https://']"));
//				text.sendKeys(imagesv);
//				Thread.sleep(1000);
//
//
//				if(text.getAttribute("value").contains("http")) {
//					WebElement addfile = driver.findElement(By.xpath("//button[.='Add file']"));
//					((RemoteWebDriver) driver).executeScript("arguments[0].scrollIntoView(true);", addfile);
//					((JavascriptExecutor) driver).executeScript("arguments[0].click();", addfile);
//				}
//				else {
//					Thread.sleep(1000);
//					WebElement cancelfile = driver.findElement(By.xpath("//button[.='Cancel']"));
//					((JavascriptExecutor) driver).executeScript("arguments[0].click();", cancelfile);
//					Thread.sleep(1000);
//					images=8;
//					break;
//				} 
//				images++;
//			}
//			Thread.sleep(1000);
//			WebElement pricef = driver.findElement(By.xpath("//input[@name='price']"));
//			pricef.clear();
//			pricef.sendKeys(price1);
//			driver.findElement(By.name("compareAtPrice")).sendKeys(oprice1);
//			driver.findElement(By.name("sku")).sendKeys(skuv);
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//button[@class='Polaris-Button_r99lw Polaris-Button--sizeLarge_61dxo Polaris-Button--primary_7k9zs Polaris-Button--success_z03ht']")).click();
//			Thread.sleep(2000);
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			System.out.println(skuv);
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Products']"))).click();
//			row++;
//			
//		}
//		//		WebElement sizef = driver.findElement(By.cssSelector("#metafields\\.custom\\.size > div:nth-child(1) > span:nth-child(2) > div:nth-child(1) > div:nth-child(1)"));
//		//		sizef.click();
//		//		Thread.sleep(2000);
//		//		driver.findElement(By.xpath("//div[@class='D1AeJ HKyRn LpMTp']")).click();
//		//		WebElement sizef2 = driver.findElement(By.xpath("(//input[@autocomplete='off'])[15]"));
//		//		sizef2.sendKeys(sizev);
//		//		
//		//		Thread.sleep(2000);
//		//		
//		//		Robot rb = new Robot();
//		//		rb.keyPress(KeyEvent.VK_ESCAPE);
//		//		rb.keyRelease(KeyEvent.VK_ESCAPE);
//		//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		//		jsExecutor.executeScript("arguments[0].value = 'Your Text Here';", sizef);
//		//		WebElement sellerf = driver.findElement(By.name("(//span[@class='s2bs5'])[3]"));
//		//		sellerf.click();
//		//		sellerf.sendKeys(sellerv);
//		//		WebElement dimensionsf = driver.findElement(By.name("(//span[@class='s2bs5'])[4]"));
//		//		dimensionsf.click();
//		//		dimensionsf.sendKeys(dimensionsv);
//		//		WebElement materialf = driver.findElement(By.name("(//span[@class='s2bs5'])[6]"));
//		//		materialf.click();
//		//		materialf.sendKeys(materialv);
//		//		WebElement conditionf = driver.findElement(By.name("(//span[@class='s2bs5'])[7]"));
//		//		conditionf.click();
//		//		conditionf.sendKeys(conditionv);
//		//		WebElement colorf = driver.findElement(By.name("(//span[@class='s2bs5'])[8]"));
//		//		colorf.click();
//		//		colorf.sendKeys(colorv);
//		//		WebElement designerf = driver.findElement(By.name("(//span[@class='s2bs5'])[9]"));
//		//		designerf.click();
//		//		designerf.sendKeys(designerv);

	}
}

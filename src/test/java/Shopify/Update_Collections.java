package Shopify;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Update_Collections {

	public static  WebDriver driver;
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setup() throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://admin.shopify.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.name("account[email]")).sendKeys("styletribute.shopify@gmail.com");
		WebElement submit1 = driver.findElement(By.name("commit"));
		wait.until(ExpectedConditions.elementToBeClickable(submit1)).click();
		driver.findElement(By.name("account[password]")).sendKeys("Shopify@123");
		WebElement submit2 = driver.findElement(By.xpath("//button[.='Log in']"));
		wait.until(ExpectedConditions.elementToBeClickable(submit2)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='Polaris-Navigation__ItemInnerWrapper_1umqf'])[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/store/0619ef-2/collections']"))).click();
	}
	@Test
	public void collection() throws EncryptedDocumentException, IOException, InterruptedException {

		driver.findElement(By.xpath("(//span[@class='Polaris-Icon_yj27d Polaris-Icon--colorBase_nqlaq Polaris-Icon--applyColor_2y25n'])[2]")).click();
		for(int j=1; j<=100; j++) {
			driver.findElement(By.xpath("//input[@placeholder='Searching all collections']")).sendKeys("ALL");
			List<WebElement> searched_collections = driver.findElements(By.xpath("//tbody/tr"));
			int number = searched_collections.size();
			for(int i=1; i<=number; i++) {
				searched_collections.get(i).click();
				driver.findElement(By.xpath("//span[.='Add another condition']")).click();
				driver.findElement(By.xpath("//div[@class='Polaris-Scrollable_1ed9o Polaris-Scrollable--vertical_uiuuj']")).click();
				driver.findElement(By.xpath("//div[.='Product title']")).click();
				driver.findElement(By.xpath("//input[@name='ConditionField[1]']")).sendKeys("Zuhari");
				driver.findElement(By.xpath("/html/body/div/div[2]/div/div[4]/div/div/div[2]/div/div[2]/button")).click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/store/0619ef-2/collections']"))).click();
			}
		}
		//		int row=0;
		//		int column=2;
		//
		//		for(int j=1; j<=16; j++) {
		//
		//			FileInputStream filein = new FileInputStream("D:\\javanew\\Styletribute\\src\\test\\java\\Ayatana\\boook.xlsx");
		//			Workbook book = WorkbookFactory.create(filein);
		//
		//			//Product name
		//			Cell dename = book.getSheet("Sheet5").getRow(row).getCell(column);
		//			String style = dename.getStringCellValue();
		//
		//
		//
		//			int crow=0;
		//			int ccolumn=1;
		//
		//			for(int k=1; k<=6; k++) {
		//				Cell catname = book.getSheet("Sheet5").getRow(crow).getCell(ccolumn);
		//				String cname = catname.getStringCellValue();
		//
		//				for(int i=1; i<=1; i++) {	
		//
		//					//File input
		//					int a=i;
		//					String b = String.valueOf(a);
		//					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//					driver.findElement(By.xpath("//a[@href='/store/0619ef-2/collections/new']")).click();
		//					Thread.sleep(2000);
		//					//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/store/0619ef-2/collections/new']"))).click();
		////					if(b.contains("1")) {
		////						driver.findElement(By.name("title")).sendKeys(style);
		////						driver.findElement(By.xpath("//span[.='any condition']")).click();
		////						driver.findElement(By.id("ConditionField-0")).sendKeys(style+"_ALL");
		////					}
		////					if(b.contains("1")) {
		////						driver.findElement(By.name("title")).sendKeys(style+"_MEN");
		////						driver.findElement(By.xpath("//span[.='any condition']")).click();
		////						driver.findElement(By.id("ConditionField-0")).sendKeys(style+"_MEN_ALL");
		////					}
		//					if(b.contains("1")) {
		//						driver.findElement(By.name("title")).sendKeys(cname+"_"+style+"_WOMEN");
		//						driver.findElement(By.xpath("//span[.='any condition']")).click();
		//						driver.findElement(By.id("ConditionField-0")).sendKeys(cname+"_"+style+"_WOMEN_ALL");
		//					}
		//					//					else if(b.contains("4")) {
		//					//						driver.findElement(By.name("title")).sendKeys(cname+"_"+dname+"_BABY");
		//					//						driver.findElement(By.xpath("//span[.='any condition']")).click();
		//					//						driver.findElement(By.id("0-ConditionField")).sendKeys(cname+"_"+dname+"_BABY_ALL");
		//					//					}
		//					//					else if(b.contains("5")) {
		//					//						driver.findElement(By.name("title")).sendKeys(cname+"_"+dname+"_BOY");
		//					//						driver.findElement(By.xpath("//span[.='any condition']")).click();
		//					//						driver.findElement(By.id("0-ConditionField")).sendKeys(cname+"_"+dname+"_BOY_ALL");
		//					//					}
		//					//					else {
		//					//						driver.findElement(By.name("title")).sendKeys(cname+"_"+dname+"_GIRL");
		//					//						driver.findElement(By.xpath("//span[.='any condition']")).click();
		//					//						driver.findElement(By.id("0-ConditionField")).sendKeys(cname+"_"+dname+"_GIRL_ALL");
		//					//				}
		//					Thread.sleep(1000);
		//					driver.findElement(By.xpath("/html/body/div/div[2]/div/div[4]/div/div/div[2]/div/div[2]/button")).click();
		//					Thread.sleep(1000);
		//					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/store/0619ef-2/collections']"))).click();
		//					Thread.sleep(2000);
		//				}
		//				crow++;
		//			}
		//			System.out.println(style);
		//			row++;
		//		}	

	}
}


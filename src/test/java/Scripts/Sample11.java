package Scripts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample11 {
	public static  WebDriver driver;

	@Test
	@SuppressWarnings("deprecation")
	public void setup() throws EncryptedDocumentException, IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://styletribute.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Login
		driver.findElement(By.xpath("/html/body/header-nav/div[1]/div/div[3]/div/a[1]")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("nandeesh@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456789");
		driver.findElement(By.xpath("/html/body/div[2]/modal-window/form[2]/div[3]/st-button/button/span/ng-transclude/span")).click();

		ArrayList<String> urls = new ArrayList<String>();

		urls.add("https://styletribute.com/s/men/shoes?page=1");
		urls.add("https://styletribute.com/s/men/shoes?page=2");
		urls.add("https://styletribute.com/s/men/shoes?page=3");
		urls.add("https://styletribute.com/s/men/shoes?page=4");
		urls.add("https://styletribute.com/s/men/shoes?page=5");

		int row = 0;
		int column = 0;

		for(int j=0; j<urls.size(); j++) {
			
			driver.get(urls.get(j));
			//To scroll to end of the screen
			//			JavascriptExecutor js = (JavascriptExecutor) driver;
			//	        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			List<WebElement> ProductNames = driver.findElements(By.xpath("//div[@class='name ng-binding']"));
			List<WebElement> Productimages = driver.findElements(By.xpath("//span/a/div/img[2]"));
			List<WebElement> Designers = driver.findElements(By.xpath("//div[@class='designer ng-binding ng-scope']"));
			//				List<WebElement> Discountdetails = driver.findElements(By.xpath("//div[@class='condition ng-binding']"));
			//				List<WebElement> Finalprice = driver.findElements(By.xpath("//div[contains(@class,'price ng-isolate-scope')]"));
			List<WebElement> ProductSize = driver.findElements(By.xpath("//div[@class='size ng-binding ng-scope']"));

			for(int i=0; i<ProductNames.size(); i++) {

				String products = ProductNames.get(i).getText();
				String images = Productimages.get(i).getAttribute("src");
				String designers = Designers.get(i).getText();
				//					String discounts = Discountdetails.get(i).getText();
				//					String prices = Finalprice.get(i).getText();
				String size = ProductSize.get(i).getText();

				FileInputStream filein = new FileInputStream("D:\\javanew\\Styletribute\\src\\test\\java\\Scripts\\Products.xlsx");
				Workbook book = WorkbookFactory.create(filein);

				Cell productname = book.getSheet("Sheet1").createRow(row).createCell(column);
				productname.setCellValue(products);

				Cell imageurl = book.getSheet("Sheet2").createRow(row).createCell(column);
				imageurl.setCellValue(images);

				Cell designer = book.getSheet("Sheet3").createRow(row).createCell(column);
				designer.setCellValue(designers);

				//					if(discounts.isEmpty()) {
				//						Cell price = book.getSheet("Sheet4").createRow(row).createCell(column);
				//						price.setCellValue(prices);
				//					}
				//					else {
				//						Cell price = book.getSheet("Sheet4").createRow(row).createCell(column);
				//						price.setCellValue(prices+" + "+discounts);
				//					}

				Cell Size = book.getSheet("Sheet5").createRow(row).createCell(column);
				Size.setCellValue(size);

				FileOutputStream fileout = new FileOutputStream("D:\\javanew\\Styletribute\\src\\test\\java\\Scripts\\Products.xlsx");
				book.write(fileout);
				row++;
			}
		}


		driver.quit();
	}
}
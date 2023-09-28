package Scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import Data.Initialize_Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Tests {
	
	public static  WebDriver driver;
	ExtentSparkReporter sparkreporter;
	ExtentReports extent;
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setup() {
		
		sparkreporter = new ExtentSparkReporter("reports/Test_report-Login.html");
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		
		sparkreporter.config().setDocumentTitle("Style tribute testing report");
		sparkreporter.config().setReportName("Test report");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://styletribute.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void quitBrowser() {
		extent.flush();
		driver.quit();
	}

	@BeforeMethod
	public void beforeTest() throws InterruptedException {

		Thread.sleep(1000);
		Testing elements = new Testing(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", elements.loginbutton);
	}

	@Test(priority = 1)
	public void validCredentials() throws InterruptedException {

		extent.createTest("Test with valid credentials", "Description of test");
		Testing elements = new Testing(driver);
		Initialize_Utilities data = new Initialize_Utilities();
		Thread.sleep(1000);
		elements.emailfield.sendKeys(data.getEmail());
		elements.passwordfield.sendKeys(data.getPassword());
		elements.login.click();
		Thread.sleep(2000);
		Assert.assertTrue(elements.my_account.isDisplayed(), "Test failed - Login failed");
	}

	@Test(priority = 2)
	public void invalidCredentials() throws InterruptedException {

		extent.createTest("Test with invalid credentials", "Description of test2");
		Testing elements = new Testing(driver);
		Initialize_Utilities data = new Initialize_Utilities();
		Thread.sleep(1000);
		elements.emailfield.sendKeys(data.getInvalidEmailLogin());
		elements.passwordfield.sendKeys(data.getInvalidPassword());
		elements.login.click();
		Thread.sleep(1000);
		Assert.assertTrue(elements.signin_window.getText().contains("Invalid username or password!"), "Test failed - Error message not matching");
	}


	@AfterMethod
	public void afterTest() throws InterruptedException {

		Testing elements = new Testing(driver);
		String homepage = driver.getPageSource();

		if(homepage.contains("My Account")) {
			elements.my_account.click();
			Thread.sleep(1000);
			elements.logout.click();
		}
		else {
			driver.navigate().refresh();
			Thread.sleep(2000);
		}
	}
}

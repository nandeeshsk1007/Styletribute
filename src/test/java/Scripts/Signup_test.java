package Scripts;

import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;
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

public class Signup_test {

	public static  WebDriver driver;
	ExtentSparkReporter sparkreporter;
	ExtentReports extent;
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setup() {
		
		sparkreporter = new ExtentSparkReporter("reports/Test_report-Signup.html");
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
		js.executeScript("arguments[0].click();", elements.signupbutton);
	}

	@Test(priority = 1)
	public void validDetails() throws InterruptedException {

		extent.createTest("Test with valid details", "Testing signup");
		Testing elements = new Testing(driver); 
		Initialize_Utilities data = new Initialize_Utilities();
		Thread.sleep(1000);
//		SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//		Date date = new Date();
//		String dateandtime = dateformat.format(date);
		String value = RandomStringUtils.randomAlphabetic(4);
		elements.emailfield.sendKeys(value+data.getEmail());
		elements.passwordfield.sendKeys(data.getPassword());
		elements.verifypasswordfield.sendKeys(data.getVerifyPassword());
		elements.signup.click();
		Thread.sleep(2000);
		Assert.assertTrue(elements.my_account.isDisplayed(), "Test failed - signup failed");
	}

	@Test(priority = 2)
	public void invalidEmailid() throws InterruptedException {

		extent.createTest("Test with invalid emailid", "Testing signup");
		Testing elements = new Testing(driver);
		Initialize_Utilities data = new Initialize_Utilities();
		Thread.sleep(1000);
		elements.emailfield.sendKeys(data.getInvalidEmailSignup());
		elements.passwordfield.sendKeys(data.getPassword());
		elements.verifypasswordfield.sendKeys(data.getVerifyPassword());
		elements.signup.click();
		Thread.sleep(1000);
		Assert.assertTrue(elements.signup_window.getText().contains("The email must be a valid email address."), "Test failed - Error message not matching");
	}

	@Test(priority = 3)
	public void passwordMismatch() throws InterruptedException {

		extent.createTest("Test with password mismatch", "Testing signup");
		Testing elements = new Testing(driver);
		Initialize_Utilities data = new Initialize_Utilities();
		Thread.sleep(1000);
		elements.emailfield.sendKeys(data.getInvalidEmailSignup());
		elements.passwordfield.sendKeys(data.getPassword());
		elements.verifypasswordfield.sendKeys(data.getVerifyInvalidPassword());
		elements.signup.click();
		Thread.sleep(1000);
		Assert.assertTrue(elements.signup_window.getText().contains("Password not match"), "Test failed - Error message not matching");
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

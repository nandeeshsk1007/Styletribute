package Scripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Data.Initialize_Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {

	//Login screen
	@FindBy (xpath = "/html/body/header-nav/div[1]/div/div[3]/div/a[1]")
	public WebElement loginbutton;
	@FindBy (xpath = "/html/body/header-nav/div[1]/div/div[3]/div/a[2]")
	public WebElement signupbutton;
	@FindBy (xpath = "//input[@name='email']")
	public WebElement emailfield;
	@FindBy (xpath = "//input[@name='password']")
	public WebElement passwordfield;
	@FindBy (xpath = "//input[@name='verifypassword']")
	public WebElement verifypasswordfield;
	@FindBy (xpath = "/html/body/div[2]/modal-window/form[2]/div[3]/st-button/button/span/ng-transclude/span")
	public WebElement login;
	@FindBy (xpath = "/html/body/div[2]/modal-window/form/div[4]/st-button/button/span/ng-transclude/span")
	public WebElement signup;
	@FindBy (xpath = "//form[@class='ng-valid ng-dirty ng-valid-parse ng-submitted']")
	public WebElement signin_window;
	@FindBy (xpath = "//div[@class='st-modal show']")
	public WebElement signup_window;
	
	//Home screen
	@FindBy (xpath = "//a[.='My Account']")
	public WebElement my_account;
	@FindBy (xpath = "//a[.='Log out']")
	public WebElement logout;
	@FindBy (xpath = "(//a[.='Men'])[2]")
	public WebElement Men_option;
	@FindBy (xpath = "//a[.='New arrivals']")
	public WebElement New_arrivals_option;
	@FindBy (xpath = "(//a[.='Women'])[2]")
	public WebElement Women_option;
	@FindBy (xpath = "(//a[.='Bags'])[2]")
	public WebElement Bags_option;
	@FindBy (xpath = "(//a[.='Kids'])[2]")
	public WebElement Kids_option;
	@FindBy (xpath = "//a[.='Fashion for Good']")
	public WebElement Fashion_for_good_option;
	@FindBy (xpath = "//a[.='Designers']")
	public WebElement Designers_option;
	@FindBy (xpath = "(//a[.='Blog'])[2]")
	public WebElement Blog_option;

	//Men's shopping
	@FindBy (xpath = "(//label[.='10%'])[1]")
	private WebElement percent_10;
	@FindBy (xpath = "(//label[.='15%'])[1]")
	private WebElement percent_15;
	@FindBy (xpath = "(//label[.='25%'])[1]")
	private WebElement percent_25;
	@FindBy (xpath = "(//label[.='30%'])[1]")
	private WebElement percent_30;
	@FindBy (xpath = "(//label[.='40%'])[1]")
	private WebElement percent_40;
	@FindBy (xpath = "(//label[.='50%'])[1]")
	private WebElement percent_50;
	@FindBy (xpath = "(//label[.='60%'])[1]")
	private WebElement percent_60;
	@FindBy (xpath = "(//label[.='70%'])[1]")
	private WebElement percent_70;

	//Categories
	@FindBy (xpath = "/html/body/main/div/product-page/div[1]/div/elasticsearch-filter-container/div[1]/elasticsearch-filter-section[2]/div[2]/div/category-tree/ul[1]/li/ul/li[1]/a")
	private WebElement category_accessories;
	@FindBy (xpath = "/html/body/main/div/product-page/div[1]/div/elasticsearch-filter-container/div[1]/elasticsearch-filter-section[2]/div[2]/div/category-tree/ul[1]/li/ul/li[2]/a")
	private WebElement category_bags;
	@FindBy (xpath = "/html/body/main/div/product-page/div[1]/div/elasticsearch-filter-container/div[1]/elasticsearch-filter-section[2]/div[2]/div/category-tree/ul[1]/li/ul/li[3]/a")
	private WebElement category_clothing;
	@FindBy (xpath = "/html/body/main/div/product-page/div[1]/div/elasticsearch-filter-container/div[1]/elasticsearch-filter-section[2]/div[2]/div/category-tree/ul[1]/li/ul/li[4]/a")
	private WebElement category_jewellery;
	@FindBy (xpath = "/html/body/main/div/product-page/div[1]/div/elasticsearch-filter-container/div[1]/elasticsearch-filter-section[2]/div[2]/div/category-tree/ul[1]/li/ul/li[5]/a")
	private WebElement category_shoes;

	//	@FindBy (xpath = "/html/body/main/div/product-page/div[1]/div/elasticsearch-filter-container/div[1]/elasticsearch-filter-section[1]/div[2]/div/filter-checkbox/ol")
	//	private static WebElement designer_options;

	//printed tie product
	@FindBy (xpath = "//div[.='Printed Tie']")
	private WebElement printed_tie;

	//Add to cart
	@FindBy (xpath = "//div[@class='side-details']")
	private WebElement side_details;
	@FindBy (xpath = "//button[@class='primary btn-add-to-cart hasicon']")
	private WebElement add_to_cart_button;

	//Close add to cart
	@FindBy (xpath = "/html/body/header-nav/div[2]/div/div[3]/span/span")
	private WebElement cart_window;
	//Home
	@FindBy (xpath = "//img[@src='/images/logo.svg']")
	private WebElement home_logo;	
	
	public Testing(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//	public void login() throws InterruptedException{
	//		loginbutton.click();
	//		driver.switchTo().alert();
	//		emailfield.sendKeys("nandeesh@gmail.com");
	//		passwordfield.sendKeys("123456789");
	//		login.click();
	//	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://styletribute.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		Testing all = new Testing(driver);
		all.loginbutton.click();
		Thread.sleep(1000);

		//Data
		Thread.sleep(2000);
		Initialize_Utilities details = new Initialize_Utilities();

		all.emailfield.sendKeys(details.getEmail());
		all.passwordfield.sendKeys(details.getPassword());
		all.login.click();

		//Checking Category
		if(details.getCategory().contentEquals("Men"))
		{
			all.Men_option.click();
		}
		else if (details.getCategory().contentEquals("New arrivals")) {
			all.New_arrivals_option.click();
		}
		else if (details.getCategory().contentEquals("Women")) {
			all.Women_option.click();
		}
		else if (details.getCategory().contentEquals("Kids")) {
			all.Kids_option.click();
		}
		else if (details.getCategory().contentEquals("Bags")) {
			all.Bags_option.click();
		}
		else if (details.getCategory().contentEquals("Fashion for Good")) {
			all.Fashion_for_good_option.click();
		}
		else if (details.getCategory().contentEquals("Designers")) {
			all.Designers_option.click();
		}
		else if (details.getCategory().contentEquals("Blog")) {
			all.Blog_option.click();
		}
		else {
			System.out.print("No matching category");
		}

		//Checking discounts
		Thread.sleep(2000);
		if(details.getDiscount().contentEquals("10%")) {
			all.percent_10.click();
		}
		else if(details.getDiscount().contentEquals("15%")) {
			all.percent_15.click();
		}
		else if(details.getDiscount().contentEquals("25%")) {
			all.percent_25.click();
		}
		else if (details.getDiscount().contentEquals("30%")) {
			all.percent_30.click();
		}
		else if (details.getDiscount().contentEquals("40%")) {
			all.percent_40.click();
		}
		else if (details.getDiscount().contentEquals("50%")) {
			all.percent_50.click();
		}
		else if (details.getDiscount().contentEquals("60%")) {
			all.percent_60.click();
		}
		else if (details.getDiscount().contentEquals("70%")) {
			all.percent_70.click();
		}
		else {
			System.out.println("No matching dicount");
		}


		//Checking sub categories
		Thread.sleep(2000);
		if(details.getSubcatogory().contentEquals("ACCESSORIES")){
			all.category_accessories.click();
		}
		else if(details.getSubcatogory().contentEquals("BAGS")){
			all.category_bags.click();
		}
		else if(details.getSubcatogory().contentEquals("CLOTHING")){
			all.category_clothing.click();
		}
		else if(details.getSubcatogory().contentEquals("JEWELLERY")){
			all.category_jewellery.click();
		}
		else if(details.getSubcatogory().contentEquals("SHOES")){
			all.category_shoes.click();
		}
		else {
			System.out.println("The sub-category not exist");
		}

		//		Select options = new Select(designer_options);
		//		List<WebElement> all_options = options.getOptions();
		//		for(WebElement opt:all_options) {
		//			String a = opt.getText();
		//			System.out.println(a);
		//		}

		//product - printed tie
		Thread.sleep(2000);
		if (details.getProduct().contentEquals("Printed Tie")) {
			all.printed_tie.click();
		}
		else {
			System.out.println("Product does not exist");
		}

		//Add to cart
		Thread.sleep(2000);
		String side_details_text = all.side_details.getText();
		if(side_details_text.contains("ADD TO BAG")){
			all.add_to_cart_button.click();
			Thread.sleep(2000);
			String page_source_cart = driver.getPageSource();

			if(page_source_cart.contains("Printed Tie") && page_source_cart.contains("Buy Now")) {
				System.out.println("The product is added to cart");
				Thread.sleep(2000);
				all.cart_window.click();
			}
			else {
				System.out.println("The product is not added to cart");
			}
		}
		else {
			System.out.println("The product is already in cart");
		}

		//Home
		Thread.sleep(2000);
		all.home_logo.click();
		
		Thread.sleep(2000);
		driver.quit();
		
	}
}
